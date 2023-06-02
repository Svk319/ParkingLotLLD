package org.example.feeCalculationStrategy;

import org.example.enums.VehicleClasses;
import org.example.ticket.ParkingTicket;

import java.util.*;

/*
One must make sure that the fee slabs are continuous in nature and no two feeslabs must overlap with each other.
They should just touch each other. For instance [0-4 hrs), [4 to 8 hrs ) are valid slabs. Whereas [0-4 hrs) and [3 to 8 hrs )
are invalid slabs as they overlap. Sufficient validation has to done after initialising SlabBasedCalculator object.
For the very last slab the value of endHour attribute will be Long.MAX_VALUE.
 */

public class SlabBasedCalculator implements FeeCalculator{

    TreeSet<FeeSlab> slabSet;
    public HashMap<VehicleClasses, TreeSet<FeeSlab>> map = new HashMap<VehicleClasses, TreeSet<FeeSlab>>();
    public void init(HashMap<VehicleClasses, TreeSet<FeeSlab>> map) {
        this.map=map;
    }
    public SlabBasedCalculator(List<FeeSlab> slabs) {
        this.init(slabs);
    }

    @Override
    public int calculateFee(ParkingTicket parkingTicket) {
        long difference_In_Hours=this.getTimeInHours(parkingTicket);
        float temp=difference_In_Hours;
        float totalFee=0;
        //System.out.println("Diff in hours "+temp);
        //for(FeeSlab slab:this.map.get(parkingTicket.vehicle.getClass().getSimpleName())){
        for(FeeSlab slab:this.slabSet){
            float start=slab.getStartHour();
            float end=slab.getEndHour();
            float diff=end-start;
            totalFee+=calculatePerSlabFee(temp,slab);
            //System.out.println(totalFee);
            if(temp<=diff)
                break;
            else
                temp-=diff;
        }
        return (int) totalFee;
    }
    public float calculatePerSlabFee(float hours,FeeSlab slab){
        float start=slab.getStartHour();
        float end=slab.getEndHour();
        float diff=end-start;
        if(slab.getIsFlatRate()) {
            return slab.getFee();
        }
        else{
            return (float) (Math.ceil((Math.min(diff,hours)/slab.getDividingFactor()))*slab.getFee());
        }
    }

    public void init(List<FeeSlab> slabs){
        this.slabSet=new TreeSet<>(slabs);
    }
    public boolean addFeeSlab(FeeSlab feeSlab){
        return this.slabSet.add(feeSlab);
    }
}
