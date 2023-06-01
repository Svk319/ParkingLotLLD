package org.example.container;

import org.example.Vehicle.LightVehicle;
import org.example.Vehicle.Vehicle;
import org.example.allocationStrategy.AbstractAllocationStrategy;
import org.example.enums.AllocationStrategies;
import org.example.enums.ExceptionMessages;
import org.example.exceptions.ParkingSpaceUnavailableException;
import org.example.exceptions.VehicleAlreadyParkedException;
import org.example.exceptions.VehicleNeverParkedException;
import org.example.exceptions.VehicleTypeNotSupportedException;
import org.example.parkingspot.LightVehicleSpot;
import org.example.parkingspot.ParkingSpot;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractContainer {


    public AtomicInteger lightVehicleSpots;

    //LinkedList<ParkingSpot> lightVehicleSpotsList = (LinkedList<ParkingSpot>) Collections.synchronizedList(new LinkedList<ParkingSpot>());
    ConcurrentLinkedQueue<ParkingSpot> lightVehicleSpotsList = new ConcurrentLinkedQueue<ParkingSpot>();

    public ConcurrentHashMap<Vehicle,ParkingSpot> map = new ConcurrentHashMap<Vehicle,ParkingSpot>();
    public ConcurrentHashMap<String, ConcurrentLinkedQueue<ParkingSpot>> vehicleSpecificListMap =new ConcurrentHashMap<String, ConcurrentLinkedQueue<ParkingSpot>>();
    public AllocationStrategies strategyType =AllocationStrategies.RANDOM;
    public AbstractAllocationStrategy strategy=null;

    protected AbstractContainer(AtomicInteger motorcycleSpots) {
        this.lightVehicleSpots = motorcycleSpots;
        this.initDefault();
    }
    public void initDefault(){
        for(int i=0;i<this.lightVehicleSpots.intValue();i++){
            lightVehicleSpotsList.add(new LightVehicleSpot());
        }
        this.vehicleSpecificListMap.put(LightVehicle.class.getSimpleName(),this.lightVehicleSpotsList);
    }
    public abstract void init();
    public abstract Optional<ParkingSpot> peekAvailableSpot(Vehicle vehicle) throws ParkingSpaceUnavailableException, VehicleTypeNotSupportedException;

    public synchronized Optional<ParkingSpot> checkoutAvailableSpot(Vehicle vehicle) {
        return Optional.ofNullable(this.strategy.allocate(vehicle,this.vehicleSpecificListMap));
    }

    public synchronized boolean addToParkingSpotPool(ParkingSpot parkingSpot){

        return this.strategy.deallocate(parkingSpot,this.vehicleSpecificListMap);

    }
    public  synchronized ParkingSpot park(Vehicle vehicle) throws ParkingSpaceUnavailableException, VehicleTypeNotSupportedException, VehicleAlreadyParkedException {
        if(map.containsKey(vehicle)){
            throw new VehicleAlreadyParkedException(ExceptionMessages.VEHICLE_ALREADY_PARKED.toString());
        }
        Optional<ParkingSpot> availableSpot =this.checkoutAvailableSpot(vehicle);
        if(availableSpot.isPresent()) {
            ParkingSpot parkingSpot = availableSpot.get();
            this.map.put(vehicle, parkingSpot);
            return parkingSpot;
        }
        return null;
    }
    public synchronized boolean unPark(Vehicle vehicle) throws VehicleNeverParkedException {
        if(!map.containsKey(vehicle)){
            throw new VehicleNeverParkedException(ExceptionMessages.VEHICLE_NEVER_PARKED.toString());
        }
        ParkingSpot p=map.remove(vehicle);
        return this.addToParkingSpotPool(p);

    }
    public AtomicInteger getMotorcycleSpots() {
        return lightVehicleSpots;
    }
}
