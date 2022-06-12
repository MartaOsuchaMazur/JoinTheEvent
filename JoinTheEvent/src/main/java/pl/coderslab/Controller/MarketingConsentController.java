package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Model.MarketingConsent;
import pl.coderslab.Service.JpaClientService;
import pl.coderslab.Service.JpaMarketingConsentService;

import javax.validation.Valid;

@Controller
@RequestMapping("/marketing")
public class MarketingConsentController {


        private final JpaMarketingConsentService jpaMarketingConsentService;


    public MarketingConsentController(JpaMarketingConsentService jpaMarketingConsentService) {
        this.jpaMarketingConsentService = jpaMarketingConsentService;
    }


        //dodanie zgód klienta
    @GetMapping("/add")
    public String showRegistrationForm(Model model) {
        model.addAttribute("consent", new MarketingConsent());
        return "consents/formConsent";
    }

    @PostMapping("/add")
    public String addConsent(@Valid MarketingConsent marketingConsent, BindingResult result) {
        if (result.hasErrors()) {
            return "consents/formConsent";
        }
        jpaMarketingConsentService.addConsents(marketingConsent);
        return "redirect:clients/all";
    }



        //edycja zgód
    @GetMapping("/edit/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("edit_url", "edit");
        model.addAttribute("consent", jpaMarketingConsentService.getByClientId(id).get(1));
        return "consents/editConsent";
    }


    @PostMapping("/edit")
    public String editClient(@ModelAttribute("consent") @Valid MarketingConsent marketingConsent, BindingResult result) {
        if (result.hasErrors()) {
            return "consents/editConsent";
        }
        jpaMarketingConsentService.update(marketingConsent);
        return "redirect:/marketing/edited";
    }
}