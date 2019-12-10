package model;

import java.awt.*;

class Ferry extends LargeVehichles {

    /**
     * model.Carry delegation.
     */
    private Carry parent;
    /**
     * The state of the ramp.
     */
    private boolean rampDown = false;

    /**
     * Constructor for ferry.
     */
    Ferry(int x, int y) {
        super(x, y, 300000, 900, 400, 30000, Color.GREEN, "Friesland");
        this.parent = new Carry(300, 600);
    }

    /**
     * Lowers the ramp.
     * @return Returns true if successful.
     */
    public boolean lowerRamp(){
        if(getCurrentSpeed() > 0.1){
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

    /**
     * Unloads the first car that entered the ferry.
     * @return Returns true if successful.
     */
    public boolean unloadCar() {
        if (!rampDown) {
            return false;
        }
        parent.unloadLastObject(this, new Point(-10,-10));
        return true;

    }

    /**
     * Loads a car into the ferry.
     * @param car The car to load.
     * @return Returns true if successful.
     */
    public boolean loadCar(Car car) {
        if (!rampDown) {
            return false;
        }
        parent.loadObject(this, car);
        return true;
    }

    @Override
    public boolean gas(double amount){
        if(rampDown){return false;}
        return super.gas(amount);
    }

    @Override
    public void move(){

        super.move();
        for(AbstractPositionable object: parent.objects){
            parent.updateObjectLocation(object, this, new Point(0,0));
        }
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.0001;
    }

    public boolean isRampDown() {
        return rampDown;
    }

}
