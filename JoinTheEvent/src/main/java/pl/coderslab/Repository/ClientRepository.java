package pl.coderslab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.Model.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    // metoda wyszukująca klienta dla zadanego id - co to daje, połączyć z listą klientów
    @Query(value= "SELECT c FROM Client c WHERE c.id = :id")
    Optional<Client> findById(@Param("id") Long id);

    @Query(value = "SELECT c FROM Client c WHERE c.id = (SELECT MAX(c.id) FROM Client c)")
    Client findByMaxId();

    }
