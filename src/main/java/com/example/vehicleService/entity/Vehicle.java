package com.example.vehicleService.entity;

import jakarta.persistence.*;

@Entity
@Table(name="vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;
    private String model;
    private int year;

    // Constructors
    public Vehicle() {}

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Vehicle(Long id, String make, String model, int year) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}
