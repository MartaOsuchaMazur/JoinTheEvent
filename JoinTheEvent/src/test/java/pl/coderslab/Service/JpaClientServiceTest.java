package pl.coderslab.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.Model.Client;
import pl.coderslab.Repository.ClientRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JpaClientServiceTest {

    @InjectMocks
    private JpaClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @Test
    void getClients_ShouldReturnListOfClients() {
        // Arrange
        Client client1 = new Client();
        Client client2 = new Client();
        when(clientRepository.findAll()).thenReturn(Arrays.asList(client1, client2));

        // Act
        List<Client> clients = clientService.getClients();

        // Assert
        assertEquals(2, clients.size());
    }

    @Test
    void addClient_ShouldSaveClient() {
        // Arrange
        Client client = new Client();

        // Act
        clientService.addClient(client);

        // Assert
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    void get_ShouldReturnClientById() {
        // Arrange
        Long id = 1L;
        Client client = new Client();
        when(clientRepository.findById(id)).thenReturn(Optional.of(client));

        // Act
        Optional<Client> result = clientService.get(id);

        // Assert
        assertEquals(client, result.orElse(null));
    }

    // Add tests for getMaxClient, delete, and update methods similarly

}