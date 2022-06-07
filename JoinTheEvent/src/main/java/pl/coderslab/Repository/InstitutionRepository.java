package pl.coderslab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Model.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
