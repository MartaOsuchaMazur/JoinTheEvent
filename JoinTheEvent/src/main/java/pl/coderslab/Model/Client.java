package pl.coderslab.Model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static javax.persistence.CascadeType.MERGE;


@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Size(min = 3, max=50, message = "Imię musi zawierać co najmniej 3 litery")
    @NotNull
    private String firstName;
    @Column(nullable = false)
    @Size(min = 2, max = 50, message = "Nazwisko musi zawierać co najmniej 2 litery")
    @NotNull
    private String lastName;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Pattern(regexp = "(?:(?:(?:\\+|00)?48)|(?:\\(\\+?48\\)))?(?:1[2-8]|2[2-69]|3[2-49]|4[1-8]|5[0-9]|6[0-35-9]|[7-8][1-9]|9[145])\\d{7}",
            message = "Podano niepoprawny numer telefonu")
    private String phone;

    @ManyToOne (fetch = FetchType.EAGER, cascade = MERGE)
    @NotNull
    private Institution institution;

    @OneToOne(mappedBy = "client", cascade = MERGE)
    private MarketingConsent marketingConsent;


    public Client() {
    }

    public Client(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
       }

    public Client(String firstName, String lastName, String email, String phone, Institution institution) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.institution = institution;
    }

    public Client(Long id, String firstName, String lastName, String email, String phone, Institution institution, MarketingConsent marketingConsent) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.institution = institution;
        this.marketingConsent = marketingConsent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MarketingConsent getMarketingConsent() {
        return marketingConsent;
    }

    public void setMarketingConsent(MarketingConsent marketingConsent) {
        this.marketingConsent = marketingConsent;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Institution getInstitution() {
        return institution;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", institution=" + institution +
                ", marketingConsent=" + marketingConsent +
                '}';
    }

    public boolean getGeneralConsent() {
        return marketingConsent.isGeneralConsent();
    }

    public boolean getProductConsent() {
        return marketingConsent.isProductConsent();
    }

    public boolean getEventConsent() {
        return marketingConsent.isEventConsent();
    }

    public boolean getPhoneConsent() {
        return marketingConsent.isPhoneConsent();
    }
    public MarketingConsent setGeneralConsent(MarketingConsent marketingConsent) {
        return marketingConsent;
    }

    public MarketingConsent setProductConsent() {
        return marketingConsent;
    }

    public MarketingConsent setEventConsent() {
        return marketingConsent;
    }

    public MarketingConsent setPhoneConsent() {
        return marketingConsent;
    }

}