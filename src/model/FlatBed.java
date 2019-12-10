package model;

class FlatBed {

    /**
     * Maximum flatbed gradient.
     */
    private static final int MAX_GRADIENT = 70;

    /**
     * Minimum flatbed gradient.
     */
    private static final int MIN_GRADIENT = 0;

    /**
     * The flatbed gradient.
     */
    private int flatBedGradient;

    FlatBed() {
        flatBedGradient = 0;
    }

    /**
     * Lower the Flatbed.
     * @param amount The angle with which the bed will be lowered. Higher angle, lower bed.
     * @param currentSpeed The current speed of the object.
     * @return  Returns whether the action was a success or not.
     */
    boolean lowerBed(double amount, double currentSpeed) {
        if(flatBedGradient + amount > MAX_GRADIENT || currentSpeed > 0.1){
            return false;
        }
        flatBedGradient += amount;
        return true;
    }

    /**
     * Raise the Flatbed.
     * @param amount The angle with which the bed will be raised. Higher angle, lower bed.
     * @return  Returns whether the action was a success or not.
     */
    boolean raiseBed(double amount){
        if(flatBedGradient - amount < MIN_GRADIENT){
            return false;
        }
        flatBedGradient -= amount;
        return true;
    }

    /**
     * Lower the Flatbed to the bottom.
     * @param currentSpeed The current speed of the object.
     * @return  Returns whether the action was a success or not.
     */
    boolean lowerBed(double currentSpeed) {
        if (currentSpeed > 0.1) { return false; }
        flatBedGradient = 70;
        return true;
    }

    /**
     * Raise the Flatbed to the top.
     */
    void raiseBed() {
        flatBedGradient = 0;
    }

    /**
     * @return Returns whether the Flatbed is at the bottom or not.
     */
    boolean isBedDown() {
        return flatBedGradient > 0;
    }

    int getFlatBedGradient() {
        return flatBedGradient;
    }

}
