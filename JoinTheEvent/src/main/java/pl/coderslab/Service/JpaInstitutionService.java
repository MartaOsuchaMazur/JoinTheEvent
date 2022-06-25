package pl.coderslab.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.Model.Institution;
import pl.coderslab.Repository.InstitutionRepository;

import java.util.List;

@Service
public class JpaInstitutionService implements InstitutionService{

    private final InstitutionRepository institutionRepository;

    public JpaInstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }
    @Override
    public List<Institution> getInstitutions() {
        return institutionRepository.findAll();
    }

    @Override
    public Institution update(Institution institution) {
        return institutionRepository.save(institution);
    }

}