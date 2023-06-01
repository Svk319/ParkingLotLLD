package org.example.exceptions;

public class ParkingSpaceUnavailableException extends Exception{
    public ParkingSpaceUnavailableException(String message) {
        super(message);
    }
}
