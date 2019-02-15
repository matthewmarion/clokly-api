package com.moojm.cloklyapi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.POST, value = "/clients")
    public void createNewClient(@RequestBody Client client) {
        clientService.createNewClient(client);
    }

    @RequestMapping("/clients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping("/clients/{email}")
    public Client getClientByEmail(@PathVariable String email) {
        return clientService.getClientByEmail(email);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/clients/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}