package com.moojm.cloklyapi.client;

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

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    public void createNewClient(Client client) {
        // need to hash password before saving
        clientRepository.save(client);
    }

    public Client getClientByEmail(String email) {
        Optional<Client> optional = clientRepository.findClientByEmail(email);
        if (!optional.isPresent()) {
            throw new NoSuchElementException("Client does not exist.");
        }
        return optional.get();
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
