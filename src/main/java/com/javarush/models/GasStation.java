package com.javarush.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "gas_stations")
public class GasStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    @OneToMany(mappedBy = "gasStation", cascade = CascadeType.ALL)
    private Set<UsersAndGasStations> usersData;

    public GasStation() {}

    public GasStation(String address) {
        this.address = address;
    }

    public void removeUser(UsersAndGasStations usersDataElement) {
        usersData.remove(usersDataElement);
    }

    public void addUser(UsersAndGasStations usersDataElement) {
        usersData.add(usersDataElement);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<UsersAndGasStations> getUsersData() {
        return usersData;
    }

    public void setUsers(Set<UsersAndGasStations> usersData) {
        this.usersData = usersData;
    }

    @Override
    public String toString() {
        return "GasStation{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", usersData size=" + usersData.size() +
                '}';
    }
}
