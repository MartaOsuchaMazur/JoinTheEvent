package pl.coderslab.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.Model.Institution;
import pl.coderslab.Repository.InstitutionRepository;


public class InstitutionConverter implements Converter<String, Institution> {

    @Autowired
    private InstitutionRepository institutionRepository;

    @Override
    public Institution convert(String source) {
        return institutionRepository.findById(Long.parseLong(source));
    }
}