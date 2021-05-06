package draw;

import javax.swing.*;
import java.awt.*;

public class Options extends JPanel {

    public Options() {
        String[] choices = {"pen", "eraser"};
        JComboBox<String> modes = new JComboBox<>(choices);

        modes.addActionListener(e -> PaintMain.choice = (String) ((JComboBox<String>) e.getSource()).getSelectedItem());

        this.add(modes);
        this.setPreferredSize(new Dimension(100, 100));
    }
}