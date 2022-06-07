package pl.coderslab.Model;

import javax.persistence.*;

@Entity
@Table(name="marketingConsents")
public class MarketingConsent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean generalConsent;
    private boolean productConsent;
    private boolean eventConsent;
    private boolean phoneConsent;

    public MarketingConsent() {
    }

    public MarketingConsent(boolean generalConsent, boolean productConsent, boolean eventConsent, boolean phoneConsent) {
        this.generalConsent = generalConsent;
        this.productConsent = productConsent;
        this.eventConsent = eventConsent;
        this.phoneConsent = phoneConsent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
