package com.user.controller;


import com.user.entity.Client;
import com.user.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService service;

    @GetMapping()
    public ResponseEntity<List<Client>> getAll() {
        log.info("REST - To get all");
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping()
    public ResponseEntity<Client> register(@RequestBody Client client) {
        log.info("REST - Request to register : {}", client);
        return ResponseEntity.ok(service.register(client));
    }

    @PutMapping()
    public ResponseEntity<Client> update(@RequestBody Client client) {
        log.info("REST - Request to update : {}", client);
        return new ResponseEntity<>(service.update(client), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable("id") Integer id) {
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
