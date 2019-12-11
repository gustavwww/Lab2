package model;

import java.awt.*;

class Volvo240 extends Car {

    /**
     * How much the engine is trimmed.
     */
    private final static double trimFactor = 1.25;

    /**
     * Constructor for model.Volvo240
     */
    Volvo240(int x, int y) {
        super(x, y, 100, 60, 4, 100, Color.red, "Volvo240");
    }

    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
