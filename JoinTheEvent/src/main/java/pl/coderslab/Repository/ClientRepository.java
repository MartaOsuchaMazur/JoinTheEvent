package pl.coderslab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
