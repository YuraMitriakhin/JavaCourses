package com.gmail.yuramitryahin.model.entity;

public class PassengerCarriage extends RailTransport implements Comparable {
    private int numPassengers;
    private int numLuggage;
    private CarriageComfort comfort;

    public PassengerCarriage() {
    }

    public PassengerCarriage(int numPassengers, int numLuggage, CarriageComfort comfort) {
        this.numPassengers = numPassengers;
        this.numLuggage = numLuggage;
        this.comfort = comfort;
    }

    public PassengerCarriage(long IDTransport, String color, int weight, int numPassengers, int numLuggage, CarriageComfort comfort) {
        super(IDTransport, color, weight);
        this.numPassengers = numPassengers;
        this.numLuggage = numLuggage;
        this.comfort = comfort;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public PassengerCarriage setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
        return this;
    }

    public int getNumLuggage() {
        return numLuggage;
    }

    public PassengerCarriage setNumLuggage(int numLuggage) {
        this.numLuggage = numLuggage;
        return this;
    }

    public CarriageComfort getComfort() {
        return comfort;
    }

    public PassengerCarriage setComfort(CarriageComfort comfort) {
        this.comfort = comfort;
        return this;
    }

    @Override
    public String toString() {
        return "PassengerCarriage{ comfort=" + comfort +
                ", numPassengers=" + numPassengers +
                ", numLuggage=" + numLuggage +
                ", "+  super.toString();
    }


    @Override
    public int compareTo(Object o) {
        PassengerCarriage p = (PassengerCarriage)o;
        if(comfort.getLevel()>p.getComfort().getLevel()){
            return 1;
        }else if(comfort.getLevel()==p.getComfort().getLevel()){
            return 0;
        }else{
            return -1;
        }
    }
}
