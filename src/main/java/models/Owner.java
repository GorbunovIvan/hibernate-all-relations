package models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "owners")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Owner {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    Set<OwnersAndHousesRegistration> ownersAndHousesRegistration;

    public Owner(String name) {
        this.name = name;
    }
}
