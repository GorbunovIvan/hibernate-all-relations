package models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "houses")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class House {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "street_id")
    private Street street;

    @OneToOne(mappedBy = "house", cascade = CascadeType.ALL)
    private Yard yard;

    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
    Set<OwnersAndHousesRegistration> ownersAndHousesRegistration;

    public House(Street street) {
        this.street = street;
    }
}
