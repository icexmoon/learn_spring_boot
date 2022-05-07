package cn.icexmoon.my_first_app.component;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CommnadLineProcessor implements ApplicationRunner{
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("CommnadLineProcessor is triggered.");
        System.out.println(args.getSourceArgs());
    }
}
