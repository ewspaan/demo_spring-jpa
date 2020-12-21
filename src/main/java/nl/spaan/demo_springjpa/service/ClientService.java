package nl.spaan.demo_springjpa.service;

import nl.spaan.demo_springjpa.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();
    Client getClientById(long id);
    void deleteClient(long id);
    long saveClient(Client client);
    void updateClient( long id, Client client);
    Client getClientByLastName(String lastName);
}
