package com.moojm.cloklyapi.client;

import com.moojm.cloklyapi.account.Account;
import com.moojm.cloklyapi.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountService accountService;

    public List<Client> getAllClients(Long accountId) {
        List<Client> clients = new ArrayList<>();
        clientRepository.findByAccountId(accountId).forEach(clients::add);
        return clients;
    }

    public void createNewClient(Client client, Long accountId) {
        Account account = accountService.getAccountById(accountId);
        client.setAccount(account);
        // need to hash password before saving
        clientRepository.save(client);
    }

    public Client getClientById(Long id) {
        Optional<Client> optional = clientRepository.findById(id);
        if (!optional.isPresent()) {
            throw new NoSuchElementException("Client does not exist.");
        }
        return optional.get();
    }

    public void updateClient(Client client) {
        if (!clientRepository.findById(client.getId()).isPresent()) {
            throw new NoSuchElementException("Client does not exist.");
        }
        clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        Optional<Client> optional = clientRepository.findById(id);
        if (!optional.isPresent()) {
            throw new NoSuchElementException("Client does not exist.");
        }
        clientRepository.delete(optional.get());
    }
}
