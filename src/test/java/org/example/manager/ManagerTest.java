package org.example.manager;

import org.example.Vehicle.HeavyVehicle;
import org.example.Vehicle.LightVehicle;
import org.example.Vehicle.MediumVehicle;
import org.example.Vehicle.Vehicle;
import org.example.enums.ParkingLotType;
import org.example.exceptions.ParkingSpaceUnavailableException;
import org.example.exceptions.VehicleAlreadyParkedException;
import org.example.exceptions.VehicleNeverParkedException;
import org.example.exceptions.VehicleTypeNotSupportedException;
import org.example.ticket.ParkingTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ManagerTest {
    Vehicle v1;
    Vehicle v2;
    Vehicle v3;
    String s1;
    String s2;
    Manager m;
    ParkingTicket p;
    @BeforeEach
    void setUp() {
         v1=new LightVehicle("1234",new Date());
         v2=new MediumVehicle("1234",new Date(2023,03,20));
        v3=new HeavyVehicle("1234",new Date(2023,03,20));
         s1="MALL";
         s2="STADIUM";
         m=new Manager();

    }
    @Test
    void create() {
    }

    @Test
    void isAvailable() throws ParkingSpaceUnavailableException, VehicleTypeNotSupportedException {

        m.createParkingLot(ParkingLotType.STADIUM);
        //Vehicle v=new MotorCycle("1234",new Date());
        assertTrue(m.isParkingAvailable(v1));

    }

    @Test
    void park() throws VehicleAlreadyParkedException, ParkingSpaceUnavailableException, VehicleTypeNotSupportedException {
        m.createParkingLot(ParkingLotType.MALL);
        System.out.println(m.park(v2).entry.toString());
    }

    @Test
    void unPark() throws VehicleAlreadyParkedException, VehicleNeverParkedException, ParkingSpaceUnavailableException, VehicleTypeNotSupportedException {
        m.createParkingLot(ParkingLotType.MALL);
        //wait(1000);
        ParkingTicket parkingTicket=m.park(v2);
       // System.out.println(m.unPark(parkingTicket).fee);
        System.out.println(m.unPark(parkingTicket).fee);


        //trying to unpark the already unparked vehicle
        //Assertions.assertThrows(VehicleNeverParkedException.class, (Executable)m.unPark(parkingTicket));
    }
}