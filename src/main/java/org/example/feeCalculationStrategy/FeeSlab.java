package org.example.feeCalculationStrategy;

import java.util.Objects;
/*
One must make sure that the fee slabs are continuous in nature and no two feeslabs must overlap with each other.
They should just touch each other. For instance [0-4 hrs), [4 to 8 hrs ) are valid slabs. Whereas [0-4 hrs) and [3 to 8 hrs )
are invalid slabs as they overlap. Sufficient validation has to done after initialising SlabBasedCalculator object.
For the very last slab the value of endHour attribute will be Long.MAX_VALUE.
 */
public class FeeSlab implements Comparable<FeeSlab> {
    private final float startHour;
    private final float endHour;
    private final float fee;
    private final boolean isFlatRate;
    //If the above field is true , only once the fee value will be added to total fee else "fee" will be added per dividingFactor hour(s) basis
    private final float dividingFactor;
    //The above variable will be initialised to 1 in case of per hours basis , 24 in case of per day basis etc.
    public FeeSlab(float startHour,float endHour, float fee, boolean isFlatRate, float dividingFactor) {
        this.startHour = startHour;
        this.endHour=endHour;
        this.fee=fee;
        this.isFlatRate=isFlatRate;
        this.dividingFactor = dividingFactor;
    }

    @Override
    public int compareTo(FeeSlab other) {
        if(this.startHour==other.startHour){
            return 0;
        }
        return this.startHour>=other.startHour?1:-1;
    }

    public float getStartHour() {
        return this.startHour;
    }

    public float getEndHour() {
        return this.endHour;
    }

    public float getFee() {
        return this.fee;
    }

    public boolean getIsFlatRate() {
        return this.isFlatRate;
    }

    public float getDividingFactor() {
        return this.dividingFactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FeeSlab feeSlab)) return false;
        return Float.compare(feeSlab.getStartHour(), getStartHour()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartHour());
    }
}
