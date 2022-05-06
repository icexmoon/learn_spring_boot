package cn.icexmoon.my_first_app.controller;

import cn.icexmoon.my_first_app.service.AccountServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final AccountServiceImpl accountService;
    public AccountController(AccountServiceImpl accountService){
        this.accountService = accountService;
    }

}
