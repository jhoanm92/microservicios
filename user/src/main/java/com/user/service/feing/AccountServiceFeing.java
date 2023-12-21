package com.user.service.feing;

import com.user.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "account-service", url = "http://localhost:5001/accounts")
public interface AccountServiceFeing {

    @GetMapping()
    List<Account> getAll();

    @PostMapping()
    Account register(@RequestBody Account account);

    @PutMapping()
    Account update(@RequestBody Account account);

    @GetMapping("/{id}")
    Account getById(@PathVariable("id") Integer id);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id);

}
