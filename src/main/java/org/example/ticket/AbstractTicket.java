package org.example.ticket;

import org.example.Vehicle.Vehicle;
import org.example.parkingspot.ParkingSpot;

import java.util.Date;

public abstract class AbstractTicket {
    public final Date entry;
    public final Vehicle vehicle;

    /*
    By making this field final, vehicle cannot change its spot once parked.If flexibility is needed in terms of functionality
    we have to change this into a list. Wrt to KISS design principle its left simple.
     */
    public final ParkingSpot spot;

    protected AbstractTicket(Date entry, Vehicle vehicle,ParkingSpot spot) {
        this.entry = entry;
        this.vehicle = vehicle;
        this.spot = spot;
    }
}
