package com.gmail.yuramitryahin.model.entity;

public enum CarriageComfort {
    RESERVER(1),
    COMPARTMENT(2),
    LUXURY(3),
    RESTAURANT(5);

    private int level;

    CarriageComfort(int level) {
        this.level=level;
    }

    public int getLevel() {
        return level;
    }

}
