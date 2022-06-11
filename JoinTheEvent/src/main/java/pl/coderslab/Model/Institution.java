package pl.coderslab.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="institutions")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 200)
    private String instName;

    @OneToMany(mappedBy = "institution")
    private List <Client> clients;

    public Institution() {
    }


    public Institution(String instName, List<Client> clients) {
        this.instName = instName;
        this.clients = clients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "id=" + id +
                ", instName='" + instName + '\'' +
                ", clients=" + clients +
                '}';
    }
}
