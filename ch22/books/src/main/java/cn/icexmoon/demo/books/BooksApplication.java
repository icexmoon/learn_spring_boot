package cn.icexmoon.demo.books;

import lombok.extern.log4j.Log4j2;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("cn.icexmoon.demo.books.*.mapper")
@Log4j2
public class BooksApplication {
    public static void main(String[] args) {

        SpringApplication.run(BooksApplication.class, args);

    }

//    @Bean
//    public CommandLineRunner init(final RepositoryService repositoryService,
//                                  final RuntimeService runtimeService,
//                                  final TaskService taskService
//    ) {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
////                System.out.println("Number of process definitions : "
////                        + repositoryService.createProcessDefinitionQuery().count());
////                System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
////                runtimeService.startProcessInstanceByKey("oneTaskProcess");
////                System.out.println("Number of tasks after process start: " + taskService.createTaskQuery().count());
//                repositoryService.createDeployment()
//                        .addClasspathResource("processes/diagram.bpmn")
//                        .key("Process_0wu4lop")
//                        .name("示例流程")
//                        .deploy();
//                log.debug("流程{}已部署", "示例流程");
//            }
//        };
//    }

}
