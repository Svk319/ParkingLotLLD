package org.example.allocationStrategy;

import org.example.Vehicle.Vehicle;
import org.example.parkingspot.ParkingSpot;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RandomAllocationStrategy extends AbstractAllocationStrategy {
    @Override
    public ParkingSpot allocate(Vehicle vehicle, ConcurrentHashMap<String, ConcurrentLinkedQueue<ParkingSpot>> map) {
        return map.get(vehicle.getClass().getSimpleName()).poll();
    }
}
