import java.awt.*;

public class Scania extends LargeVehichles {

    private static final int MAX_GRADIENT = 70;
    private static final int MIN_GRADIENT = 0;

    private int truckBedGradient;

    /**
     * Constructor for Scania
     */
    public Scania(int x, int y) {
        super(x, y, 460,2, 110, Color.white, "ScaniaR620");
        truckBedGradient = 0;
    }

    public boolean lowerTruckBed(double amount) {
        if(truckBedGradient + amount > MAX_GRADIENT || getCurrentSpeed() > 0.1){
            return false;
        }
        truckBedGradient += amount;
        return true;
    }
    public boolean raiseTruckBed(double amount){
        if(truckBedGradient - amount < MIN_GRADIENT){
            return false;
        }
        truckBedGradient -= amount;
        return true;
    }
    @Override
    public boolean gas(double amount){
        if(truckBedGradient > 0){return false;}
        return super.gas(amount);
    }

    public int getTruckBedGradient() {
        return truckBedGradient;
    }
}
