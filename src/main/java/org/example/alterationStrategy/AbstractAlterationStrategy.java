package org.example.alterationStrategy;

import org.example.parkingspot.ParkingSpot;

import java.util.List;

public abstract class AbstractAlterationStrategy {
    public abstract ParkingSpot merge(List<ParkingSpot> list);
    public abstract List<ParkingSpot> split(ParkingSpot parkingSpot);
}
