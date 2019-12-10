package model;

import java.awt.*;

class Peterbilt379 extends LargeVehichles implements IFlatBed {


    private FlatBed flatBed;
    /**
     * model.Carry delegation.
     */
    private Carry carry;
    /**
     * The state of the ramp.
     */
    private boolean rampDown;

    /**
     * The constructor for model.Peterbilt379
     */
    Peterbilt379(int x, int y) {
        super(x, y, 100, 60, 2, 140, Color.red, "ScaniaTekno");
        this.carry = new Carry(6, 480);
        this.flatBed = new FlatBed();
        rampDown = false;
    }

    /**
     * Unloads the last car that entered the ferry.
     * @return Returns true if successful.
     */
    public boolean unloadCar() {
        if (!rampDown) {
            return false;
        }
        carry.unloadFirstObject(this, new Point(-10,-10));
        return true;

    }

    /**
     * Loads a car into the model.Peterbilt379.
     * @param car The car to load.
     * @return Returns true if successful.
     */
    public boolean loadCar(Car car) {
        if (!rampDown) {
            return false;
        }
        carry.loadObject(this, car);
        return true;
    }

    /**
     * Lowers the ramp.
     * @return Returns true if successful.
     */
    public boolean lowerRamp(){
        if(getCurrentSpeed() > 0.1) {
            return false;
        }
        rampDown = true;
        return true;
    }

    /**
     * Raises the ramp.
     */
    public void raiseRamp(){
        rampDown = false;
    }

    public boolean isRampDown() {
        return rampDown;
    }
}
