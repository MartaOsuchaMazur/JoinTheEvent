package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Model.Client;
import pl.coderslab.Model.Institution;
import pl.coderslab.Service.ClientService;
import pl.coderslab.Service.InstitutionService;
import pl.coderslab.Service.MarketingConsentService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
@SessionAttributes("clientConsent")
public class AdminController {

    private final ClientService clientService;
    private final InstitutionService institutionService;
    private final MarketingConsentService marketingConsentService;

    public AdminController(ClientService clientService, InstitutionService institutionService, MarketingConsentService marketingConsentService) {
        this.clientService = clientService;
        this.institutionService = institutionService;
        this.marketingConsentService = marketingConsentService;
    }

    @GetMapping("/all")
    public String showClients(Model model) {
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);
        model.addAttribute("institutions", institutionService.getInstitutions());
        return "/admin/all";
    }

    @GetMapping("/show")
    public String showEditClients(Model model) {
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);
        model.addAttribute("institutions", institutionService.getInstitutions());
        return "/admin/allWithEdit";
    }

    @GetMapping("/institution")
    public String showInstitution(Model model) {
        List<Institution> institutions = institutionService.getInstitutions();
        model.addAttribute("institutions", institutions);
        return "/admin/institution";
    }

    @GetMapping("/new")
    public String showRegistrationFormAdmin(ModelMap modelMap) {
        modelMap.addAttribute("clientConsent", new Client());
        modelMap.addAttribute("institutions", institutionService.getInstitutions());
        return "/admin/formAdmin";
    }

    @PostMapping("/new")
    public String addClientAdmin(@ModelAttribute("clientConsent") @Valid Client client, final BindingResult result, Client id) {
        if (result.hasErrors()) {
            return "/admin/formAdmin";
        }
        clientService.addClient(client);
        return 	"redirect:/marketing/new";
    }

    @GetMapping("/get/{id}")
    public String getById(@PathVariable Long id, Model model) {
        model.addAttribute("clients", clientService.get(id).orElseThrow(EntityNotFoundException::new));
        model.addAttribute("institutions", institutionService.getInstitutions());
        model.addAttribute("marketingConsent", marketingConsentService.getByClientId(id));
        return "admin/showClient";
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteById(@PathVariable Long id, Model model) {
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);
        marketingConsentService.delete(id);
        clientService.delete(id);
        return "client deleted";
    }

}
