package pl.coderslab.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.Model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT c FROM Client c WHERE c.id = :id")
    Optional<Client> findById(@Param("id") Long id);

    @Query(value = "SELECT c FROM Client c WHERE c.id = (SELECT MAX(c.id) FROM Client c)")
    Client findByMaxId();
}