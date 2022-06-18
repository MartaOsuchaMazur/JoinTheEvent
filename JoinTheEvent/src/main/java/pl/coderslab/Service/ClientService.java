package pl.coderslab.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.Model.Client;

import java.util.List;
import java.util.Optional;

@Service
public interface ClientService {

    List<Client> getClients();
    void addClient(Client client);
    Optional<Client> get(Long id);
    Client getMaxClient(Long id);
    void delete(Long id);
    void update(Client client);
}
