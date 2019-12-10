import model.IVehicle;
import model.VehicleFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

    public void startTimer() {
        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IVehicle vehicle : vehicles) {
                vehicle.move();
                notifyObservers();
            }
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
