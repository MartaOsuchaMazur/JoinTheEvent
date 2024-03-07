package pl.coderslab.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name="institutions")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String instName;

    @OneToMany(mappedBy = "institution")
    private List <Client> clients;

    public Institution() {
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