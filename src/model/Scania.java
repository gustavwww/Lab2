package model;

import java.awt.*;

class Scania extends LargeVehichles implements IGradientFlatBed {

    /**
     * model.FlatBed delegation.
     */
    private FlatBed flatBed;

    /**
     * Constructor for model.Scania
     */
    Scania(int x, int y) {
        super(x, y, 100, 60, 2, 110, Color.white, "ScaniaR620");
        this.flatBed = new FlatBed();
    }

    /**
     * Lower the trucks Flatbed.
     * @param amount The angle with which the bed will be lowered. Higher angle, lower bed.
     * @return  Returns whether the action was a success or not.
     */
    public boolean lowerBed(double amount) {
        return flatBed.lowerBed(amount, getCurrentSpeed());
    }

    /**
     * Raise the trucks Flatbed.
     * @param amount The angle with which the bed will be raised. Higher angle, lower bed.
     * @return  Returns whether the action was a success or not.
     */
    public boolean raiseBed(double amount) {
        return flatBed.raiseBed(amount);
    }

    @Override
    public boolean gas(double amount){
        if(flatBed.getFlatBedGradient() > 0){return false;}
        return super.gas(amount);
    }

}
