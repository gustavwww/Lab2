package model;

import java.awt.*;

abstract class AbstractVehicle extends AbstractMoveable implements IVehicle {

    /**
     * Number of doors
     */
    private final int nDoors;
    /**
     * Power of engine in horsepower
     */
    private final double enginePower;
    /**
     * model.Car's colour.
     */
    private Color color;
    /**
     * The model of the car
     */
    private String modelName;

    /**
     * Controls the engine
     */
    private boolean engineRunning;

    /**
     * @param nDoors         Number of doors
     * @param enginePower    Power of engine in horsepower
     * @param color          model.Car's colour
     * @param modelName      The model of the car
     */
    AbstractVehicle(int x, int y, int length, int width, int nDoors, double enginePower, Color color, String modelName) {
        super(x, y, length, width);
        this.nDoors = nDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;

        stopEngine();
    }


    /**
     * Stops the engine.
     * Set's the current speed to 0.
     */
    public void stopEngine() {
        this.engineRunning = false;
        setCurrentSpeed(0);
    }
    /**
     * Starts the engine.
     * Set's the current speed to 0.1.
     */
    public void startEngine() {
        if (this.engineRunning) { return; }
        this.engineRunning = true;
        setCurrentSpeed(0.1);
    }

    /**
     *  Increases the current speed of the car.
     * @param amount    How much the speed should change!
     */
    private void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));

    }

    /**
     *  Decreases the current speed of the car.
     * @param amount    How much the speed should change!
     */
    private void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    /**
     * Calculates the acceleration of the car depending on turbos or trimfactors.
     * @return      The acceleration.
     */
    protected abstract double speedFactor();

    /**
     * Accelerates the car.
     * @param amount How much the speed should change!
     * @return Returns false if the amount is greater than 1 or less than 0.
     */
    public boolean gas(double amount){
        if (!engineRunning) { return false; }
        if (amount > 1 || amount < 0){
            return false;
        }
        incrementSpeed(amount);
        return true;
    }

    /**
     * Decelerates the car.
     * @param amount How much the speed should change!
     * @return Returns false if the amount is greater than 1 or less than 0.
     */
    public boolean brake(double amount){
        if (amount > 1 || amount < 0){
            return false;
        }
        decrementSpeed(amount);
        return true;
    }

    public Color getColor() {
        return color;
    }

    public int getnDoors() {
        return nDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public String getModelName() {
        return modelName;
    }
}
