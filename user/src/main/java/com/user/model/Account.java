package com.user.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {

    private Integer accountNumber;

    private BigDecimal initBalance;

    private Boolean state;

    private Integer idClient;

    private AccountType accountType;


}
