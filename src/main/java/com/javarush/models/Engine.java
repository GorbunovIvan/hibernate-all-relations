package com.javarush.models;

import javax.persistence.*;

@Entity
@Table(name = "engines")
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int power;
    private int volume;

    @OneToOne
    @JoinColumn(name = "auto_id") //, referencedColumnName = "id") - not mandatory
    private Auto auto;

    public Engine() {}

    public Engine(int power, int volume, Auto auto) {
        this.power = power;
        this.volume = volume;
        this.auto = auto;
    }

    public int getId() {
        return id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", power=" + power +
                ", volume=" + volume +
                ", auto=" + auto +
                '}';
    }
}
