package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pl.coderslab.Model.MarketingConsent;
import pl.coderslab.Service.ClientService;
import pl.coderslab.Service.MarketingConsentService;

import javax.validation.Valid;

@Controller
@RequestMapping("/marketing")
public class MarketingConsentController {


    private final MarketingConsentService marketingConsentService;
    private final ClientService clientService;


    public MarketingConsentController(MarketingConsentService marketingConsentService, ClientService clientService, ClientService clientService1) {
        this.marketingConsentService = marketingConsentService;
        this.clientService = clientService1;
    }

    //dodanie zgód klienta
    @GetMapping
    public String getConsentsForm(ModelMap modelMap, Long id) {
        modelMap.addAttribute("clientConsent", new MarketingConsent());
        modelMap.addAttribute("client", clientService.getMaxClient(id));
     //   MarketingConsent marketingConsent = new MarketingConsent();
      //  marketingConsent.getClient() = this.client(id);
        return "clients/formConsent";
    }

    @PostMapping
    public String addConsent(@ModelAttribute("clientConsent") @Valid final MarketingConsent marketingConsent, final BindingResult result) {
        if (result.hasErrors()) {
            return "clients/formConsent";
        }
        marketingConsentService.addConsents(new MarketingConsent());
        return "redirect:clients/allConsents";
    }



        //edycja zgód
    @GetMapping("/edit/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("edit_url", "edit");
        model.addAttribute("consent", marketingConsentService.getByClientId(id).get(1));
        return "clients/editConsent";
    }


    @PostMapping("/edit")
    public String editClient(@ModelAttribute("consent") @Valid MarketingConsent marketingConsent, BindingResult result) {
        if (result.hasErrors()) {
            return "clients/editConsent";
        }
        marketingConsentService.update(marketingConsent);
        return "redirect: clients/showClientConsent";
    }

}