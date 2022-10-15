package models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "yards")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Yard {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private Integer square;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "house_id")
    private House house;

    public Yard(Integer square, House house) {
        this.square = square;
        this.house = house;
    }
}
