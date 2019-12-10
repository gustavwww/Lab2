package model;

import java.awt.*;

class Peterbilt379 extends LargeVehichles implements ICarry<Car>, IFlatBed {

    /**
     * model.Flatbed delegation.
     */
    private final FlatBed flatBed;
    /**
     * model.Carry delegation.
     */
    private final Carry<Car> carry;

    /**
     * The constructor for model.Peterbilt379
     */
    Peterbilt379(int x, int y) {
        super(x, y, 100, 60, 2, 140, Color.red, "ScaniaTekno");
        this.carry = new Carry<>(this, 6, 480);
        this.flatBed = new FlatBed();
    }

    /**
     * Unloads the last car that entered the ferry.
     * @return Returns true if successful.
     */
    @Override
    public Car unload() {
        if (!flatBed.isBedDown()) {
            throw new IllegalCallerException();
        }
        return carry.unloadFirstObject(new Point(-10,-10));
    }

    /**
     * Loads a car into the model.Peterbilt379.
     * @param car The car to load.
     * @return Returns true if successful.
     */
    @Override
    public boolean load(Car car) {
        if (!flatBed.isBedDown()) {
            return false;
        }
        carry.loadObject(car);
        return true;
    }

    @Override
    public void move() {
        super.move();
        carry.updateAllObjectsLocation();
    }

    /**
     * Lowers the ramp.
     * @return Returns true if successful.
     */
    public boolean lowerRamp() {
        return flatBed.lowerBed(getCurrentSpeed());
    }

    /**
     * Raises the ramp.
     */
    public void raiseRamp() {
        flatBed.raiseBed();
    }

    public boolean isRampDown() {
        return flatBed.isBedDown();
    }
}
