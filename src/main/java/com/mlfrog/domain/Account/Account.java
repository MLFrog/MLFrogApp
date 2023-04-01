package com.mlfrog.domain.Account;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Account {
    
    private AccountId id;
    private String password;
    private String name;
    private String PhoneNumber;
    private String email;
    private Boolean premium;
    
}