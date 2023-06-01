package org.example.Vehicle;

import java.util.Date;

public class CustomVehicle extends Vehicle{
    private final VehicleSize size;
    protected CustomVehicle(String number, Date entry, VehicleSize size) {
        super(number, entry);
        this.size = size;
    }
}
