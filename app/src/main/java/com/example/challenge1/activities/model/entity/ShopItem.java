package com.example.challenge1.activities.model.entity;

import java.io.Serializable;

public class ShopItem implements Serializable {

    public final static  String LAPICERO = "Lapicero";
    public final static  String CUADERNO = "Cuaderno";
    public final static String LIBRETA = "Libreta";
    public final static String CAMISETA = "Camiseta";
    public final static String SACO = "SACO";

    public final static int LAPICERO_PUNTOS = 10;
    public final static int CUADERNO_PUNTOS = 30;
    public final static int LIBRETA_PUNTOS = 40;
    public final static int CAMISETA_PUNTOS = 80;
    public final static int SACO_PUNTOS = 100;


    private String name;
    private int cost;

    public ShopItem() {
    }

    public ShopItem(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
