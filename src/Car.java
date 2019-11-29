import java.awt.*;

public abstract class Car extends AbstractVehicle {

    /**
     * @param nDoors      Number of doors
     * @param enginePower Power of engine in horsepower
     * @param color       Car's colour
     * @param modelName   The model of the car
     */
    public Car(int x, int y, int length, int nDoors, double enginePower, Color color, String modelName) {
        super(x, y, length, nDoors, enginePower, color, modelName);
    }

}
