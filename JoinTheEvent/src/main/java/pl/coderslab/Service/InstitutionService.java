package pl.coderslab.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.Model.Client;
import pl.coderslab.Model.Institution;


import java.util.List;
import java.util.Optional;

@Service
public interface InstitutionService {

    List<Institution> getInstitutions();
    Institution addInstitution(Institution institution);
    // void delete(long id);
    Institution update(Institution institution);
}
