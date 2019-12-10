import model.AbstractVehicle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private final Assets assets;
    private final List<AbstractVehicle> vehicles;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.assets = new Assets();
        this.vehicles = new ArrayList<>();

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (AbstractVehicle vehicle : vehicles) {
            g.drawImage(assets.getImageByCar(vehicle.getModelName()), (int) Math.round(vehicle.getCurrentXCoordinate()), (int) Math.round(vehicle.getCurrentYCoordinate()), null);
        }

    }
}
