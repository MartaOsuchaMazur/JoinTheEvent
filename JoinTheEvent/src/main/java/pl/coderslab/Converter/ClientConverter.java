package pl.coderslab.Converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;
import pl.coderslab.Model.Client;
import pl.coderslab.Repository.ClientRepository;

import java.util.Optional;

public class ClientConverter implements Converter<String, Optional<Client>> {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Optional<Client> convert(String source) {
        return clientRepository.findById(Long.parseLong(source));
    }
}
