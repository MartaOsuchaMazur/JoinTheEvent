package pl.coderslab.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.Model.MarketingConsent;

import java.util.List;
import java.util.Optional;

@Service
public interface MarketingConsentService {

    void addConsents(MarketingConsent marketingConsent);
    List<MarketingConsent> getByClientId(Long id);
    Optional<MarketingConsent> get(Long id);
    void delete(Long id);
    void update(MarketingConsent marketingConsent);

}