import java.awt.*;

public abstract class LargeVehichles extends AbstractVehicle {

    /**
     * @param nDoors      Number of doors
     * @param enginePower Power of engine in horsepower
     * @param color       Car's colour
     * @param modelName   The model of the car
     */
    public LargeVehichles(int x, int y, int length, int nDoors, double enginePower, Color color, String modelName) {
        super(x, y, length, nDoors, enginePower, color, modelName);
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }


}