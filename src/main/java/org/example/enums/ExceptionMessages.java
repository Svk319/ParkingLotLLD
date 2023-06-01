package org.example.enums;

public enum ExceptionMessages {

        VEHICLE_ALREADY_PARKED("This vehicle is already parked."),
        DUPLICATE_VEHICLE("Duplicate vehicle found in parked state."),
        VEHICLE_NEVER_PARKED("This vehicle is already parked."),
        PARKING_SPACE_UNAVAILABLE("Currently parking space is not available"),
        VEHICLE_TYPE_NOT_SUPPORTED("Currently parking space is not available for this type of vehicle"),
        PARKINGSPOT_NOT_DEFINED("This type of parking spot is not supported.")
        ;

        private final String text;

        /**
         * @param text
         */
        ExceptionMessages(final String text) {
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
