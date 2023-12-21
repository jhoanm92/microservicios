package com.user.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Movement {

    private Integer idMovement;

    private BigDecimal ammount;

    private BigDecimal totalBalance;

    private LocalDateTime date;

    private Account account;

    private MovementType movement_type;

}
