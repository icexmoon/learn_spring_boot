package cn.icexmoon.my_first_app.service;

import cn.icexmoon.my_first_app.mapper.AccountMapper;
import cn.icexmoon.my_first_app.model.Account;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public Account getAcountByName(String name) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username", name);
        return accountMapper.selectOne(wrapper);
    }
}
