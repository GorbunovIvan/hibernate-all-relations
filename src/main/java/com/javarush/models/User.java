package com.javarush.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    // можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auto> autos;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UsersAndGasStations> gasStationsData;

    public User() {}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        autos = new ArrayList<>();
    }

    public void addAuto(Auto auto) {
        auto.setUser(this);
        autos.add(auto);
    }

    public void removeAuto(Auto auto) {
        autos.remove(auto);
    }

    public void removeGasStation(UsersAndGasStations gasStationsDataElement) {
        gasStationsData.remove(gasStationsDataElement);
    }

    public void addGasStation(UsersAndGasStations gasStationsDataElement) {
        gasStationsData.add(gasStationsDataElement);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    public Set<UsersAndGasStations> getGasStationsData() {
        return gasStationsData;
    }

    public void setGasStationsData(Set<UsersAndGasStations> gasStations) {
        this.gasStationsData = gasStationsData;
    }

    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}