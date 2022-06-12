package pl.coderslab.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.Model.MarketingConsent;
import pl.coderslab.Repository.MarketingConsentRepository;

import java.util.List;

@Service
public class JpaMarketingConsentService implements MarketingConsentService{

    private final MarketingConsentRepository marketingConsentRepository;

    public JpaMarketingConsentService(MarketingConsentRepository marketingConsentRepository) {
        this.marketingConsentRepository = marketingConsentRepository;
    }

    @Override
    public MarketingConsent addConsents(MarketingConsent marketingConsent) {
        return marketingConsentRepository.save(marketingConsent);

    }

    @Override
    public List<MarketingConsent> getByClientId(Long id) {
        return marketingConsentRepository.findByClientId(id);
    }

    @Override
    public void delete(Long id) {
    marketingConsentRepository.deleteById(id);
    }

    @Override
    public void update(MarketingConsent marketingConsent) {
        marketingConsentRepository.save(marketingConsent);

    }
}
