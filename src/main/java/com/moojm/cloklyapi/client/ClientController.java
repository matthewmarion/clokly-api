package com.moojm.cloklyapi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/clients")
    public void createNewClient(@RequestBody Client client, @PathVariable Long accountId) {
        System.out.println("Testing");
        clientService.createNewClient(client, accountId);
    }

    @RequestMapping("/accounts/{accountId}/clients")
    public List<Client> getAllClients(@PathVariable Long accountId) {
        return clientService.getAllClients(accountId);
    }

    @RequestMapping("/accounts/{accountId}/clients/{email}")
    public Client getClientByEmail(@PathVariable String email, @PathVariable Long accountId) {
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/accounts/{accountId}/clients")
    public void updateClient(@RequestBody Client client, @PathVariable Long accountId) {
        clientService.updateClient(client);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{accoundId}/clients/{id}")
    public void deleteClient(@PathVariable Long id, @PathVariable Long accountId) {
        clientService.deleteClient(id);
    }
}
