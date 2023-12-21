package com.account.repository;

import com.account.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovementRepository extends JpaRepository<Movement, Integer> {

    @Query("SELECT m FROM Movement m WHERE m.date = (SELECT MAX(m2.date) FROM Movement m2) AND " +
            "m.account.accountNumber = :accountNumber")
    Optional<Movement> findByDateMax(Integer accountNumber);

    @Query("SELECT m FROM Movement m Where m.date BETWEEN :initDate AND :endDate AND m.account.idClient = :idClient")
    List<Movement> reports(LocalDateTime initDate, LocalDateTime endDate, Integer idClient);
}
