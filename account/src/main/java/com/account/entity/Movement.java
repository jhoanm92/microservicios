package com.account.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "movements")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movement")
    private Integer idMovement;

    private BigDecimal ammount;

    private BigDecimal totalBalance;

    @Column(name = "date", updatable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "id_account_fk", referencedColumnName = "account_number", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "id_movement_type_fk", referencedColumnName = "id_movement_type", nullable = false)
    private MovementType movement_type;

}
