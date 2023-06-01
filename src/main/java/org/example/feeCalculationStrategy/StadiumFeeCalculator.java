package org.example.feeCalculationStrategy;

import org.example.Vehicle.LightVehicle;
import org.example.Vehicle.MediumVehicle;
import org.example.Vehicle.Vehicle;
import org.example.ticket.ParkingTicket;

import java.util.Date;

public class StadiumFeeCalculator implements FeeCalculator{
    public int calculateFee(ParkingTicket parkingTicket){
        Date d1= parkingTicket.entry;
        Date d2= new Date();

        long difference_In_Time = d2.getTime() - d1.getTime();
        long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;
        Vehicle v=parkingTicket.vehicle;
        int fee = (int) (difference_In_Hours * this.getFactor(v,difference_In_Hours));
        return fee;//new ParkingReceipt(fee,v);
    }

    public int getFactor(Vehicle v,long diff) {
        int fee = 0;

        if (v instanceof MediumVehicle) {
            fee += Math.min(4, diff) * 60;
            if (diff <= 4)
                return fee;
            diff -= 4;
            fee += Math.min(8, diff )* 120;
            if (diff <= 8)
                return fee;
            diff -= 8;
            return fee += diff * 200;
        }
        if (v instanceof LightVehicle){
            fee += Math.min(4, diff) * 30;
        if (diff <= 4)
            return fee;
        diff -= 4;
        fee += Math.min(8, diff) * 60;
        if (diff <= 8)
            return fee;
        diff -= 8;
        return fee += diff * 100;
    }


        return 1;
    }
}
