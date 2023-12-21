package com.user.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "genders")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gender")
    private Integer idGender;

    private String name;
}
