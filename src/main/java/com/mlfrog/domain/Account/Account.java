package com.mlfrog.domain.Account;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(AccountId.class)
public class Account {
    @Id
    private Long accountId;
    private String password;
    private String name;
    private String PhoneNumber;
    private String email;
    private Boolean premium;
}