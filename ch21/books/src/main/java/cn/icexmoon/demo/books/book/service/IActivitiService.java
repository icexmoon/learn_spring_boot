package cn.icexmoon.demo.books.book.service;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.book.service
 * @ClassName : .java
 * @createTime : 2022/9/7 17:13
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface IActivitiService {
    /**
     * 部署流程
     *
     * @param classPathResource 资源路径，如processes/diagram.bpmn
     * @param key               流程key，如Process_0wu4lop
     * @param name              流程名称，如示例流程
     */
    void deploy(String classPathResource, String key, String name);

    /**
     * 启动一个流程实例
     *
     * @param processKey 流程key
     */
    ProcessInstance startProcessInstance(String processKey);

    /**
     * 将Activiti系统信息输出到日志
     */
    void logInfo();

    /**
     * 获取流程定义列表
     *
     * @return
     */
    List<ProcessDefinition> listProcessDefinition();

    /**
     * 删除部署
     * @param deploymentId 部署id
     */
    void delDeployment(String deploymentId, boolean cascadeDel);
}
