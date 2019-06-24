package com.gmail.yuramitryahin.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private Locomotive locomotive;
    private List<PassengerCarriage> passengerCarriages;
    int countPas;
    int countLug;

    public Train() {
    }

    public Train(Locomotive locomotive, List<PassengerCarriage> passengerCarriages) {
        this.locomotive = locomotive;
        this.passengerCarriages = passengerCarriages;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void addLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public List<PassengerCarriage> getPassengerCarriages() {
        return passengerCarriages;
    }

    public void addPassengerCarriages(PassengerCarriage passengerCarriages) {
        if(this.passengerCarriages==null){
            this.passengerCarriages = new ArrayList<>();
        }
        this.passengerCarriages.add(passengerCarriages);
    }

    public List<PassengerCarriage> findCarriage(int min, int max){
        List<PassengerCarriage>list=new ArrayList<>();
        for (PassengerCarriage p: passengerCarriages) {
            if(p.getNumPassengers()<=max&&p.getNumPassengers()>=min){
                list.add(p);
            }
        }
        return list;
    }

    public int numPassengers(){
        int k=0;
        for (PassengerCarriage carriage: passengerCarriages) {
            k+=carriage.getNumPassengers();
        }
        return k;
    }

    public int numLuggages(){
        int r=0;
        for (PassengerCarriage carriage: passengerCarriages) {
            r+=carriage.getNumLuggage();
        }
        return r;
    }

    @Override
    public String toString() {
        return "Train{" +
                "locomotive=" + locomotive +
                ", passengerCarriages=" + passengerCarriages +
                '}';
    }


}
