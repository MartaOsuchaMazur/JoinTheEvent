package pl.coderslab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Model.MarketingConsent;

import java.util.List;

public interface MarketingConsentRepository extends JpaRepository<MarketingConsent, Long> {

    List<MarketingConsent> findByClientId(long clientId);

}
