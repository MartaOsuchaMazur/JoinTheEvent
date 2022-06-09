package pl.coderslab.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.Model.Client;

import java.util.List;
import java.util.Optional;

@Service
public interface ClientService {

    List<Client> getClients();
    void add(Client client);
    Optional<Client> get(long id);
    void delete(long id);
    void update(Client client);
}
