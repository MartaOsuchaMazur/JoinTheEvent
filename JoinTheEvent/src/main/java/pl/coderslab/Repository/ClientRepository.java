package pl.coderslab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {


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
