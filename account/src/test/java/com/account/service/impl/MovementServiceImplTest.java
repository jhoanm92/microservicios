package com.account.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.account.entity.Account;
import com.account.entity.Movement;
import com.account.exception.ModeloNotFoundException;
import com.account.repository.MovementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
class MovementServiceImplTest {

    @Mock
    private MovementRepository repository;

    @InjectMocks
    private MovementServiceImpl movementService;

    Movement movement = new Movement();
    Account account = new Account();

    @BeforeEach
    public void initialize(){
        movement.setAmmount(BigDecimal.valueOf(100));
        movement.setTotalBalance(BigDecimal.valueOf(100));
        account.setAccountNumber(123456);

        movement.setAccount(account);
    }

    @Test
    void testRegisterWhitDateNow() {

        when(repository.findByDateMax(any())).thenReturn(Optional.empty());
        when(repository.save(any())).thenReturn(movement);

        Movement result = movementService.register(movement);

        assertEquals(LocalDateTime.now().getDayOfYear(), result.getDate().getDayOfYear());
    }

    @Test
    void testRegisterWhitCorrectAmmountZero() {

        when(repository.findByDateMax(any())).thenReturn(Optional.of(new Movement()));

        Movement movementZero = new Movement();
        movementZero.setAmmount(BigDecimal.valueOf(0));
        movementZero.setAccount(new Account());

        ModeloNotFoundException exception = assertThrows(ModeloNotFoundException.class, () -> {
            movementService.register(movementZero);
        });


        assertEquals("AMOUNT MUST BE DIFFERENT TO 0", exception.getMessage());
    }

//    @Test
//    void testRegisterWhitCorrectAmmountPositive() {
//
//        when(repository.findByDateMax(any())).thenReturn(Optional.of(movement));
//
//        Movement movementNegative = new Movement();
//        movementNegative.setAmmount(BigDecimal.valueOf(50));
//        movementNegative.setAccount(new Account());
//        movementNegative.setTotalBalance(BigDecimal.valueOf(100));
//
//        Movement result = movementService.register(movementNegative);
//
//        assertEquals(BigDecimal.valueOf(150), result.getTotalBalance());
//    }

}