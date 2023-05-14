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
 * @createTime : 2022/9/8 15:49
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Log4j2
public class MyTestTask3 implements JavaDelegate {
    private Expression text2;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        log.info("MyTestTask3 is executed.");
        String value = (String) this.text2.getValue(delegateExecution);
        log.info("get text2's value:" + value);
        String textVal = (String) delegateExecution.getVariable("text");
        textVal += value;
        delegateExecution.setVariable("text", textVal);
        log.info("finally, the text's value is:" + textVal);
    }
}
