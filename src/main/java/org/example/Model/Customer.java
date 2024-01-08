package org.example.Model;

public class Customer {
    private long id;
    private String name;
    private double wallet;

    public Customer(long id, String name, double wallet) {
        this.id = id;
        this.name = name;
        this.wallet = wallet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
}
