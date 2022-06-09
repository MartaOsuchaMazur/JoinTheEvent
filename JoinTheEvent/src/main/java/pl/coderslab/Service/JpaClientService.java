package pl.coderslab.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.Model.Client;
import pl.coderslab.Repository.ClientRepository;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaClientService implements ClientService {

    private final ClientRepository clientRepository;

    public JpaClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public void add(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Optional<Client> get(long id) {
        return clientRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void update(Client client) {
    }
}