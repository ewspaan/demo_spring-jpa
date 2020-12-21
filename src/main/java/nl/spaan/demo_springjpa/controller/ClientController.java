package nl.spaan.demo_springjpa.controller;

import nl.spaan.demo_springjpa.model.Client;
import nl.spaan.demo_springjpa.repository.ClientRepository;
import nl.spaan.demo_springjpa.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/clients")
    public ResponseEntity<Object> getClients() {
        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Object> getClient(@PathVariable("id") long id) {
        Client client = clientService.getClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @DeleteMapping(value = "/clients/{id}")
        public ResponseEntity<Object> deleteClient(@PathVariable("id") long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/clients")
    public ResponseEntity<Object> saveClient(@RequestBody Client client){
        long newID = clientService.saveClient(client);
        return new ResponseEntity<>(newID, HttpStatus.CREATED);
    }

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable("id") int id, @RequestBody Client client) {
        clientService.updateClient(id, client);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/clients/Lastname/{lastname}")
    public ResponseEntity<Object> getClientByLastName(@PathVariable("lastname") String lastName) {
        Client client = clientService.getClientByLastName(lastName);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

}