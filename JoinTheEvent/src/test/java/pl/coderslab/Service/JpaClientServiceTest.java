package pl.coderslab.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.Model.Client;
import pl.coderslab.Model.Institution;
import pl.coderslab.Repository.ClientRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JpaClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private JpaClientService jpaClientService;

    @Test
    void getClients_ShouldReturnListOfClients() {
        Client client1 = new Client("Ania", "Nowacka", "a.nowacka@wp.pl", "+48632765443", new Institution());
        Client client2 = new Client("Basia", "Nowacka", "b.nowacka@wp.pl", "+48632765443", new Institution());
        when(clientRepository.findAll()).thenReturn(Arrays.asList(client1, client2));
        List<Client> clientsList = jpaClientService.getClients();
        assertEquals(2, clientsList.size());
    }
}