package pl.coderslab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.Model.Institution;

import java.awt.print.Book;
import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    // metoda wyszukująca instytucję dla zadanej nazwy - co to daje, połączyć z listą klientów
    @Query("SELECT i FROM Institution i WHERE i.instName = :instName")
    List<Institution> findByName(@Param("instName") String instName);



}
