import java.awt.*;

public class Volvo240 extends Car {

    /**
     * How much the engine is trimmed.
     */
    private final static double trimFactor = 1.25;

    /**
     * Constructor for Volvo240
     */
    public Volvo240(int x, int y) {
        super(x, y, 480, 4, 100, Color.red, "Volvo240");
    }
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
