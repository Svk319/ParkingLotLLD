package org.example.feeCalculationStrategy;

public class CalcElement implements Comparable<CalcElement>{
    public int slab;
    public int value;

    public CalcElement(int slab, int value) {
        this.slab = slab;
        this.value = value;
    }

    @Override
    public int compareTo(CalcElement other) {
        return this.slab-other.slab;
    }


}
