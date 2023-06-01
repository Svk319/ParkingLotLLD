package org.example.enums;

public enum ParkingLotType {
    MALL("MALL"),STADIUM("STADIUM"),CUSTOM("CUSTOM");

    private final String text;

    /**
     * @param text
     */
    ParkingLotType(final String text) {
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
