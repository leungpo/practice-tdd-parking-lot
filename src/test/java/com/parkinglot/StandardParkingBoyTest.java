package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StandardParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.park(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //when
        Car fetchedCar = parkingBoy.fetch(ticket);
        //then
        assertEquals(car, fetchedCar);

    }

    @Test
    void should_return_right_car_when_fetch_twice_given_2_parked_cars() {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car1 = new Car();
        Ticket ticket1 = parkingBoy.park(car1);
        Car car2 = new Car();
        Ticket ticket2 = parkingBoy.park(car2);
        //when
        Car fetchedCar1 = parkingBoy.fetch(ticket1);
        Car fetchedCar2 = parkingBoy.fetch(ticket2);
        //then
        assertEquals(car1,fetchedCar1);
        assertEquals(car2,fetchedCar2);
    }

    @Test
    void should_return_exception_with_error_message_when_fetch_given_unrecognized_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = new Ticket();

        //then
        Exception exception = assertThrows(unrecognizedTicketException.class, () -> parkingBoy.fetch(ticket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());

    }

    @Test
    void should_return_exception_when_fetch_given_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        Car fetchedCar = parkingLot.fetch(ticket);
        //when
        //then
        Exception exception = assertThrows(unrecognizedTicketException.class, () -> parkingBoy.fetch(ticket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());

    }

    @Test
    void should_return_exception_when_park_given_without_position() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket1 = parkingLot.park(car);
        //when
        Car car2 = new Car();
        //then
        Exception exception = assertThrows(noAnyPositionException.class, () -> parkingBoy.park(car2));
        assertEquals("No available position.",exception.getMessage());
    }
}
