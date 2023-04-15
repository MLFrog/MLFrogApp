package com.mlfrog.domain.Account;

import lombok.Data;

@Data
public class Account {
    
    private AccountId id;
    private String password;
    private String name;
    private String PhoneNumber;
    private String email;
    private Boolean premium;
    
}