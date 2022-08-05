package cn.icexmoon.demo.books.system.swagger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.system
 * @ClassName : .java
 * @createTime : 2022/7/2 20:17
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Slf4j
@Configuration
@EnableOpenApi
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "dev", matchIfMissing = true)
public class SwaggerConfig {

    /**
     * 创建swagger API文档，访问地址http://host:port/productName/swagger-ui/
     * <p>1、apiInfo()：增加API相关的信息.
     * <p>2、select()：返回ApiSelectorBuilder实例，用于控制哪些接口暴露给swagger来展现.
     * <p>3、apis()：指定扫描的路径来指定要建立的API目录.
     * RequestHandlerSelectors 用于配置要扫描的包，以下参数可选：
     * basePackage()：指定要扫描的包.
     * any()：扫描全部.
     * none()：都不扫描.
     * withMethodAnnotation：扫描方法上的注解, 参数是一个注解的反射对象.
     * withClassAnnotation：扫描类上的注解, 参数是一个注解的反射对象.
     * 例如：withClassAnnotation(RestController .class) 只扫描类上有@RestController的生成文档.
     * <p>4、paths()：过滤什么路径.
     */
    @Bean
    public Docket createApi() {
        log.info("====> [Swagger3]开启.");
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("图书管理系统")
                .description("这是一个示例用的图书管理系统")
                .contact(new Contact("icexmoon", "icexmoon.cn", "icexmoon@qq.com"))
                .version("1.0")
                .license("版权所有©icexmoon")
                .build();
    }
}