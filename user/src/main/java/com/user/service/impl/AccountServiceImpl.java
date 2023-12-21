package com.user.service.impl;

import com.user.model.Account;
import com.user.service.AccountService;
import com.user.service.feing.AccountServiceFeing;
import com.user.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountServiceFeing accountService;

    @Autowired
    private ClientService clientService;


    @Override
    public Account register(Account account) {
        clientService.getById(account.getIdClient());
        return accountService.register(account);
    }

    @Override
    public Account update(Account account) {
        return accountService.update(account);
    }

    @Override
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @Override
    public Account getById(Integer id) {
        return accountService.getById(id);
    }

    @Override
    public void delete(Integer id) {
        accountService.delete(id);
    }
}
