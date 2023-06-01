package org.example.container;

import org.example.Vehicle.Vehicle;
import org.example.parkingspot.ParkingSpot;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomContainer extends AbstractContainer{
    protected CustomContainer(AtomicInteger motorcycleSpots) {
        super(motorcycleSpots);
    }

    @Override
    public Optional<ParkingSpot> peekAvailableSpot(Vehicle vehicle) {
        return Optional.empty();
    }

    @Override
    public ParkingSpot park(Vehicle vehicle) {
        return null;
    }

    @Override
    public boolean unPark(Vehicle vehicle) {
        return false;
    }

    @Override
    public void init() {

    }
}
