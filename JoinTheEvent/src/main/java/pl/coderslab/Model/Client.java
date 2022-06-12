package pl.coderslab.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Size(min = 3)
    private String firstName;
    @Column(nullable = false)
    @Size(min = 3)
    private String lastName;
    private String email;
    private String phone;

    @ManyToOne
  //  @JoinColumn(name="client_id")
    @NotNull
    private Institution institution;


    @OneToOne(mappedBy = "client")
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
}

