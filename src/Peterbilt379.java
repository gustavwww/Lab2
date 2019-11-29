import java.awt.*;
import java.util.Stack;

public class Peterbilt379 extends LargeVehichles {

    /**
     * Carry delegation.
     */
    private Carry parent;
    /**
     * The state of the ramp.
     */
    private boolean rampDown;

    /**
     * The constructor for Peterbilt379
     */
    public Peterbilt379(int x, int y) {
        super(x, y, 460,2, 140, Color.red, "ScaniaTekno");
        this.parent = new Carry(6, 480);
        rampDown = false;
    }

    /**
     * Unloads the last car that entered the ferry.
     * @return Returns true if successful.
     */
    public boolean unloadCar() {
        if (!rampDown) {
            return false;
        }
        parent.unloadFirstObject(this, new Point(-10,-10));
        return true;

    }

    /**
     * Loads a car into the Peterbilt379.
     * @param car The car to load.
     * @return Returns true if successful.
     */
    public boolean loadCar(Car car) {
        if (!rampDown) {
            return false;
        }
        parent.loadObject(this, car);
        return true;
    }

    /**
     * Lowers the ramp.
     * @return Returns true if successful.
     */
    public boolean lowerRamp(){
        if(getCurrentSpeed() > 0.1){
            return false;
        }
        rampDown = true;
        return true;
    }

    /**
     * Raises the ramp.
     */
    public void raiseRamp(){
        rampDown = false;
    }

    public boolean isRampDown() {
        return rampDown;
    }
}
