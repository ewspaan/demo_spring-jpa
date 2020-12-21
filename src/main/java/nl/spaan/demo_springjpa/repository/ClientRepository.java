package nl.spaan.demo_springjpa.repository;

import nl.spaan.demo_springjpa.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByLastName(String lastName);


}
