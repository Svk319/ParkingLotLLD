package org.example.allocationStrategy;

import org.example.Vehicle.Vehicle;
import org.example.parkingspot.ParkingSpot;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class UniformAllocationStrategy extends AbstractAllocationStrategy {
    @Override
    public ParkingSpot allocate(Vehicle vehicle, ConcurrentHashMap<String, ConcurrentLinkedQueue<ParkingSpot>> map) {
        return null;
    }

}
