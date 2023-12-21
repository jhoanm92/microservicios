package com.user.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class Person {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_person")
//    private Integer idPerson;

    private String name;

    @ManyToOne
    @JoinColumn(name = "id_gender_fk", referencedColumnName = "id_gender")
    private Gender gender;

    private Integer age;

    private Integer identification;

    private String address;

    private String phone;

}
