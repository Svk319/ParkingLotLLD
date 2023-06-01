package org.example.container;

import org.example.Vehicle.*;
import org.example.allocationStrategy.RandomAllocationStrategy;
import org.example.allocationStrategy.UniformAllocationStrategy;
import org.example.enums.ExceptionMessages;
import org.example.exceptions.ParkingSpaceUnavailableException;
import org.example.exceptions.VehicleTypeNotSupportedException;
import org.example.parkingspot.MediumVehicleSpot;
import org.example.parkingspot.ParkingSpot;

import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

//import static jdk.internal.misc.StructureViolationExceptions.throwException;

public class StadiumContainer extends AbstractContainer{
    private AtomicInteger carSpots;
    ConcurrentLinkedQueue<ParkingSpot> mediumVehicleSpotsList = new ConcurrentLinkedQueue<ParkingSpot>();
    ConcurrentLinkedQueue<ParkingSpot> heavyVehicleSpotsList = new ConcurrentLinkedQueue<ParkingSpot>();

    public StadiumContainer(AtomicInteger motorcycleSpots,AtomicInteger carSpots) {
        super(motorcycleSpots);
        this.carSpots=carSpots;
        this.init();
    }
    @Override
    public void init() {
        switch(this.strategyType) {
            case UNIFORM:
                this.strategy=new UniformAllocationStrategy();
                break;

            default:
                this.strategy=new RandomAllocationStrategy();
        }
        for(int i=0;i<this.carSpots.intValue();i++){
            mediumVehicleSpotsList.add(new MediumVehicleSpot());
        }

    }

    @Override
    public Optional<ParkingSpot> peekAvailableSpot(Vehicle vehicle) throws VehicleTypeNotSupportedException, ParkingSpaceUnavailableException {
        if(vehicle instanceof LightVehicle) {
            if (!this.lightVehicleSpotsList.isEmpty()) {
                return Optional.ofNullable(this.lightVehicleSpotsList.peek());
            } else {
                throw new ParkingSpaceUnavailableException(ExceptionMessages.PARKING_SPACE_UNAVAILABLE.toString());
            }
        }


        if(vehicle instanceof MediumVehicle){
            if(!this.mediumVehicleSpotsList.isEmpty()) {
                return Optional.ofNullable(this.mediumVehicleSpotsList.peek());
            }
            else{
                throw new ParkingSpaceUnavailableException(ExceptionMessages.PARKING_SPACE_UNAVAILABLE.toString());
            }

        }
        if(vehicle instanceof HeavyVehicle){
                throw new VehicleTypeNotSupportedException(ExceptionMessages.VEHICLE_TYPE_NOT_SUPPORTED.toString());
            }

        if(vehicle instanceof CustomVehicle) {
            if (!this.vehicleSpecificListMap.get(vehicle.getClass().getSimpleName()).isEmpty()) {
                return Optional.ofNullable(this.vehicleSpecificListMap.get(vehicle.getClass().getSimpleName()).peek());
            } else {
                throw new ParkingSpaceUnavailableException(ExceptionMessages.PARKING_SPACE_UNAVAILABLE.toString());
            }
        }
        //else throwException("Vehicle not supported in this parking lot");
        return  Optional.ofNullable(null);
    }
}
