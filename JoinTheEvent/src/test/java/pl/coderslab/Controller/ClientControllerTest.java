package pl.coderslab.Controller;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import pl.coderslab.Model.Client;
import pl.coderslab.Model.Institution;
import pl.coderslab.Model.MarketingConsent;
import pl.coderslab.Service.ClientService;
import pl.coderslab.Service.InstitutionService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest
@ExtendWith(SpringExtension.class)
@EntityScan(basePackages = {"pl.coderslab.Model"})
@TestPropertySource("classpath:application.properties")
@ContextConfiguration(classes = {ClientService.class, InstitutionService.class, ClientController.class})
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService service;

    @MockBean
    private InstitutionService institutionService;

    @Test
    void showRegistrationForm_ShouldReturnFormView() throws Exception {
        when(institutionService.getInstitutions()).thenReturn(List.of(new Institution()));

        mockMvc.perform(get("/clients/add"))
            .andExpect(status().isOk())
            .andExpect(view().name("clients/form"))
            .andExpect(model().attributeExists("clientConsent"))
            .andExpect(model().attributeExists("institutions"));
    }

    // TODO: I've added this one to check if null insititutions can be added - maybe worth adding a check / handling for that
    @Test
    void showRegistrationForm_ShouldHandleNullInstitutions() throws Exception {
        when(institutionService.getInstitutions()).thenReturn(null);

        mockMvc.perform(get("/clients/add"))
            .andExpect(status().isOk())
            .andExpect(view().name("clients/form"))
            .andExpect(model().attributeExists("clientConsent"))
            .andExpect(model().attributeDoesNotExist("institutions"));
    }

    @Test
    void addClient_ShouldRedirectToAddMarketingPage_WhenClientIsValid() throws Exception {
        Client client = new Client(1L, "imię", "nazwisko", "email@email.com", "123456789", new Institution(), new MarketingConsent());

        doNothing().when(service).addClient(any(Client.class));

        mockMvc.perform(post("/clients/add")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .sessionAttr("clientConsent", client))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/marketing/add"));
    }

    @Test
    void addClient_ShouldReturnFormView_WhenClientIsInvalid() throws Exception {
        Client client = new Client();

        mockMvc.perform(post("/clients/add")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .sessionAttr("clientConsent", client))
            .andExpect(status().isOk())
            .andExpect(view().name("clients/form"));
    }
}