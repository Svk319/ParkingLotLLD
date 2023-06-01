package org.example.feeCalculationStrategy;

import org.example.Vehicle.LightVehicle;
import org.example.Vehicle.Vehicle;
import org.example.parkingspot.LightVehicleSpot;
import org.example.ticket.ParkingTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SlabBasedCalculatorTest {
    SlabBasedCalculator calc;
    @BeforeEach
    void setUp() {
        FeeSlab a=new FeeSlab(0,4,45,true,1);
        FeeSlab b=new FeeSlab(4,8,100,false,1);
        FeeSlab C=new FeeSlab(8,Long.MAX_VALUE,10,true,24);
        List<FeeSlab> list = new ArrayList<FeeSlab>();
        list.add(a);
        list.add(b);
        list.add(C);
        calc=new SlabBasedCalculator(list);


    }

    @Test
    void calculateFee() {
        Date d1=new Date(2023-1900, 04, 30, 1, 0);
        Date d2=new Date();
        //System.out.println(d2);
        ParkingTicket ticket=new ParkingTicket(d1, new LightVehicle("1234",d1),new LightVehicleSpot());
        assertEquals(455,calc.calculateFee(ticket));
        System.out.println(calc.calculateFee(ticket));
    }

    @Test
    void calculatePerSlabFee() {
    }

    @Test
    void init() {
    }

    @Test
    void addFeeSlab() {
    }
}