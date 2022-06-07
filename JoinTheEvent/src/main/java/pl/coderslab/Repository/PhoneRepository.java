package pl.coderslab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
