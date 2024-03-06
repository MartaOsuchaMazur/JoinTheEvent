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
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
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

    //
    @Test
    void addClient_ShouldCreateClient() {
        Client client = new Client("Ania", "Nowacka", "a.nowacka@wp.pl", "+48632765443", new Institution());

        Client result = jpaClientService.addClient(client);

        assertThat(result.getFirstName().equals(client.getFirstName()));
    }

//    @Test
//    void update_ShouldUpdateClient() {
//        Client client = new Client("Ania", "Nowacka", "a.nowacka@wp.pl", "+48632765443", new Institution());
//        client = jpaClientService.addClient(client);
//        Long id = client.setId(Long.valueOf(2));
//
//        client.setFirstName("Marzanna");
//
//        Client result = jpaClientService.update(client.getId(), client);
//
//        assertThat(result.getId().equals(client.getId()));
//        assertThat(result.getId().equals(jpaClientService.get(client.getId().longValue())));
//    }

    //
    @Test
    void delete_ShouldDeleteClient() {

        Client client = new Client("Ania", "Nowacka", "a.nowacka@wp.pl", "+48632765443", new Institution());
        client = jpaClientService.addClient(client);
        Long id = client.getId();

        Throwable throwable = catchThrowable(() -> jpaClientService.delete(id));

        assertThat(jpaClientService.get(client.getId())).isEmpty();
    }
}