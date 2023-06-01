package org.example.parkinglot;

public class ParkingLotFactory {
    public AbstractParkingLot getInstance(String type){
        switch(type){
            case "MALL":
                return new MallParkingParkingLot();
            case "STADIUM":
                return new StadiumParkingParkingLot();
            default:
                return null;

        }
    }
}
