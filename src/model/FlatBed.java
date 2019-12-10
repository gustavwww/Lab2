package model;

class FlatBed {

    private static final int MAX_GRADIENT = 70;
    private static final int MIN_GRADIENT = 0;

    private int flatBedGradient;

    FlatBed() {
        flatBedGradient = 0;
    }

    boolean lowerBed(double amount, double currentSpeed) {
        if(flatBedGradient + amount > MAX_GRADIENT || currentSpeed > 0.1){
            return false;
        }
        flatBedGradient += amount;
        return true;
    }

    boolean raiseBed(double amount){
        if(flatBedGradient - amount < MIN_GRADIENT){
            return false;
        }
        flatBedGradient -= amount;
        return true;
    }

    int getFlatBedGradient() {
        return flatBedGradient;
    }

}
