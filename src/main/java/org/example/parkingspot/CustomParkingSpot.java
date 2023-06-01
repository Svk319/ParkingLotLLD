package org.example.parkingspot;

import org.example.Vehicle.Vehicle;

public class CustomParkingSpot implements ParkingSpot{

    private ParkingSpotDimensions dimension;
    public ParkingSpotDimensions getDimension() {
        return dimension;
    }

    public void setDimension(ParkingSpotDimensions dimension) {
        this.dimension = dimension;
    }

    @Override
    public Boolean park(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle unpark() {
        return null;
    }

    @Override
    public Boolean isEmpty() {
        return null;
    }
}
