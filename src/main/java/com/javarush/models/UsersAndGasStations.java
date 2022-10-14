package com.javarush.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "users_and_gas_stations")
public class UsersAndGasStations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gas_station_id")
    private GasStation gasStation;

    @Basic
    @Column(name = "first_visiting_date")
    private Timestamp firstVisitingDate;

    public UsersAndGasStations() {}

    public UsersAndGasStations(User user, GasStation gasStation) {
        this.user = user;
        this.gasStation = gasStation;
        this.firstVisitingDate = Timestamp.valueOf(LocalDateTime.now());
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GasStation getGasStation() {
        return gasStation;
    }

    public void setGasStation(GasStation gasStation) {
        this.gasStation = gasStation;
    }

    public Timestamp getFirstVisitingDate() {
        return firstVisitingDate;
    }

    public void setFirstVisitingDate(Timestamp firstVisitingDate) {
        this.firstVisitingDate = firstVisitingDate;
    }

    @Override
    public String toString() {
        return "UsersAndGasStations{" +
                "id=" + id +
                ", user=" + user +
                ", gasStation=" + gasStation +
                ", firstVisitingDate=" + firstVisitingDate +
                '}';
    }
}
