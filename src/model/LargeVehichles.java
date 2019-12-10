package model;

import java.awt.*;

abstract class LargeVehichles extends AbstractVehicle {

    /**
     * @param nDoors      Number of doors
     * @param enginePower Power of engine in horsepower
     * @param color       model.Car's colour
     * @param modelName   The model of the car
     */
    LargeVehichles(int x, int y, int length, int width, int nDoors, double enginePower, Color color, String modelName) {
        super(x, y, length, width, nDoors, enginePower, color, modelName);
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }


}