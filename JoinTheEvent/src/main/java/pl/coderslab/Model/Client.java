package pl.coderslab.Model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    @Size(min = 5)
    private String firstName;
    @Column(nullable = false)
    @Size(min = 5)
    private String lastName;

    @OneToMany(mappedBy = "client")
    private List<Email> emails = new ArrayList<>();


    public Client() {
    }

    public Client(String firstName, String lastName, List<Email> emails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emails = emails;
       }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }



    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emails=" + emails +
                '}';
    }
}

