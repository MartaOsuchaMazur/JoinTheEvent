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
@RequestMapping("/admin/clients")
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

    @GetMapping("/all")
    public String showClients(Model model) {
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);
        model.addAttribute("institutions", institutionService.getInstitutions());
        return "/clients/all";
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

    @GetMapping("/get/{id}")
    public String getById(@PathVariable Long id, Model model) {
        model.addAttribute("clients", clientService.get(id).orElseThrow(EntityNotFoundException::new));
        model.addAttribute("institutions", institutionService.getInstitutions());
        model.addAttribute("marketingConsent", marketingConsentService.getByClientId(id));
        return "clients/showClient";
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteById(@PathVariable Long id, Model model) {
        marketingConsentService.delete(id);
        clientService.delete(id);
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);
        return "client deleted";
    }

//    @GetMapping("/edit/{id}")
//    public String editClientById(@PathVariable Long id, Model model) {
//        model.addAttribute("edit_url", "edit");
//        Client client = new Client();
//        model.addAttribute("client", clientService.get(id));
//        //model.addAttribute("client", clientService.get(id).get());
//        //model.addAttribute("institutions", institutionService.getInstitutions());
//        return "clients/edit";
//    }
//
//    @PostMapping("/edit")
//    public String editClient(@ModelAttribute("client") @Valid Client client, BindingResult result) {
//        if (result.hasErrors()) {
//            return "clients/edit";
//        }
//       // clientService.get(id);
//        clientService.update(client);
//        //institutionService.update(institution);
//        return "redirect:/clients/all";
//    }
}