package org.example.enums;

import org.example.Vehicle.CustomVehicle;
import org.example.Vehicle.HeavyVehicle;
import org.example.Vehicle.LightVehicle;
import org.example.Vehicle.MediumVehicle;

public enum VehicleClasses {
    LightVehicle(LightVehicle.class.getSimpleName()),
    MediumVehicle(MediumVehicle.class.getSimpleName()),
    HeavyVehicle(HeavyVehicle.class.getSimpleName()),
    CustomVehicle(CustomVehicle.class.getSimpleName())
    ;

    private final String text;

    /**
     * @param text
     */
    VehicleClasses(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
