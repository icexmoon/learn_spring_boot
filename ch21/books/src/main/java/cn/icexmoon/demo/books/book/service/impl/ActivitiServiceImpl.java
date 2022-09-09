package cn.icexmoon.demo.books.book.service.impl;

import cn.icexmoon.demo.books.book.service.IActivitiService;
import lombok.extern.log4j.Log4j2;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.book.service.impl
 * @ClassName : .java
 * @createTime : 2022/9/7 17:14
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Log4j2
@Service
public class ActivitiServiceImpl implements IActivitiService {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RuntimeService runtimeService;


    @Override
    public void deploy(String classPathResource, String key, String name) {
        log.info("========开始部署流程=======");
        log.info("资源路径：" + classPathResource);
        log.info("key：" + key);
        log.info("名称：" + name);
        DeploymentBuilder deployment = repositoryService.createDeployment();
        deployment
                .addClasspathResource(classPathResource)
                .key(key)
                .name(name)
                .deploy();
        log.info("=======流程已部署=========");
    }

    @Override
    public ProcessInstance startProcessInstance(String processKey) {
        logInfo();
        ProcessInstance process = runtimeService.startProcessInstanceByKey(processKey);
        log.info("流程" + processKey + "已启动一个新实例");
        logInfo();
        return process;
    }

    @Override
    public void logInfo() {
        log.info("======Activiti系统信息======");
        log.info("当前系统中定义流程数：" + repositoryService.createProcessDefinitionQuery().count());
        log.info("当前系统中的任务数：" + taskService.createTaskQuery().count());
        log.info("======Activiti系统信息======");
    }

    @Override
    public List<ProcessDefinition> listProcessDefinition() {
        return repositoryService.createProcessDefinitionQuery().list();
    }

    @Override
    public void delDeployment(String deploymentId, boolean cascadeDel) {
        repositoryService.deleteDeployment(deploymentId, cascadeDel);
    }
}
