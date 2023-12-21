package com.account.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "account_types")
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account_type")
    private Integer idAccountType;

    private String nameAccountType;
}
