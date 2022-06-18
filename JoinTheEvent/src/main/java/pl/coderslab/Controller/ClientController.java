package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Model.Client;
import pl.coderslab.Model.Institution;
import pl.coderslab.Model.MarketingConsent;
import pl.coderslab.Service.ClientService;
import pl.coderslab.Service.InstitutionService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/clients")
@SessionAttributes("clientConsent")
public class ClientController {

    private final ClientService clientService;
    private final InstitutionService institutionService;



    public ClientController(ClientService clientService, InstitutionService institutionService) {
        this.clientService = clientService;
        this.institutionService = institutionService;
    }


    //wyświetlenie wszystkich klientów
    @GetMapping("/all")
    public String showClients(Model model) {
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);
        model.addAttribute("institutions", institutionService.getInstitutions());
        return "/clients/all";
    }

    //dodanie nowego klienta
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
      //  clientService.get(client.getId());
       // MarketingConsent m = new MarketingConsent();
       // m.getClient().getId();
        //m.setClient(id) = clientService.get(client.getId());

            return "/clients/formConsent";
    }

    //wyszukanie klienta po id
    @GetMapping("/get/{id}")
    public String getById(@PathVariable Long id, Model model) {
        model.addAttribute("clients", clientService.get(id).orElseThrow(EntityNotFoundException::new));
        model.addAttribute("institutions", institutionService.getInstitutions());
        return "clients/showClient";
    }

    //usuwanie klienta
    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteById(@PathVariable Long id, Model model) {
        clientService.delete(id);
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);
        return "client deleted";
       // return "clients/all";
    }

    //edycja klienta
    @GetMapping("/edit/{id}")
    public String editClientById(@PathVariable Long id, Model model) {
        model.addAttribute("edit_url", "edit");
        model.addAttribute("client", clientService.get(id).get());
        model.addAttribute("institutions", institutionService.getInstitutions());
        return "clients/edit";
    }


    @PostMapping("/edit")
    public String editClient(@ModelAttribute("client") @Valid Client client, BindingResult result) {
        if (result.hasErrors()) {
            return "clients/edit";
        }
        clientService.update(client);
        institutionService.update(new Institution());
        return "redirect:/clients/all";
    }
}