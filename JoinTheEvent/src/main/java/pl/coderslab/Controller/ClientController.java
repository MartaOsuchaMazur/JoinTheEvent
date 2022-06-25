package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Model.Client;
import pl.coderslab.Service.ClientService;
import pl.coderslab.Service.InstitutionService;
import pl.coderslab.Service.MarketingConsentService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/clients")
@SessionAttributes("clientConsent")
public class ClientController {

    private final ClientService clientService;
    private final InstitutionService institutionService;
    private final MarketingConsentService marketingConsentService;


    public ClientController(ClientService clientService, InstitutionService institutionService, MarketingConsentService marketingConsentService) {
        this.clientService = clientService;
        this.institutionService = institutionService;
        this.marketingConsentService = marketingConsentService;
    }

    @GetMapping("/add")
    public String showRegistrationForm(ModelMap modelMap) {
        modelMap.addAttribute("clientConsent", new Client());
        modelMap.addAttribute("institutions", institutionService.getInstitutions());
        return "clients/form";
    }

    @PostMapping("/add")
    public String addClient(@ModelAttribute("clientConsent") @Valid Client client, BindingResult result, Client id) {
        if (result.hasErrors()) {
            return "clients/form";
        }
        clientService.addClient(client);
        return "redirect:/marketing/add";
    }



}