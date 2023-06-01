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
    public TreeSet<CalcElement> set1;
    public TreeSet<CalcElement> set2;

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


    public int cumulativeFee(TreeSet<CalcElement> temp, long diff) {
        int fee = 0;
        int prev = 0;
        for (CalcElement c : temp) {
            int delta = c.slab - prev;
            fee += Math.min(delta, diff) * c.value;
            if (diff > delta) {
                diff -= delta;
                prev = c.slab;
            } else {
                break;
            }
        }
        if (diff != 0) {
            int quot= (int) (diff / temp.first().slab);
            int rem=(int) (diff % temp.first().slab);
            if(rem!=0)
                quot+=1;

            fee += (quot )* temp.last().value;

        }
        return fee;
    }
}
