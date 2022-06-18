package pl.coderslab.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.Model.MarketingConsent;

import java.util.List;

@Service
public interface MarketingConsentService {

    void addConsents(MarketingConsent marketingConsent);
    List<MarketingConsent> getByClientId(Long id);
    void delete(Long id);
    void update(MarketingConsent marketingConsent);

}
