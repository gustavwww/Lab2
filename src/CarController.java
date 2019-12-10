import model.*;

import javax.management.InvalidAttributeValueException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
    private final List<IVehicle> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        CarView frame = new CarView("CarSim 1.0", cc);

        cc.vehicles.add(VehicleFactory.createVolvo240(100, 100));
        cc.vehicles.add(VehicleFactory.createSaab95(100, 200));
        cc.vehicles.add(VehicleFactory.createScania(100, 300));

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
            for (IVehicle vehicle : vehicles) {
                vehicle.move();
                changeDirection(vehicle);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    private void changeDirection(IVehicle vehicle) {
        if (!isVehicleInFrame(vehicle)) {
            vehicle.turn180();
        }
    }

    private boolean isVehicleInFrame(IVehicle vehicle) {

        if ((!(vehicle.getCurrentXCoordinate() + vehicle.getLength() > frame.drawPanel.getWidth()) && !(vehicle.getCurrentXCoordinate() < 0))) {
            return (!(vehicle.getCurrentYCoordinate() + vehicle.getWidth() > frame.drawPanel.getHeight()) && !(vehicle.getCurrentYCoordinate() < 0));
        }

        return false;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IVehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (IVehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    void startAllCars() {
        for (IVehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    void stopAllCars() {
        for (IVehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    void saabTurboOn() {
        for (IVehicle vehicle : vehicles) {
            if (vehicle instanceof ITurbo) {
                ((ITurbo) vehicle).setTurboOn();
            }
        }
    }

    void saabTurboOff() {
        for (IVehicle vehicle : vehicles) {
            if (vehicle instanceof ITurbo) {
                ((ITurbo) vehicle).setTurboOff();
            }
        }
    }

    void scaniaLiftBed() {
        for (IVehicle vehicle : vehicles) {
            if (vehicle instanceof IFlatBed) {
                ((IFlatBed) vehicle).raiseBed(5);
            }
        }
    }

    void scaniaLowerBed() {
        for (IVehicle vehicle : vehicles) {
            if (vehicle instanceof IFlatBed) {
                ((IFlatBed) vehicle).lowerBed(5);
            }
        }
    }


}
