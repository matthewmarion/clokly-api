package com.moojm.cloklyapi.client;

import com.moojm.cloklyapi.account.Account;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Size(max = 32)
    @Column(unique = true)
    private String name;

    @OneToOne
    private Account account;

    public Client() {

    }

    public Client(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
