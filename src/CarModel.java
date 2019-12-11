import model.IVehicle;
import model.VehicleFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarModel {

    private final int delay = 17;
    private Timer timer = new Timer(delay, new TimerListener());

    final List<IVehicle> vehicles = new ArrayList<>();

    private final List<ModelListener> observers = new ArrayList<>();

    public CarModel() {
        vehicles.add(VehicleFactory.createVolvo240(100, 100));
        vehicles.add(VehicleFactory.createSaab95(100, 200));
        vehicles.add(VehicleFactory.createScania(100, 300));
    }

    //TODO: Clean up Model Class and these add/remove Car methods
    public void addRandomCar() {
        if (vehicles.size() >= 10) {
            return;
        }

        Random rand = new Random();
        switch (rand.nextInt(3)) {

            case 0:
                vehicles.add(VehicleFactory.createVolvo240(100, 100*(vehicles.size() + 1)));
                break;
            case 1:
                vehicles.add(VehicleFactory.createSaab95(100, 100*(vehicles.size() + 1)));
                break;
            case 2:
                vehicles.add(VehicleFactory.createScania(100, 100*(vehicles.size() + 1)));
                break;

        }
    }

    public void removeLastCar() {
        if (vehicles.isEmpty()) {
            return;
        }
        vehicles.remove(vehicles.size() - 1);
    }

    public void startTimer() {
        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IVehicle vehicle : vehicles) {
                vehicle.move();
            }
            notifyObservers();
        }
    }

    private void notifyObservers() {
        for (ModelListener observer : observers) {
            observer.didUpdate();
        }
    }

    public void addObserver(ModelListener observer) {
        observers.add(observer);
    }


}
