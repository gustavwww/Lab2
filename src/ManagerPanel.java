import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerPanel extends JPanel {

    private final CarController carC;

    public ManagerPanel(int x, int y, CarController carC) {
        this.carC = carC;

        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        initComponents();
    }

    private void initComponents() {

        JButton addCarBtn = new JButton("Add Car");
        JButton removeCarBtn = new JButton("Remove Car");

        addCarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                carC.addCar();
            }
        });

        removeCarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                carC.removeCar();
            }
        });

        this.add(addCarBtn);
        this.add(removeCarBtn);

    }

}
