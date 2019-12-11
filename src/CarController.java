import model.*;
/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // The frame that represents this instance View of the MVC pattern
    CarView view;
    CarModel model;

    public CarController() {
        this.model = new CarModel();
    }

    public void start() {
        model.startTimer();
    }

    public static void main(String[] args) {

        CarController cc = new CarController();

        // Start a new view and send a reference of self
        CarView view = new CarView("CarSim 1.0", cc);
        cc.view = view;

        // Start the timer
        cc.start();
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IVehicle vehicle : model.vehicles) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (IVehicle vehicle : model.vehicles) {
            vehicle.brake(brake);
        }
    }

    void startAllCars() {
        for (IVehicle vehicle : model.vehicles) {
            vehicle.startEngine();
        }
    }

    void stopAllCars() {
        for (IVehicle vehicle : model.vehicles) {
            vehicle.stopEngine();
        }
    }

    void saabTurboOn() {
        for (IVehicle vehicle : model.vehicles) {
            if (vehicle instanceof ITurbo) {
                ((ITurbo) vehicle).setTurboOn();
            }
        }
    }

    void saabTurboOff() {
        for (IVehicle vehicle : model.vehicles) {
            if (vehicle instanceof ITurbo) {
                ((ITurbo) vehicle).setTurboOff();
            }
        }
    }

    void scaniaLiftBed() {
        for (IVehicle vehicle : model.vehicles) {
            if (vehicle instanceof IGradientFlatBed) {
                ((IGradientFlatBed) vehicle).raiseBed(5);
            }
        }
    }

    void scaniaLowerBed() {
        for (IVehicle vehicle : model.vehicles) {
            if (vehicle instanceof IGradientFlatBed) {
                ((IGradientFlatBed) vehicle).lowerBed(5);
            }
        }
    }

    void addCar() {
        model.addRandomCar();
    }

    void removeCar() {
        model.removeRandomCar();
    }

    void vehicleOutOfBounds(IVehicle vehicle) {
        vehicle.turn180();
    }

}
