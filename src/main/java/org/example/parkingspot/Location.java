package org.example.parkingspot;

public class Location {
    private String buildingId;
    private String floorId;
    private Integer id;

    public String getBuildingId() {
        return this.buildingId;
    }

    public void setBuildingId(String building) {
        this.buildingId = building;
    }

    public String getFloorId() {
        return this.floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
