import model.IVehicle;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InfoPanel extends JPanel implements ModelListener {

    private final CarController carC;

    private JLabel carStatusLabel = new JLabel();

    public InfoPanel(int x, int y, CarController carC) {
        this.carC = carC;

        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        setupLabel();

        carC.model.addObserver(this);
    }

    private void setupLabel() {
        updateStatusLabel();
        this.add(carStatusLabel);
    }

    private void updateStatusLabel() {
        StringBuilder sb = new StringBuilder();
        for (IVehicle vehicle : carC.model.vehicles) {
            sb.append(vehicle.getModelName()).append(" Speed: ").append(Math.round(vehicle.getCurrentSpeed())).append(" ");
        }
        carStatusLabel.setText(sb.toString());
    }

    @Override
    public void didUpdate() {
        updateStatusLabel();
        repaint();
    }

}
