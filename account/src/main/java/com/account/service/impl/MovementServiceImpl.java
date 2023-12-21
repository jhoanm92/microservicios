package com.account.service.impl;

import com.account.entity.Movement;
import com.account.entity.MovementType;
import com.account.exception.ModeloNotFoundException;
import com.account.repository.MovementRepository;
import com.account.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MovementServiceImpl implements MovementService {

    @Autowired
    private MovementRepository repository;

    @Override
    public Movement register(Movement movement) {

        int value = movement.getAmmount().compareTo(BigDecimal.valueOf(0));
        MovementType movementType = new MovementType();

        Optional<Movement> lastMovement = repository.findByDateMax(movement.getAccount().getAccountNumber());

        if (lastMovement.isEmpty()){
            lastMovement = Optional.of(new Movement());
            lastMovement.get().setTotalBalance( BigDecimal.valueOf(0) );
        } else {
            if (value == 0) {
                throw new ModeloNotFoundException("AMOUNT MUST BE DIFFERENT TO 0");
            }
        }

        if (value == -1) {
            if (lastMovement.get().getTotalBalance().add(movement.getAmmount()).compareTo(BigDecimal.valueOf(0)) == -1) {
                throw new ModeloNotFoundException("INSUFFICIENT BALANCE");
            }

            movement.setTotalBalance( lastMovement.get().getTotalBalance().add(movement.getAmmount()) );
            movementType.setIdMovementType(1);//Withdrawal
            movement.setMovement_type(movementType);
        }

        if (value == 1) {
            movement.setTotalBalance( lastMovement.get().getTotalBalance().add(movement.getAmmount()) );
            movementType.setIdMovementType(2); //Deposit
            movement.setMovement_type(movementType);
        }

        movement.setDate(LocalDateTime.now());

        return repository.save(movement);
    }

    @Override
    public Movement update(Movement movement) {
        this.getById(movement.getIdMovement());
        return repository.save(movement);
    }

    @Override
    public List<Movement> getAll() {
        return repository.findAll();
    }

    @Override
    public Movement getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ModeloNotFoundException("ID NOT FOUND " + id));
    }

    @Override
    public void delete(Integer id) {
        this.getById(id);
        repository.deleteById(id);
    }

    @Override
    public List<Movement> reports(LocalDateTime initDate, LocalDateTime endDate, Integer idClient) {
        return repository.reports(initDate, endDate, idClient);
    }
}
