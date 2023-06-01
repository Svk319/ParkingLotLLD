package org.example.feeCalculationStrategy;

import org.example.Vehicle.HeavyVehicle;
import org.example.Vehicle.LightVehicle;
import org.example.Vehicle.MediumVehicle;
import org.example.Vehicle.Vehicle;
import org.example.ticket.ParkingTicket;

import java.util.Date;

public class MallFeeCalculator implements FeeCalculator{

    public int calculateFee(ParkingTicket parkingTicket){
        long difference_In_Hours=this.getTimeInHours(parkingTicket);
        Vehicle v=parkingTicket.vehicle;
        int fee = (int) (difference_In_Hours * this.getFactor(v));
        return fee;//new ParkingReceipt(fee,v);
    }
    public int calculateFee(Vehicle vehicle,Long hours){
        int fee = (int) (hours * this.getFactor(vehicle));
        return fee;//new ParkingReceipt(fee,v);
    }
    public int getFactor(Vehicle v){
        if(v instanceof MediumVehicle)
            return 20;
        if(v instanceof LightVehicle)
            return 10;
        if(v instanceof HeavyVehicle)
            return 50;

        return 1;
    }

}
