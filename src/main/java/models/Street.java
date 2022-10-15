package models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "streets")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Street {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "street", cascade = CascadeType.ALL)
    private Set<House> houses;

    public Street(String name) {
        this.name = name;
    }

    public void addHouse(House house) {
        getHouses().add(house);
    }

    public void removeHouse(House house) {
        getHouses().remove(house);
    }

}
