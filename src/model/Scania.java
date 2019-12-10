package model;

import java.awt.*;

class Scania extends LargeVehichles implements IFlatBed {

    private FlatBed flatBed;

    /**
     * Constructor for model.Scania
     */
    Scania(int x, int y) {
        super(x, y, 100, 60, 2, 110, Color.white, "ScaniaR620");
        this.flatBed = new FlatBed();
    }

    public boolean lowerBed(double amount) {
        return flatBed.lowerBed(amount, getCurrentSpeed());
    }
    public boolean raiseBed(double amount) {
        return flatBed.raiseBed(amount);
    }

    @Override
    public boolean gas(double amount){
        if(flatBed.getFlatBedGradient() > 0){return false;}
        return super.gas(amount);
    }

}
