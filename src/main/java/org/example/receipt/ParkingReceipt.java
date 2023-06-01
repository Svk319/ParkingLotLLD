package org.example.receipt;

import org.example.Vehicle.Vehicle;

import java.util.Date;

public class ParkingReceipt implements Receipt{
    public int fee;
    public Vehicle v;
    public final Date entryTime;
    public final Date exitTime;

    public ParkingReceipt(int fee, Vehicle v,Date entryTime) {
        this.fee = fee;
        this.v = v;
        this.entryTime=entryTime;
        this.exitTime=new Date();
    }
}
