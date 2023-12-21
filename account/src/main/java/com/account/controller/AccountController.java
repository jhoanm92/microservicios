package com.account.controller;

import com.account.entity.Account;
import com.account.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(MovementController.class);

    @Autowired
    private AccountService service;

    @GetMapping()
    public ResponseEntity<List<Account>> getAll() {
        log.info("REST - To get all");
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping()
    public ResponseEntity<Account> register(@RequestBody Account account) {
        log.info("REST - Request to register : {}", account);
        return ResponseEntity.ok(service.register(account));
    }

    @PutMapping()
    public ResponseEntity<Account> update(@RequestBody Account account) {
        log.info("REST - Request to update : {}", account);
        return new ResponseEntity<>(service.update(account), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getById(@PathVariable("id") Integer id) {
        log.info("REST - Get with Id : {}", id);
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        log.info("REST - Delete with id: {}", id);
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
