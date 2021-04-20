package br.edu.class03.EA02;

public class Encapsulation {
    private String name;
    private String address;
    private Double value;

    public Encapsulation(String name, String address, Double value) {
        this.name = name;
        this.address = address;
        this.value = value;
    }

    public Encapsulation() {
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }
}
