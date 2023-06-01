package org.example.parkinglot;

import org.example.Vehicle.Vehicle;
import org.example.feeCalculationStrategy.FeeCalculator;
import org.example.container.AbstractContainer;
import org.example.exceptions.ParkingSpaceUnavailableException;
import org.example.exceptions.VehicleAlreadyParkedException;
import org.example.exceptions.VehicleNeverParkedException;
import org.example.exceptions.VehicleTypeNotSupportedException;
import org.example.parkingspot.ParkingSpot;
import org.example.receipt.ParkingReceipt;
import org.example.ticket.ParkingTicket;

import java.util.Date;

public abstract class AbstractParkingLot {
    public final FeeCalculator calc;
    public final AbstractContainer container;

    public AbstractParkingLot(FeeCalculator calc, AbstractContainer container) {
        this.calc = calc;
        this.container = container;
    }
    public ParkingTicket park(Vehicle vehicle) throws VehicleAlreadyParkedException, ParkingSpaceUnavailableException, VehicleTypeNotSupportedException {
        ParkingSpot parkingSpot=this.container.park(vehicle);
        if(parkingSpot!=null) {
            return new ParkingTicket(new Date(),vehicle,parkingSpot);
        }
        else{
            return null;
        }
    }
    public ParkingReceipt unPark(ParkingTicket ticket) throws VehicleNeverParkedException {
        this.container.unPark(ticket.vehicle);
        return new ParkingReceipt(this.calc.calculateFee(ticket), ticket.vehicle,ticket.entry);
    }

    public boolean isParkingAvailable(Vehicle v) throws ParkingSpaceUnavailableException, VehicleTypeNotSupportedException {
        return this.container.peekAvailableSpot(v).isPresent();
    }

}
