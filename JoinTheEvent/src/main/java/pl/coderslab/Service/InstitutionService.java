package pl.coderslab.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.Model.Institution;


import java.util.Optional;

@Service
public interface InstitutionService {

    Institution add(Institution institution);
    Optional<Institution> get(long id);
    Institution update(Institution institution);
}
