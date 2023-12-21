package com.user.service;

import com.user.model.Movement;

import java.time.LocalDateTime;
import java.util.List;

public interface MovementService extends CRUD<Movement, Integer>{

    List<Movement> reports(LocalDateTime initDate, LocalDateTime endDate, Integer idClient);
}
