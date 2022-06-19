package pl.coderslab.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.Model.MarketingConsent;
import pl.coderslab.Repository.ClientRepository;
import pl.coderslab.Repository.MarketingConsentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JpaMarketingConsentService implements MarketingConsentService{

    private final MarketingConsentRepository marketingConsentRepository;

    public JpaMarketingConsentService(MarketingConsentRepository marketingConsentRepository, ClientRepository clientRepository) {
        this.marketingConsentRepository = marketingConsentRepository;
    }

    @Override
    public void addConsents(MarketingConsent marketingConsent) {
        marketingConsentRepository.save(marketingConsent);
    }

    @Override
    public void delete(Long id) {
    marketingConsentRepository.deleteById(id);
    }

    @Override
    public void update(MarketingConsent marketingConsent) {
        marketingConsentRepository.save(marketingConsent);
    }

    @Override
    public List<MarketingConsent> getByClientId(Long id) {
        return marketingConsentRepository.findByClientId(id);
    }

    @Override
    public Optional<MarketingConsent> get(Long id) {
        return marketingConsentRepository.findById(id);
    }
}