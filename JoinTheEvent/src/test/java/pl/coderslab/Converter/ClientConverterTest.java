package pl.coderslab.Converter;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.Model.Client;
import pl.coderslab.Repository.ClientRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientConverterTest {

    @InjectMocks
    private ClientConverter converter;

    @Mock
    ClientRepository clientRepository;

    //TODO: You should add handling for this:
    @Test
    void shouldReturnOptionalEmpty_whenIdInvalid() {
        Optional<Client> client = converter.convert("a");
        assertTrue(client.isEmpty());
    }

    @Test
    void shouldReturnOptionalEmpty_whenClientNotFound() {
        Optional<Client> client = converter.convert("1");
        assertTrue(client.isEmpty());
    }

    @Test
    void shouldReturnOptionalOfClient_whenClientFound() {
        Client client = new Client();
        client.setId(1L);

        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        Optional<Client> response = converter.convert("1");
        assertEquals(client, response.get());
    }
}