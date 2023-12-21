package com.account.controller;

import com.account.entity.Movement;
import com.account.service.MovementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/movements")
public class MovementController {

    private static final Logger log = LoggerFactory.getLogger(MovementController.class);

    @Autowired
    private MovementService service;

    @GetMapping()
    public ResponseEntity<List<Movement>> getAll() {
        log.info("REST - To get all");
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping()
    public ResponseEntity<Movement> register(@RequestBody Movement movement) {
        log.info("REST - Request to register : {}", movement);
        return ResponseEntity.ok(service.register(movement));
    }

    @PutMapping()
    public ResponseEntity<Movement> update(@RequestBody Movement movement) {
        log.info("REST - Request to update : {}", movement);
        return new ResponseEntity<>(service.update(movement), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movement> getById(@PathVariable("id") Integer id) {
        log.info("REST - Get with Id : {}", id);
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        log.info("REST - Delete with id: {}", id);
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/report")
    public List<Movement> reports(@RequestParam LocalDateTime initDate,
                                  @RequestParam LocalDateTime endDate,
                                  @RequestParam Integer idClient) {

        log.info("REST - report initDate: {}, endDate: {}, idClient: {}", initDate, endDate, idClient);
        return service.reports(initDate, endDate, idClient);
    }
}
