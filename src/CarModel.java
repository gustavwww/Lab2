import model.IVehicle;
import model.VehicleFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CarModel {

    final List<IVehicle> vehicles = new ArrayList<>();

    private final int delay = 17;
    private Timer timer = new Timer(delay, new TimerListener());

    private final List<ModelListener> observers = new ArrayList<>();

    public CarModel() {
        // Initial cars.
        vehicles.add(VehicleFactory.createVolvo240(100, 100));
        vehicles.add(VehicleFactory.createSaab95(100, 200));
        vehicles.add(VehicleFactory.createScania(100, 300));
    }

    // Start The Game and the Game Loop.
    public void startTimer() {
        timer.start();
    }

    // Adds a random car.
    public void addRandomCar() {
        if (vehicles.size() >= 10) { return; }
        int xPos = getNextXPos();
        int yPos = getNextYPos();

        vehicles.add(VehicleFactory.createRandomVehicle(xPos, yPos));
    }

    // Removes the last added car.
    public void removeLastCar() {
        if (vehicles.isEmpty()) { return; }
        vehicles.remove(vehicles.size() - 1);
    }

    // Calculates the X position for the next added car.
    private int getNextXPos() {
        if (vehicles.size() % 4 == 0) {
            return 150*(vehicles.size() / 4 + 1);
        }
        return (int) (150*(Math.ceil((vehicles.size() + 1) / 4.0)));
    }

    // Calculates the Y position for the next added car.
    private int getNextYPos() {
        return 100*((vehicles.size() % 4) + 1);
    }

    // Game Loop
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IVehicle vehicle : vehicles) {
                vehicle.move();
            }
            notifyObservers();
        }
    }

    // Observers
    private void notifyObservers() {
        for (ModelListener observer : observers) {
            observer.didUpdate();
        }
    }

    public void addObserver(ModelListener observer) {
        observers.add(observer);
    }


}
