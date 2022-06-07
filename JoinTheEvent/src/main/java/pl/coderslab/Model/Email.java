package pl.coderslab.Model;

import javax.persistence.*;

@Entity
@Table(name="email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String emailAddress;
    @ManyToOne
    private Client client;

    public Email() {
    }

    public Email(String emailAddress, Client client) {
        this.emailAddress = emailAddress;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", emailAddress='" + emailAddress + '\'' +
                ", client=" + client +
                '}';
    }
}
