package com.account.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "movement_types")
public class MovementType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movement_type")
    private Integer idMovementType;

    private String name;
}
