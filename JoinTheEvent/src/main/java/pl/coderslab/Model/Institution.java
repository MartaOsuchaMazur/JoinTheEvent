package pl.coderslab.Model;

import javax.persistence.*;

@Entity
@Table(name="institutions")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 200)
    private String instName;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Institution() {
    }

    public Institution(String instName, Client client) {
        this.instName = instName;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "id=" + id +
                ", instName='" + instName + '\'' +
                ", client=" + client +
                '}';
    }
}
