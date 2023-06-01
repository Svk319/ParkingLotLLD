package org.example.Vehicle;

import java.util.Date;

public abstract class Vehicle {
    public final String number;
    public final Date entry;
    public VehicleDetails vehicleDetails;

    public VehicleDetails getDetails() {
        return vehicleDetails;
    }
    public void setDetails(VehicleDetails vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }
    protected Vehicle(String number, Date entry) {
        this.number = number;
        this.entry = entry;
    }
}
