package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<Ticket,Car> parkedCar = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        if(this.parkedCar.size() < capacity){
            Ticket ticket = new Ticket();
            this.parkedCar.put(ticket,car);
            return ticket;
        }
        throw new NoAnyPositionException();
    }
    public Car fetch(Ticket ticket) throws UnrecognizedTicketException {
        if(isUnrecognizedTicket(ticket)) {
            throw new UnrecognizedTicketException();
        }
        Car fetchCar = this.parkedCar.get(ticket);
        this.parkedCar.remove(ticket);
        return fetchCar;
    }

    protected boolean isUnrecognizedTicket(Ticket ticket) {
        return !this.parkedCar.containsKey(ticket);
    }
    public boolean isFull() {
        return this.parkedCar.size() >= capacity;
    }

    protected Map<Ticket, Car> getParkedCar() {
        return parkedCar;
    }
}
