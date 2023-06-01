package org.example.enums;

public enum AllocationStrategies {
    RANDOM("Random Strategy"),
    NEAREST("Nearest parking spot to the vehicle filling Strategy"),
    UNIFORM("Uniformly distributed filling of available spots."),
    SEQUENTIAL("Sequentially distributed filling of available spots.")
    ;

    private final String text;

    /**
     * @param text
     */
    AllocationStrategies(final String text) {
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
