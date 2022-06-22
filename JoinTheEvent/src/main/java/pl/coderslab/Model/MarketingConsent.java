package pl.coderslab.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="marketingConsents")
public class MarketingConsent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private boolean generalConsent;
    private boolean productConsent;
    private boolean eventConsent;
    @NotNull
    private boolean phoneConsent;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;


    public MarketingConsent() {
    }

    public MarketingConsent(boolean generalConsent, boolean productConsent, boolean eventConsent, boolean phoneConsent, Client client) {
        this.generalConsent = generalConsent;
        this.productConsent = productConsent;
        this.eventConsent = eventConsent;
        this.phoneConsent = phoneConsent;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isGeneralConsent() {
        return generalConsent;
    }

    public void setGeneralConsent(boolean generalConsent) {
        this.generalConsent = generalConsent;
    }

    public boolean isProductConsent() {
        return productConsent;
    }

    public void setProductConsent(boolean productConsent) {
        this.productConsent = productConsent;
    }

    public boolean isEventConsent() {
        return eventConsent;
    }

    public void setEventConsent(boolean eventConsent) {
        this.eventConsent = eventConsent;
    }

    public boolean isPhoneConsent() {
        return phoneConsent;
    }

    public void setPhoneConsent(boolean phoneConsent) {
        this.phoneConsent = phoneConsent;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }



    @Override
    public String toString() {
        return "MarketingConsent{" +
                "id=" + id +
                ", generalConsent=" + generalConsent +
                ", productConsent=" + productConsent +
                ", eventConsent=" + eventConsent +
                ", phoneConsent=" + phoneConsent +
                '}';
    }

    public Client getClient(Long id) {
        return client;
    }
}