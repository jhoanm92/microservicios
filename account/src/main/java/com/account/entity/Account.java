package com.account.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column(name = "account_number", unique = true, nullable = false)
    private Integer accountNumber;

    private BigDecimal initBalance;

    private Boolean state;

    private Integer idClient;

    @ManyToOne
    @JoinColumn(name = "id_account_type_fk", referencedColumnName = "id_account_type", nullable = false)
    private AccountType accountType;


}
