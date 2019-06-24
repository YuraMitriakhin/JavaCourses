package com.gmail.yuramitryahin.model.entity;

public class Passanger {
    private String name;
    private String surname;
    private Ticket ticket;

    public Passanger() { }

    public Passanger(String name, String surname, Ticket ticket) {
        this.name = name;
        this.surname = surname;
        this.ticket = ticket;
    }

    public String getName() {
        return name;
    }

    public Passanger setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Passanger setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Passanger setTicket(Ticket ticket) {
        this.ticket = ticket;
        return this;
    }

    @Override
    public String toString() {
        return "Passanger{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", ticket=" + ticket +
                '}';
    }
}
