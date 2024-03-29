package pl.coderslab.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.Model.Client;

import java.util.List;
import java.util.Optional;

@Service
public interface ClientService {

    List<Client> getClients();
    Client addClient(Client client);
    Optional<Client> get(Long id);
    Client getMaxClient();
    void delete(Long id);
    Client update(Client client);

}