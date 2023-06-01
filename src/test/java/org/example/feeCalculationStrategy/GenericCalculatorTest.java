package org.example.feeCalculationStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.TreeSet;

class GenericCalculatorTest {

    TreeSet<CalcElement> set2;
    GenericCalculator g=new GenericCalculator();
    @BeforeEach
    void setUp() {
        //v1=new MotorCycle("1234",new Date());
        //v2=new Car("1234",new Date(2023,03,20));
        //s1="MALL";
        //s2="STADIUM";
        //m=new Manager();
        CalcElement cal1=new CalcElement(1,0);
        CalcElement cal2=new CalcElement(8,40);
        CalcElement cal3=new CalcElement(24,60);
        CalcElement cal4=new CalcElement(24,80);
        ArrayList<CalcElement> list=new ArrayList<CalcElement>();
        list.add(cal1);
        list.add(cal2);
        list.add(cal3);
        list.add(cal4);
        set2=new TreeSet<CalcElement>(list);

    }
    @Test
    void init() {
    }

    @Test
    void calculateFee() {
    }

    @Test
    void cumulativeFee() {
        System.out.println(g.cumulativeFee(set2,25));
    }
}