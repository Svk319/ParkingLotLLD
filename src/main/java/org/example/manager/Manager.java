package org.example.manager;

import org.example.Vehicle.Vehicle;
import org.example.enums.ParkingLotType;
import org.example.exceptions.ParkingSpaceUnavailableException;
import org.example.exceptions.VehicleAlreadyParkedException;
import org.example.exceptions.VehicleNeverParkedException;
import org.example.exceptions.VehicleTypeNotSupportedException;
import org.example.parkinglot.AbstractParkingLot;
import org.example.parkinglot.ParkingLotFactory;
import org.example.receipt.ParkingReceipt;
import org.example.ticket.ParkingTicket;

public class Manager {

    public static ParkingLotFactory parkingLotFactory =new ParkingLotFactory();
    public AbstractParkingLot parkingLot =null;

    public AbstractParkingLot createParkingLot(ParkingLotType type){
        if(this.parkingLot ==null)
            this.parkingLot = (AbstractParkingLot) parkingLotFactory.getInstance(type.toString());
        return parkingLot;
    }
    public boolean isParkingAvailable(Vehicle vehicle) throws ParkingSpaceUnavailableException, VehicleTypeNotSupportedException {
        return parkingLot.isParkingAvailable(vehicle);
    }
    public ParkingTicket park(Vehicle vehicle) throws VehicleAlreadyParkedException, ParkingSpaceUnavailableException, VehicleTypeNotSupportedException {
        ParkingTicket parkingTicket=this.parkingLot.park(vehicle);
        System.out.println(parkingTicket);
        return parkingTicket;
    }

    public ParkingReceipt unPark(ParkingTicket parkingTicket) throws VehicleNeverParkedException {

        ParkingReceipt parkingReceipt= null;

        parkingReceipt = this.parkingLot.unPark(parkingTicket);

        System.out.println(parkingReceipt);
        return parkingReceipt;
    }

}
