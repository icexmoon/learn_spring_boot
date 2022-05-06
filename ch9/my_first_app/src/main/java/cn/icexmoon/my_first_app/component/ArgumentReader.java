package cn.icexmoon.my_first_app.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class ArgumentReader {
    @Autowired
    public ArgumentReader(ApplicationArguments args){
        if(args.containsOption("test")){
            System.out.println("test is find.");
            System.out.println(args.getNonOptionArgs());
        }
    }
}
