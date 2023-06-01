package org.example.feeCalculationStrategy;

import org.example.ticket.ParkingTicket;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/*
One must make sure that the fee slabs are continuous in nature and no two feeslabs must overlap with each other.
They should just touch each other. For instance [0-4 hrs), [4 to 8 hrs ) are valid slabs. Whereas [0-4 hrs) and [3 to 8 hrs )
are invalid slabs as they overlap. Sufficient validation has to done after initialising SlabBasedCalculator object.
For the very last slab the value of endHour attribute will be Long.MAX_VALUE.
 */

public class SlabBasedCalculator implements FeeCalculator{

    TreeSet<FeeSlab> slabSet;

    public SlabBasedCalculator(List<FeeSlab> slabs) {
        this.init(slabs);
    }

    @Override
    public int calculateFee(ParkingTicket parkingTicket) {
        long difference_In_Hours=this.getTimeInHours(parkingTicket);
        float temp=difference_In_Hours;
        float totalFee=0;
        //System.out.println("Diff in hours "+temp);
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
