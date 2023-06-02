package org.example.feeCalculationStrategy;

import org.example.Vehicle.LightVehicle;
import org.example.Vehicle.MediumVehicle;
import org.example.Vehicle.Vehicle;
import org.example.enums.VehicleType;
import org.example.ticket.ParkingTicket;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import static org.example.enums.VehicleType.MOTORCYCLE;

public class GenericCalculator implements FeeCalculator {
    public HashMap<String, TreeSet<CalcElement>> map = new HashMap<String, TreeSet<CalcElement>>();

    public void init(List<List<CalcElement>> list, List<String> vehicleList) {
        int len = list.size();
        for (int i = 0; i < len; i++) {
            map.put(vehicleList.get(i), new TreeSet<CalcElement>(list.get(i)));
        }
    }

    @Override
    public int calculateFee(ParkingTicket parkingTicket) {
        Vehicle v = parkingTicket.vehicle;
        TreeSet<CalcElement> temp=null;
        if (v instanceof MediumVehicle)//4 wheeler
        {
            temp = this.map.get(VehicleType.CAR.toString());
        }
        if (v instanceof LightVehicle)//4 wheeler
        {
            temp = this.map.get(MOTORCYCLE.toString());
        }

        Date d1 = parkingTicket.entry;
        Date d2 = new Date();

        long difference_In_Time = d2.getTime() - d1.getTime();
        long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;


        return cumulativeFee(temp,difference_In_Hours);
    }


    public int cumulativeFee(TreeSet<CalcElement> feeDetails, long differenceInHours) {
        int fee = 0;
        int prev = 0;
        for (CalcElement c : feeDetails) {
            int delta = c.slab - prev;
            fee += Math.min(delta, differenceInHours) * c.value;
            //System.out.println(fee);
            if (differenceInHours > delta) {
                differenceInHours -= delta;
                prev = c.slab;
            } else {
                break;
            }
        }
        /*if (differenceInHours != 0) {
            int quot= (int) Math.ceilDiv (differenceInHours ,feeDetails.last().slab);

            fee += (differenceInHours )* feeDetails.last().value;

        }

         */
        return fee;
    }
}
