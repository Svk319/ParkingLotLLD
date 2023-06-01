package org.example.ticket;

import org.example.Vehicle.Vehicle;
import org.example.parkingspot.ParkingSpot;

import java.util.Date;

public class ParkingTicket extends AbstractTicket{
    public ParkingTicket(Date entry, Vehicle vehicle, ParkingSpot spot) {
        super(entry, vehicle,spot);
    }
}
