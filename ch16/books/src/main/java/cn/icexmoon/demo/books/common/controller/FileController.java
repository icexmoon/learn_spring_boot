package cn.icexmoon.demo.books.common.controller;

import cn.icexmoon.demo.books.system.SysProperties;
import cn.icexmoon.demo.books.system.result.IResult;
import cn.icexmoon.demo.books.system.result.Result;
import cn.icexmoon.demo.books.system.result.ResultException;
import cn.icexmoon.demo.books.system.util.MyFileUtil;
import cn.icexmoon.demo.books.system.util.MyStringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ch14
 * @Package : cn.icexmoon.demo.books.common.controller
 * @ClassName : .java
 * @createTime : 2022/8/1 14:30
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Api(tags = "文件上传")
@RestController
@RequestMapping("/common/file")
public class FileController {
    @Autowired
    private MyFileUtil myFileUtil;
    @Autowired
    private SysProperties sysProperties;

    @ApiModel(description = "上传文件成功后返回的VO")
    @Data
    private static class FileUploadVO implements IResult {
        String url;
    }

    @ApiOperation(value = "文件上传")
    @PostMapping(value = "/upload")
    public FileUploadVO fileUpload(
            MultipartFile file) {
        if (file == null) {
            throw new ResultException(Result.ErrorCode.PARAM_CHECK, "没有文件需要上传");
        }
        try {
            //使用文件名+时间戳作为新的文件名进行保存
            String originalFileName = file.getOriginalFilename();
            String fileEnd = myFileUtil.getFileSuffix(originalFileName);
            if (fileEnd.isEmpty()) {
                throw new ResultException(Result.ErrorCode.PARAM_CHECK, "文件缺少后缀名");
            }
            String newFileName = System.currentTimeMillis() + MyStringUtil.genRandomCode(5) + '.' + fileEnd;
            String filePath = sysProperties.getUploadPath();
            String pathstr = filePath + newFileName;
            //使用临时文件保存上传的文件内容
            File tempFile = new File(System.getProperty("java.io.tmpdir"), newFileName);
            file.transferTo(tempFile);
            try {
                if (!myFileUtil.isImage(tempFile)) {
                    throw new ResultException(Result.ErrorCode.PARAM_CHECK, "只能上传图片");
                } else {
                    FileCopyUtils.copy(new FileInputStream(tempFile), Files.newOutputStream(Paths.get(pathstr), StandardOpenOption.CREATE_NEW));
                }
            } finally {
                //删除临时文件
                tempFile.delete();
            }
            FileUploadVO vo = new FileUploadVO();
            String port = sysProperties.getPort();
            String host = sysProperties.getHost();
            if (sysProperties.getEvn().equals("prd")) {
                //生产环境有代理，不需要指定端口
                vo.setUrl(String.format("http://%s/image/%s", host, newFileName));
            } else {
                vo.setUrl(String.format("http://%s:%s/image/%s", host, port, newFileName));
            }
            return vo;
        } catch (IOException | SecurityException e) {
            throw new ResultException(Result.ErrorCode.DEFAULT_ERROR, "文件上传出错");
        }
    }
}
