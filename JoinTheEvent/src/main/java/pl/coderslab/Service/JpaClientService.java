package pl.coderslab.Service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.Model.Client;
import pl.coderslab.Repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Setter
@Getter
@Service
@Primary
public class JpaClientService implements ClientService {

    private final ClientRepository clientRepository;


    public JpaClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getClients() {
        List<Client> clients = clientRepository.findAll();
        return clients;
   //     return clientRepository.findAll();
    }

    @Override
    public Client addClient(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Override
    public Optional<Client> get(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client getMaxClient() {
        return clientRepository.findByMaxId();
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client update(Client client) {
        clientRepository.save(client);
        return client;
    }

}