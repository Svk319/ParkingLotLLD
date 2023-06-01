package org.example.parkinglot;

import org.example.feeCalculationStrategy.MallFeeCalculator;
import org.example.container.MallContainer;

import java.util.concurrent.atomic.AtomicInteger;

public class MallParkingParkingLot extends AbstractParkingLot implements ParkingLot{
    public MallParkingParkingLot() {
        super(new MallFeeCalculator(), new MallContainer(new AtomicInteger(100),new AtomicInteger(100),new AtomicInteger(100)));
    }
}
