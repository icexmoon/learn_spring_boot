package cn.icexmoon.demo.books.book.entity.task;

import lombok.extern.log4j.Log4j2;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.book.entity.task
 * @ClassName : .java
 * @createTime : 2022/9/8 15:48
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Log4j2
public class MyTestTask2 implements JavaDelegate {
    private Expression text1;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        log.info("MyTestTask2 is executed.");
        String value = (String) this.text1.getValue(delegateExecution);
        log.info("get text1's value:" + value);
        delegateExecution.setVariable("text", value);
    }
}
