package com.javarush.models;

import javax.persistence.*;

@Entity
@Table(name = "wheels")
public class Wheel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auto_id")
    private Auto auto;

    public Wheel() {}

    public Wheel(Auto auto) {
        this.auto = auto;
    }

    public int getId() {
        return id;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "id=" + id +
                ", auto=" + auto +
                '}';
    }
}
