package pl.coderslab.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.Model.Institution;

import java.util.List;

@Service
public interface InstitutionService {

    List<Institution> getInstitutions();
    Institution update(Institution institution);
}