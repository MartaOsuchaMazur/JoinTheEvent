package pl.coderslab.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.Model.MarketingConsent;
import pl.coderslab.Repository.MarketingConsentRepository;

import java.util.List;

public class MarketingConsentConverter implements Converter<String, List<MarketingConsent>> {
    @Autowired
    private MarketingConsentRepository marketingConsentRepository;

    @Override
    public List<MarketingConsent> convert(String source) {
        return marketingConsentRepository.findByClientId(Long.parseLong(source));
    }
}
