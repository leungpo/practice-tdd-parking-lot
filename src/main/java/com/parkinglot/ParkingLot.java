package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket,Car> parkedCar = new HashMap<>();
    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        this.parkedCar.put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car fetchCar = this.parkedCar.get(ticket);
        this.parkedCar.remove(ticket);
        return fetchCar;
    }
}
