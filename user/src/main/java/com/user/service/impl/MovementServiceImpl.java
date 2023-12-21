package com.user.service.impl;

import com.user.model.Movement;
import com.user.service.ClientService;
import com.user.service.MovementService;
import com.user.service.feing.MovementServiceFeint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovementServiceImpl implements MovementService {

    @Autowired
    private MovementServiceFeint movementService;

    @Autowired
    private ClientService clientService;

    public Movement register(Movement movement) {
        return movementService.register(movement);
    }

    @Override
    public Movement update(Movement movement) {
        return movementService.update(movement);
    }

    @Override
    public List<Movement> getAll() {
        return movementService.getAll();
    }

     @Override
    public Movement getById(Integer id) {
        return movementService.getById(id);
    }

    @Override
    public void delete(Integer id) {
        movementService.delete(id);
    }

    @Override
    public List<Movement> reports(LocalDateTime initDate, LocalDateTime endDate, Integer idClient) {
        return movementService.reports(initDate, endDate, idClient);
    }
}
