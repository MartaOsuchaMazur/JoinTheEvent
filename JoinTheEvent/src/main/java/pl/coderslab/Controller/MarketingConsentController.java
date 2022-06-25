package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Model.Client;
import pl.coderslab.Model.MarketingConsent;
import pl.coderslab.Service.ClientService;
import pl.coderslab.Service.MarketingConsentService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/marketing")
@Transactional
public class MarketingConsentController {


    private final MarketingConsentService marketingConsentService;
    private final ClientService clientService;


    public MarketingConsentController(MarketingConsentService marketingConsentService, ClientService clientService) {
        this.marketingConsentService = marketingConsentService;
        this.clientService = clientService;
    }


    @GetMapping("/add")
    public String getConsentsForm(ModelMap modelMap, Long id) {
        MarketingConsent marketingConsent = new MarketingConsent();
        modelMap.addAttribute("marketingConsent", marketingConsent);
        Client maxClient = clientService.getMaxClient();
        modelMap.addAttribute("client", maxClient);
        modelMap.addAttribute("clients", clientService.getClients());
        marketingConsent.setClient(maxClient);
        return "clients/formConsent";
    }

    @PostMapping("/add")
    public String addConsent(@ModelAttribute("marketingConsent") @Valid final MarketingConsent marketingConsent,
                             final BindingResult result, Long id) {
        if (result.hasErrors()) {
            return "clients/formConsent";
        }
        Client maxClient = clientService.getMaxClient();
        marketingConsent.setClient(maxClient);
        marketingConsentService.addConsents(marketingConsent);
        return "redirect:/marketing/all";
    }

    @GetMapping("/all")
    public String showConsents(Model model, Long id) {
        Client maxClient = clientService.getMaxClient();
        model.addAttribute("client", maxClient);
        Optional<MarketingConsent> marketingConsent = marketingConsentService.get(maxClient.getId());
        model.addAttribute("marketingConsent", marketingConsent);
        return "clients/showClientConsent";
    }

    @GetMapping("/new")
    public String getConsentsFormAdmin(ModelMap modelMap, Long id) {
        MarketingConsent marketingConsent = new MarketingConsent();
        modelMap.addAttribute("marketingConsent", marketingConsent);
        Client maxClient = clientService.getMaxClient();
        modelMap.addAttribute("client", maxClient);
        modelMap.addAttribute("clients", clientService.getClients());
        marketingConsent.setClient(maxClient);
        return "/admin/formConsentAdmin";
    }

    @PostMapping("/new")
    public String addConsentAdmin(@ModelAttribute("marketingConsent") @Valid final MarketingConsent marketingConsent,
                                  final BindingResult result, Long id) {
        if (result.hasErrors()) {
            return "/admin/formConsentAdmin";
        }
        Client maxClient = clientService.getMaxClient();
        marketingConsent.setClient(maxClient);
        marketingConsentService.addConsents(marketingConsent);
        return "redirect:/admin/all";
    }



}