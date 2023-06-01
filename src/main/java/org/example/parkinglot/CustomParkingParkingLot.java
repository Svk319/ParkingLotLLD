package org.example.parkinglot;

import org.example.Vehicle.Vehicle;
import org.example.feeCalculationStrategy.FeeCalculator;
import org.example.container.AbstractContainer;
import org.example.receipt.ParkingReceipt;
import org.example.ticket.ParkingTicket;

public class CustomParkingParkingLot extends AbstractParkingLot implements ParkingLot{
    public CustomParkingParkingLot(FeeCalculator calc, AbstractContainer container) {
        super(calc, container);
    }


    public boolean isParkingAvailable(Vehicle v) {
        return false;
    }


    public ParkingTicket park(Vehicle v) {
        return null;
    }


    public ParkingReceipt unpark(ParkingTicket ticket) {
        return null;
    }
}
