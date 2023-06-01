package org.example.feeCalculationStrategy;

import org.example.ticket.ParkingTicket;

import java.util.Date;

public interface FeeCalculator {

    public int calculateFee(ParkingTicket parkingTicket);
    public default long getTimeInHours(ParkingTicket parkingTicket){
        Date d1= parkingTicket.entry;
        Date d2= new Date();

        long difference_In_Time = d2.getTime() - d1.getTime();
        long difference_In_Hours = Math.ceilDiv(difference_In_Time ,1000 * 60 * 60);
        return difference_In_Hours;
    }
}
