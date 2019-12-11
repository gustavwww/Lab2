
import model.IVehicle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements ModelListener {

    private final CarController carC;

    private final Assets assets;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarController carC) {
        this.assets = new Assets();
        this.carC = carC;

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        carC.model.addObserver(this);
    }

    @Override
    public void didUpdate() {
        checkVehiclesInFrame();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (IVehicle vehicle : carC.model.vehicles) {
            g.drawImage(assets.getImageByCar(vehicle.getModelName()), (int) Math.round(vehicle.getCurrentXCoordinate()), (int) Math.round(vehicle.getCurrentYCoordinate()), null);
        }
    }

    // Checks whether any vehicle is out of frame reporting to CarController
    private void checkVehiclesInFrame() {
        for (IVehicle vehicle : carC.model.vehicles) {
            if (!isVehicleInFrame(vehicle)) {
                carC.vehicleGotOutOfFrame(vehicle);
            }
        }
    }

    // Checks whether a vehicle is in frame.
    private boolean isVehicleInFrame(IVehicle vehicle) {
        if ((!(vehicle.getCurrentXCoordinate() + vehicle.getLength() > getWidth()) && !(vehicle.getCurrentXCoordinate() < 0))) {
            return (!(vehicle.getCurrentYCoordinate() + vehicle.getWidth() > getHeight()) && !(vehicle.getCurrentYCoordinate() < 0));
        }
        return false;
    }


}
