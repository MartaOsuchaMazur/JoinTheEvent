package pl.coderslab.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.Model.Institution;
import pl.coderslab.Repository.InstitutionRepository;

import java.util.Optional;

public class InstitutionConverter implements Converter<String, Optional<Institution>> {

    @Autowired
    private InstitutionRepository institutionRepository;

    @Override
    public Optional<Institution> convert(String source) {
        return institutionRepository.findById(Long.parseLong(source));
    }
}
