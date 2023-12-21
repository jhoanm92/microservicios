package com.account.service;

import com.account.entity.Movement;

import java.time.LocalDateTime;
import java.util.List;

public interface MovementService extends CRUD<Movement, Integer>{

    List<Movement> reports(LocalDateTime initDate, LocalDateTime endDate, Integer idClient);
}
