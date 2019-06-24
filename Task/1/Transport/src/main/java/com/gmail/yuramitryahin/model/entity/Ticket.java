package com.gmail.yuramitryahin.model.entity;

import java.time.LocalDate;

public class Ticket {
    private CarriageComfort ticketType;
    private LocalDate departureDate;

    public Ticket() { }

    public Ticket(CarriageComfort ticketType, LocalDate departureDate) {
        this.ticketType = ticketType;
        this.departureDate = departureDate;
    }

    public CarriageComfort getTicketType() {
        return ticketType;
    }

    public Ticket setTicketType(CarriageComfort ticketType) {
        this.ticketType = ticketType;
        return this;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public Ticket setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketType=" + ticketType +
                ", departureDate=" + departureDate +
                '}';
    }
}
