package pl.coderslab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.Model.Client;
import pl.coderslab.Model.Institution;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {


    // metoda wyszukująca klienta dla zadanego id - co to daje, połączyć z listą klientów
    @Query("SELECT c FROM Client c WHERE c.id = :id")
    Optional<Client> findById(@Param("id") long id);

    /*
    // metoda wyszukująca klientów dla zadanej instytucji - czy pole musi być w klasie?
    @Query("SELECT c FROM Client c WHERE c.institution = :institution")
    List<Client> findByInstitution(@Param("institution") String institution);

    //metoda wyszukująca klientów dla zadanego adresu email
    @Query("SELECT c FROM Client c WHERE c.emails = :emailAddress")
    List<Client> findByEmails(@Param("emails") Email email);

    //metoda wyszukująca klientów dla zadanego nazwiska
    @Query("SELECT c FROM Client c WHERE c.lastName = :lastName")
    List<Client> findByLastName(@Param("lastName") String lastName);
*/

    }
