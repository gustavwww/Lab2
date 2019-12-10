package model;

import java.awt.*;

class Ferry extends LargeVehichles implements ICarry<Car> {

    /**
     * model.FlatBed delegation.
     */
    private final FlatBed flatBed;
    /**
     * model.Carry delegation.
     */
    private final Carry<Car> carry;

    /**
     * Constructor for ferry.
     */
    Ferry(int x, int y) {
        super(x, y, 300000, 900, 400, 30000, Color.GREEN, "Friesland");
        this.carry = new Carry<>(this, 300, 600);
        this.flatBed = new FlatBed();
    }

    /**
     * Lowers the ramp.
     * @return Returns true if successful.
     */
    public boolean lowerRamp(){
        return flatBed.lowerBed(getCurrentSpeed());
    }

    /**
     * Raises the ramp.
     */
    public void raiseRamp(){
        flatBed.raiseBed();
    }

    /**
     * Unloads the first car that entered the ferry.
     * @return Returns the unloaded Car.
     */
    @Override
    public Car unload() {
        if (!flatBed.isBedDown()) {
            throw new IllegalCallerException();
        }
        return carry.unloadLastObject(new Point(-10,-10));
    }

    /**
     * Loads a car into the ferry.
     * @param car The car to load.
     * @return Returns true if successful.
     */
    @Override
    public boolean load(Car car) {
        if (!flatBed.isBedDown()) {
            return false;
        }
        return carry.loadObject(car);
    }

    @Override
    public boolean gas(double amount){
        if(flatBed.isBedDown()){return false;}
        return super.gas(amount);
    }

    @Override
    public void move(){
        super.move();
        carry.updateAllObjectsLocation();
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.0001;
    }

    public boolean isRampDown() {
        return flatBed.isBedDown();
    }

}
