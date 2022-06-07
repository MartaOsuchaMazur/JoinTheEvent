package pl.coderslab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Model.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
