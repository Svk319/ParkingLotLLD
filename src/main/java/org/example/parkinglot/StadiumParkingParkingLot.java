package org.example.parkinglot;

import org.example.feeCalculationStrategy.StadiumFeeCalculator;
import org.example.container.StadiumContainer;

import java.util.concurrent.atomic.AtomicInteger;

public class StadiumParkingParkingLot extends AbstractParkingLot implements ParkingLot{
    public StadiumParkingParkingLot() {
        super(new StadiumFeeCalculator(), new StadiumContainer(new AtomicInteger(100),new AtomicInteger(100)));
    }
}
