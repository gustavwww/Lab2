public class AbstractMoveable extends AbstractPositionable implements IMoveable {


    /**
     * The current speed of the object
     */
    private double currentSpeed;

    /**
     * The objects's current direction
     * 0 = Left
     * 1 = Up
     * 2 = Right
     * 3 = Down
     */
    private int direction = 2;

    /**
     * @param length
     */
    public AbstractMoveable(int x, int y, int length) {
        super(x, y, length);
    }

    @Override
    public void move() {
        switch(direction){
            case 1: setCurrentYCoordinate(getCurrentYCoordinate() - currentSpeed); break;
            case 3: setCurrentYCoordinate(getCurrentYCoordinate() + currentSpeed); break;
            case 0: setCurrentXCoordinate(getCurrentXCoordinate() - currentSpeed); break;
            case 2: setCurrentXCoordinate(getCurrentXCoordinate() + currentSpeed); break;
        }
    }

    @Override
    public void turn180() {
        direction = (direction + 6) % 4;
    }

    @Override
    public void turn90Left() {
        direction = (direction + 3) % 4;
    }

    @Override
    public void turn90Right() {
        direction = (direction + 1) % 4;
    }

    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    @Override
    public int getDirection() {
        return direction;
    }

    /**
     * Sets the current speed of the object
     * @param currentSpeed The current speed
     */
    protected void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

}
