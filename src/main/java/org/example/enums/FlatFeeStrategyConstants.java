package org.example.enums;

public enum FlatFeeStrategyConstants {
    LightVehicle(10),MediumVehicle(20),HeavyVehicle(50);

    public int getValue() {
        return value;
    }

    private final int value;


    FlatFeeStrategyConstants(final int value) {
        this.value = value;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return this.value+"";
    }
}
