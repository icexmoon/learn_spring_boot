package com.example.resource.controller;

import com.example.resource.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : resource
 * @Package : com.example.resource.controller
 * @ClassName : .java
 * @createTime : 2023/5/13 16:20
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/hello")
public class HelloController implements ResourceLoaderAware {
    @Autowired
    private ApplicationContext ctx;
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private ResourcePatternResolver resourcePatternResolver;
    @Value("${my.properties}")
    @Autowired
    private Resource resource;
    @Value("${my.all.properties}")
    @Autowired
    private Resource[] resources;

    @GetMapping("")
    public String hello() throws IOException {
//        Resource resource = new ClassPathResource("override.properties");
//        Resource resource = new FileSystemResource("src/main/resources/override.properties");
//        Resource resource = new FileSystemResource("D:/workspace/learn_spring_boot/ch28/resource/src/main/resources/override.properties");
//        Resource resource = new UrlResource("https://blog.icexmoon.cn/");
//        Resource resource = new UrlResource("file://D:/workspace/learn_spring_boot/ch28/resource/src/main/resources/override.properties");
//        Resource resource = ctx.getResource("classpath:override.properties");
//        Resource resource = resourceLoader.getResource("classpath:override.properties");
//        Resource[] resources = resourcePatternResolver.getResources("classpath:*.properties");
        for (Resource r : resources) {
            System.out.println(r.getFilename());
        }
        if (resources == null || resources.length == 0) {
            return Result.fail("没有获取到文件").toString();
        }
        Resource resource = resources[0];
        printContent(resource);
        return Result.success().toString();
    }

    private void printContent(Resource resource) throws IOException {
        File file;
        try {
            file = resource.getFile();
        } catch (FileNotFoundException e) {
            String content = resource.getContentAsString(StandardCharsets.UTF_8);
            System.out.println(content);
            return;
        }
        printContent(file);
    }

    private void printContent(File file) throws IOException {
        FileReader fr;
        fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        do {
            line = br.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
        while (true);
        br.close();
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        Resource resource = resourceLoader.getResource("classpath:override.properties");
        try {
            printContent(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
