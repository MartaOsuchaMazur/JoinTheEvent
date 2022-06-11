package pl.coderslab.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.Model.Client;
import pl.coderslab.Model.Institution;
import pl.coderslab.Repository.ClientRepository;
import pl.coderslab.Repository.InstitutionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaClientService implements ClientService, InstitutionService {

    private final ClientRepository clientRepository;
    private final InstitutionRepository institutionRepository;

    public JpaClientService(ClientRepository clientRepository, InstitutionRepository institutionRepository) {
        this.clientRepository = clientRepository;
        this.institutionRepository = institutionRepository;
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
    public Institution add(Institution institution) {
        return institutionRepository.save(institution);

    }

    @Override
    public Optional<Client> get(long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Optional<Institution> get(long id) {
        return institutionRepository.findById(id);
    }

    @Override
    public Institution update(Institution institution) {
        return institutionRepository.save(institution);

    }

    @Override
    public void delete(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void update(Client client) {
        clientRepository.save(client);
    }
}