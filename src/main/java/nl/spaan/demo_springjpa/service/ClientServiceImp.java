package nl.spaan.demo_springjpa.service;

import nl.spaan.demo_springjpa.exception.RecordNotFoundException;
import nl.spaan.demo_springjpa.model.Client;
import nl.spaan.demo_springjpa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteClient(long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        }
        else{
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long saveClient(Client client) {
        Client newClient = clientRepository.save(client);
        return newClient.getId();
    }

    @Override
    public void updateClient(long id, Client client) {
        Client existingClient = clientRepository.findById(id).orElse(null);
        existingClient.setFirstName(client.getFirstName());
        existingClient.setLastName(client.getLastName());
        existingClient.setKlantNr(client.getKlantNr());
        clientRepository.save(existingClient);
    }

    @Override
    public Client getClientByLastName(String lastName) {
        return clientRepository.findByLastName(lastName);
    }
}
