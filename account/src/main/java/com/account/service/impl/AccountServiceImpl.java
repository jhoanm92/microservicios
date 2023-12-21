package com.account.service.impl;

import com.account.entity.Account;
import com.account.entity.Movement;
import com.account.entity.MovementType;
import com.account.exception.ModeloNotFoundException;
import com.account.repository.AccountRepository;
import com.account.repository.MovementRepository;
import com.account.service.AccountService;
import com.account.service.MovementService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MovementService movementService;

    @Override
    @Transactional
    public Account register(Account account) {
        Movement movement = new Movement();
        account.setState(Boolean.TRUE);
        Account accountCreated =  accountRepository.save(account);

        movement.setAccount(account);
        movement.setAmmount(account.getInitBalance());

        movementService.register(movement);
        return this.update(accountCreated);
    }

    @Override
    public Account update(Account account) {
        this.getById(account.getAccountNumber());
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account getById(Integer id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ModeloNotFoundException("ID NOT FOUND " + id));
    }

    @Override
    public void delete(Integer id) {
        this.getById(id);
        accountRepository.deleteById(id);
    }
}
