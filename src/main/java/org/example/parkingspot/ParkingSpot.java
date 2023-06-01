package org.example.parkingspot;

import org.example.Vehicle.Vehicle;

public interface ParkingSpot {
    public String id = null;
    public Vehicle vehicleParked= null;
    public Location location = null;

    public Boolean park(Vehicle vehicle);
    public Vehicle unpark();
    public Boolean isEmpty();
}
