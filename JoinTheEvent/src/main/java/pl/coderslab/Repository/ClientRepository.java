package pl.coderslab.Repository;

import com.sun.xml.bind.v2.model.core.ID;
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
    Client findByMaxId(@Param("id") Long id);


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
