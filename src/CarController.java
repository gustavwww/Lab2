import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 17;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    // A list of cars, modify if needed
    private HashMap<AbstractVehicle, BufferedImage> vehicles = new HashMap<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        CarView frame = new CarView("CarSim 1.0", cc);

        cc.vehicles.put(new Volvo240(100, 100), frame.drawPanel.volvoImage);
        cc.vehicles.put(new Saab95(100, 200), frame.drawPanel.saabImage);
        cc.vehicles.put(new Scania(100, 300), frame.drawPanel.scaniaImage);

        // Start a new view and send a reference of self
        cc.frame = frame;

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Map.Entry<AbstractVehicle, BufferedImage> carSet : vehicles.entrySet()) {
                carSet.getKey().move();
                changeDirection(carSet);
                frame.drawPanel.moveit(vehicles);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    private void changeDirection(Map.Entry<AbstractVehicle, BufferedImage> carSet) {
        if (!isVehicleInFrame(carSet)) {
            carSet.getKey().turn180();
        }
    }

    private boolean isVehicleInFrame(Map.Entry<AbstractVehicle, BufferedImage> carSet) {

        AbstractVehicle car = carSet.getKey();
        BufferedImage carImage = carSet.getValue();

        if ((!(car.getCurrentXCoordinate() + carImage.getWidth() > frame.drawPanel.getWidth()) && !(car.getCurrentXCoordinate() < 0))) {
            return (!(car.getCurrentYCoordinate() + carImage.getHeight() > frame.drawPanel.getHeight()) && !(car.getCurrentYCoordinate() < 0));
        }

        return false;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (AbstractVehicle vehicle : vehicles.keySet()) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (AbstractVehicle vehicle : vehicles.keySet()) {
            vehicle.brake(brake);
        }
    }

    void startAllCars() {
        for (AbstractVehicle vehicle : vehicles.keySet()) {
            vehicle.startEngine();
        }
    }

    void stopAllCars() {
        for (AbstractVehicle vehicle : vehicles.keySet()) {
            vehicle.stopEngine();
        }
    }

    void saabTurboOn() {
        for (AbstractVehicle vehicle : vehicles.keySet()) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void saabTurboOff() {
        for (AbstractVehicle vehicle : vehicles.keySet()) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void scaniaLiftBed() {
        for (AbstractVehicle vehicle : vehicles.keySet()) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).raiseTruckBed(5);
            }
        }
    }

    void scaniaLowerBed() {
        for (AbstractVehicle vehicle : vehicles.keySet()) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).lowerTruckBed(5);
            }
        }
    }


}
