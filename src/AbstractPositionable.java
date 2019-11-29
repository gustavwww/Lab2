import java.awt.*;

public abstract class AbstractPositionable implements IPositionable {

    /**
     * Length measured in centimeters
     */
    private final int length;

    /**
     * The initial X coordinate of the object
     */
    private double currentXCoordinate;

    /**
     * The initial Y coordinate of the object
     */
    private double currentYCoordinate;

    /**
     * @param x
     * @param y
     * @param length
     */

    public AbstractPositionable(int x, int y, int length) {
        this.length = length;
        this.currentXCoordinate = x;
        this.currentYCoordinate = y;
    }

    /**
     * Sets the current x coordinate
     * @param currentXCoordinate The x coordinate
     */
    protected void setCurrentXCoordinate(double currentXCoordinate) {
        this.currentXCoordinate = currentXCoordinate;
    }

    /**
     * Sets the current y coordinate
     * @param currentYCoordinate The y coordinate
     */
    protected void setCurrentYCoordinate(double currentYCoordinate) {
        this.currentYCoordinate = currentYCoordinate;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public double getCurrentXCoordinate() {
        return currentXCoordinate;
    }

    @Override
    public double getCurrentYCoordinate() {
        return currentYCoordinate;
    }

}
