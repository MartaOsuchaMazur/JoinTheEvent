package pl.coderslab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.Model.Institution;

import java.util.List;
import java.util.Optional;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    @Query("SELECT i FROM Institution i WHERE i.id = :id")
    Institution findById(@Param("id") long id);
}
