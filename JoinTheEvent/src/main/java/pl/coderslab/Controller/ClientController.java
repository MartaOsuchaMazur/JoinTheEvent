package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Model.Client;
import pl.coderslab.Model.Institution;
import pl.coderslab.Service.ClientService;
import pl.coderslab.Service.InstitutionService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/admin/clients")
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
    public String showRegistrationForm(Model model) {
     //   List<Client> clients = clientService.getClients();
        model.addAttribute("client", new Client());
        model.addAttribute("institutions", institutionService.getInstitutions());
        return "clients/form";
    }


    @PostMapping("/add")
    public String addClient(@Valid Client client, BindingResult result) {
        if (result.hasErrors()) {
            return "clients/form";
        }

        clientService.addClient(client);
      //  institutionService.addInstitution(new Institution());
        return "redirect:/clients/all";
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
    public String deleteById(@PathVariable Long id, Model model) {
        clientService.delete(id);
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);
        return "clients/all";
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
        return "redirect:/clients/all";
    }
}
