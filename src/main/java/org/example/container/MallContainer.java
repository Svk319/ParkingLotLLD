package org.example.container;

import org.example.Vehicle.*;
import org.example.allocationStrategy.RandomAllocationStrategy;
import org.example.allocationStrategy.UniformAllocationStrategy;
import org.example.enums.AllocationStrategies;
import org.example.enums.ExceptionMessages;
import org.example.enums.VehicleClasses;
import org.example.exceptions.ParkingSpaceUnavailableException;
import org.example.parkingspot.HeavyVehicleSpot;
import org.example.parkingspot.MediumVehicleSpot;
import org.example.parkingspot.ParkingSpot;

import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

//import static jdk.internal.misc.StructureViolationExceptions.throwException;

public class MallContainer extends AbstractContainer{

    private AtomicInteger mediumVehicleSpots;
    private AtomicInteger heavyVehicleSpots;
    ConcurrentLinkedQueue<ParkingSpot> mediumVehicleSpotsList = new ConcurrentLinkedQueue<ParkingSpot>();
    ConcurrentLinkedQueue<ParkingSpot> heavyVehicleSpotsList = new ConcurrentLinkedQueue<ParkingSpot>();


    public MallContainer(AtomicInteger lightVehicleSpots, AtomicInteger MediumVehicleSpots, AtomicInteger heavyVehicleSpots) {
        super(lightVehicleSpots);
        this.mediumVehicleSpots = MediumVehicleSpots;
        this.heavyVehicleSpots=heavyVehicleSpots;
        this.strategyType = AllocationStrategies.RANDOM;
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
        for(int i = 0; i<this.mediumVehicleSpots.intValue(); i++){
            mediumVehicleSpotsList.add(new MediumVehicleSpot());
        }
        for(int i = 0; i<this.mediumVehicleSpots.intValue(); i++){
            heavyVehicleSpotsList.add(new HeavyVehicleSpot());
        }
        this.vehicleSpecificListMap.put(VehicleClasses.MediumVehicle.toString(),this.mediumVehicleSpotsList);
        this.vehicleSpecificListMap.put(VehicleClasses.HeavyVehicle.toString(),this.heavyVehicleSpotsList);
    }

    /*
    The below method returns one of the available parkingspots.As of now the spot allocation strategy is random
     */
    @Override
    public Optional<ParkingSpot> peekAvailableSpot(Vehicle vehicle) throws ParkingSpaceUnavailableException {
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
            if(!this.heavyVehicleSpotsList.isEmpty()) {
                return Optional.ofNullable(this.heavyVehicleSpotsList.peek());
            }
            else{
                throw new ParkingSpaceUnavailableException(ExceptionMessages.PARKING_SPACE_UNAVAILABLE.toString());
            }
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
