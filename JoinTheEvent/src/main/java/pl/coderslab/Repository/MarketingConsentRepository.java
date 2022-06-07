package pl.coderslab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Model.MarketingConsent;

public interface MarketingConsentRepository extends JpaRepository<MarketingConsent, Long> {
}
