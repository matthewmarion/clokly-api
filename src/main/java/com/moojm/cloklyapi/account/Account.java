package com.moojm.cloklyapi.account;

import com.moojm.cloklyapi.client.Client;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(max = 128)
    private String password;

    @NotNull
    @Size(max = 32)
    private String name;

    @NotNull
    @Size(max = 32)
    private String lastName;

    private List<Client> clients;

    public Account() {

    }

    public Account(String email, String password, String name, String lastName) {
        super();
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void deleteClient(Client client) {
        clients.remove(client);
    }
}
