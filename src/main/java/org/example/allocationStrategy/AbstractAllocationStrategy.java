package org.example.allocationStrategy;

import org.example.Vehicle.Vehicle;
import org.example.enums.VehicleClasses;
import org.example.parkingspot.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class AbstractAllocationStrategy {

    public abstract ParkingSpot allocate(Vehicle vehicle, ConcurrentHashMap<String,ConcurrentLinkedQueue<ParkingSpot>> map);
    public boolean deallocate(ParkingSpot parkingSpot, ConcurrentHashMap<String,ConcurrentLinkedQueue<ParkingSpot>> vehicleSpecificListMap){
        if(parkingSpot instanceof MediumVehicleSpot) {
            return vehicleSpecificListMap.get(VehicleClasses.MediumVehicle.toString()).add((MediumVehicleSpot) parkingSpot);
        }
        if(parkingSpot instanceof LightVehicleSpot) {
            return vehicleSpecificListMap.get(VehicleClasses.LightVehicle.toString()).add((LightVehicleSpot) parkingSpot);
        }
        if(parkingSpot instanceof HeavyVehicleSpot) {
            return vehicleSpecificListMap.get(VehicleClasses.HeavyVehicle.toString()).add((HeavyVehicleSpot) parkingSpot);
        }
        if(parkingSpot instanceof CustomParkingSpot) {
            return vehicleSpecificListMap.get(VehicleClasses.CustomVehicle.toString()).add((CustomParkingSpot) parkingSpot);
        }
        return false;
    }
}
