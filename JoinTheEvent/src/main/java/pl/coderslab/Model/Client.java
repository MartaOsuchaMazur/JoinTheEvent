package pl.coderslab.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static javax.persistence.CascadeType.MERGE;


@RequiredArgsConstructor
@Setter
@Getter
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

    public Client(String firstName, String lastName, String email, String phone, Institution institution) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.institution = institution;
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