package org.example.Model;

import java.util.List;

public class Store {
    private long id;
    private List<Donut> donuts;
    private double revenue;

    public Store(long id, List<Donut> donuts, double revenue) {
        this.id = id;
        this.donuts=donuts;
        this.revenue = revenue;
    }

    public Store(long id, double revenue) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Donut> getProducts() {
        return donuts;
    }

    public void setProducts(List<Donut> products) {
        this.donuts=donuts;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}
