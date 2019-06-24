package com.gmail.yuramitryahin.model.entity;

public class RailTransport {
    private long IDTransport;
    private String color;
    private int weight;

    public RailTransport() {
    }

    public RailTransport(long IDTransport, String color, int weight) {
        this.IDTransport = IDTransport;
        this.color = color;
        this.weight = weight;
    }

    public long getIDTransport() {
        return IDTransport;
    }

    public RailTransport setIDTransport(long IDTransport) {
        this.IDTransport = IDTransport;
        return this;
    }

    public String getColor() {
        return color;
    }

    public RailTransport setColor(String color) {
        this.color = color;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public RailTransport setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public String toString() {
        return  ", IDTransport=" + IDTransport +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
