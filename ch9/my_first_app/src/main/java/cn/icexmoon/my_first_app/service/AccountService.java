package cn.icexmoon.my_first_app.service;

import cn.icexmoon.my_first_app.model.Account;

public interface AccountService {
    Account getAcountByName(String name);
}
