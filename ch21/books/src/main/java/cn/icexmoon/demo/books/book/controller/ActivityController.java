package cn.icexmoon.demo.books.book.controller;

import cn.icexmoon.demo.books.book.service.IActivitiService;
import cn.icexmoon.demo.books.system.result.IResult;
import cn.icexmoon.demo.books.system.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.experimental.Accessors;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.book.controller
 * @ClassName : .java
 * @createTime : 2022/9/1 16:51
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/activiti")
@Api(tags = "Activiti示例接口")
public class ActivityController {
    @Autowired
    private IActivitiService activitiService;

    @Data
    @Accessors(chain = true)
    private static class StartProcessVO implements IResult {
        private String id;
        private String name;
        private String deploymentId;
        private String processDefinitionId;
        private String startUserId;
        private String processDefinitionName;

        public static StartProcessVO newInstance(ProcessInstance pi) {
            StartProcessVO vo = new StartProcessVO();
            return vo.setId(pi.getId())
                    .setName(pi.getName())
                    .setDeploymentId(pi.getDeploymentId())
                    .setProcessDefinitionId(pi.getProcessDefinitionId())
                    .setStartUserId(pi.getStartUserId())
                    .setProcessDefinitionName(pi.getProcessDefinitionName());
        }
    }

    @ApiOperation("启动流程实例")
    @PostMapping("/process/start/{key}")
    public StartProcessVO startProcess(@ApiParam("流程key") @PathVariable String key) {
        ProcessInstance pi = activitiService.startProcessInstance(key);
        return StartProcessVO.newInstance(pi);
    }

    @Data
    @Accessors(chain = true)
    private static class GetProcessDefineListVO {
        @ApiModelProperty("部署流程时的deployment的id，可以用于删除流程部署")
        private String deploymentId;
        @ApiModelProperty("流程定义id")
        private String id;
        @ApiModelProperty("流程定义名称")
        private String name;
        @ApiModelProperty("流程的key")
        private String key;
        @ApiModelProperty("bpmn资源文件名称")
        private String resourceName;
        @ApiModelProperty("流程定义版本")
        private Integer version;

        public static GetProcessDefineListVO newInstance(ProcessDefinition pd) {
            GetProcessDefineListVO vo = new GetProcessDefineListVO();
            vo.setId(pd.getId())
                    .setName(pd.getName())
                    .setDeploymentId(pd.getDeploymentId())
                    .setKey(pd.getKey())
                    .setResourceName(pd.getResourceName())
                    .setVersion(pd.getVersion());
            return vo;
        }
    }

    @ApiOperation("获取流程定义列表")
    @PostMapping("/process-define/list")
    public List<GetProcessDefineListVO> getProcessDefineList() {
        List<ProcessDefinition> pds = activitiService.listProcessDefinition();
        List<GetProcessDefineListVO> vo = pds.stream().map(pd -> GetProcessDefineListVO.newInstance(pd)).collect(Collectors.toList());
        return vo;
    }

    @Data
    private static class DeployProcessDTO {
        @ApiModelProperty(value = "流程定义资源文件（bpmn文件的classPath路径）", required = true, example = "processes/diagram.bpmn")
        @NotBlank
        private String classPathResource;
        @ApiModelProperty(value = "流程key（bpmn文件中流程的key）", required = true, example = "Process_0wu4lop")
        @NotBlank
        private String key;
        @ApiModelProperty(value = "部署后的流程名称，可以为null", example = "A example process")
        private String name;
    }

    @ApiOperation("部署流程")
    @PostMapping("/deploy")
    public Result deployProcess(@RequestBody DeployProcessDTO dto) {
        activitiService.deploy(dto.getClassPathResource(), dto.getKey(), dto.getName());
        return Result.success();
    }

    @Data
    private static class DelDeploymentDTO {
        @ApiModelProperty(value = "是否级联删除，默认为false", example = "false")
        private Boolean cascadeDel;

        private void checkDefault() {
            if (this.cascadeDel == null) {
                this.cascadeDel = false;
            }
        }
    }

    @ApiOperation("删除流程部署")
    @PostMapping("/deployment/del/{id}")
    public Result delDeployment(@ApiParam(value = "部署id", example = "27501") @PathVariable String id,
                                @Validated @RequestBody DelDeploymentDTO dto) {
        dto.checkDefault();
        activitiService.delDeployment(id, dto.getCascadeDel());
        return Result.success();
    }
}
