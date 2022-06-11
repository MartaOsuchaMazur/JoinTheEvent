package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Model.Client;
import pl.coderslab.Repository.ClientRepository;
import pl.coderslab.Service.ClientService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/clients")
public class ClientController {

    private final ClientService clientService;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //wyświetlenie wszystkich klientów
    @GetMapping("/all")
    public String showClients(Model model) {
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);
        return "/clients/all";
    }

    //dodanie nowego klienta
    @GetMapping("/add")
    public String showRegistrationForm(Model model) {
        model.addAttribute("client", new Client());
        return "clients/form";
    }

    @PostMapping("/add")
    public String addClient(@Valid Client client, BindingResult result) {
        if (result.hasErrors()) {
            return "clients/form";
        }
        clientService.add(client);
        return "redirect:all";
    }

    //wyszukanie klienta po id
    @GetMapping("/get/{id}")
    public String getById(@PathVariable long id, Model model) {
        model.addAttribute("clients", clientService.get(id).orElseThrow(EntityNotFoundException::new));
        return "clients/showClient";
    }

    //usuwanie klienta
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable long id, Model model) {
        clientService.delete(id);
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);
        return "clients/all";
    }

    //edycja klienta
    @GetMapping("/edit/{id}")
    public String editClientById(@PathVariable long id, Model model) {
        model.addAttribute("edit_url", "edit");
        model.addAttribute("client", clientService.get(id));
        return "clients/edit";
    }


    @PostMapping("/edit")
    public String editClient(@ModelAttribute("client") @Valid Client client, BindingResult result) {
        if (result.hasErrors()) {
            return "clients/edit";
        }
        clientService.update(client);
        return "redirect:/admin/clients/all";
    }
}
