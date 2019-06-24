package com.gmail.yuramitryahin.model.entity;

public enum ListLocomotive {
    FIRST(2000, 20, 111459, "Blue", 7000),
    SECOND(1200, 10, 192429, "Black", 5000),
    THIRD(3500, 35, 122258, "Green", 10000);

    int power;
    int maxNumberOfCarriage;
    long IDTransport;
    String color;
    int weight;

    ListLocomotive(int power, int maxNumberOfCarriage, long IDTransport, String color, int weight) {
      this.power=power;
      this.maxNumberOfCarriage = maxNumberOfCarriage;
      this.IDTransport = IDTransport;
      this.color = color;
      this.weight = weight;
    }

    public int getPower() {
        return power;
    }

    public int getMaxNumberOfCarriage() {
        return maxNumberOfCarriage;
    }


    public long getIDTransport() {
        return IDTransport;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return super.toString() +
                " {IDTransport=" + IDTransport+
                ", power=" + power +
                "hp, maxNumberOfCarriage=" + maxNumberOfCarriage +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                "kg} ";
    }
}
