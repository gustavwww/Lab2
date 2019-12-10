package model;

abstract class AbstractPositionable implements IPositionable {

    /**
     * Length measured in centimeters
     */
    private final int length;

    private final int width;

    /**
     * The initial X coordinate of the object
     */
    private double currentXCoordinate;

    /**
     * The initial Y coordinate of the object
     */
    private double currentYCoordinate;

    /**
     * @param x The X coordinate
     * @param y The Y coordinate
     * @param length The length of the object
     * @param width The width of the object
     */

    AbstractPositionable(int x, int y, int length, int width) {
        this.length = length;
        this.width = width;
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
    public int getWidth() {
        return width;
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
