package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Model.Client;
import pl.coderslab.Service.ClientService;
import pl.coderslab.Service.InstitutionService;

import javax.validation.Valid;


@Controller
@RequestMapping("/clients")
@SessionAttributes("clientConsent")
public class ClientController {

    private final ClientService clientService;
    private final InstitutionService institutionService;


    public ClientController(ClientService clientService, InstitutionService institutionService) {
        this.clientService = clientService;
        this.institutionService = institutionService;
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