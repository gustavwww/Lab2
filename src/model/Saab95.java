package model;

import java.awt.*;

class Saab95 extends Car implements ITurbo {

    /**
     * The current state of the turbo
     */
    private boolean turboOn;

    /**
     * Constructor for model.Saab95
     */
    Saab95(int x, int y) {
        super(x, y, 100, 60, 2, 125, Color.BLACK, "model.Saab95");
        this.turboOn = false;
    }

    /**
     * Turns the turbo on
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Turn the turbo off
     */
    public void setTurboOff() { turboOn = false; }


    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }


}
