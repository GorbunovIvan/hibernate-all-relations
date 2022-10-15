package models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "owners_and_houses_registration")//, schema = "public", catalog = "relations")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class OwnersAndHousesRegistration {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "house_id")
    private House house;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public OwnersAndHousesRegistration(House house, Owner owner) {
        this.house = house;
        this.owner = owner;
    }
}
