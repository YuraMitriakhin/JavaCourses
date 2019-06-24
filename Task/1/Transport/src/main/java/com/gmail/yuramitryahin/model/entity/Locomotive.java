package com.gmail.yuramitryahin.model.entity;

public class Locomotive extends RailTransport {
    private int power;
    private int maxNumberOfCarriage;

    public Locomotive() { }

    public Locomotive(int power, int maxNumberOfCarriage) {
        this.power = power;
        this.maxNumberOfCarriage = maxNumberOfCarriage;
    }

    public Locomotive(long IDTransport, String color, int weight, int power, int maxNumberOfCarriage) {
        super(IDTransport, color, weight);
        this.power = power;
        this.maxNumberOfCarriage = maxNumberOfCarriage;
    }

    public int getPower() {
        return power;
    }

    public Locomotive setPower(int power) {
        this.power = power;
        return this;
    }

    public int getMaxNumberOfCarriage() {
        return maxNumberOfCarriage;
    }

    public Locomotive setMaxNumberOfCarriage(int maxNumberOfCarriage) {
        this.maxNumberOfCarriage = maxNumberOfCarriage;
        return this;
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "power=" + power +
                ", maxNumberOfCarriage=" + maxNumberOfCarriage +
                  super.toString();
    }
}
