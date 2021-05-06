package draw;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class TheColorChooser extends JPanel implements ChangeListener {
    private final JColorChooser chooser;

    public TheColorChooser() {
        super(new BorderLayout());

        chooser = new JColorChooser();
        chooser.getSelectionModel().addChangeListener(this);
        chooser.setBorder(BorderFactory.createTitledBorder("Choose pen color"));

        add(chooser, BorderLayout.PAGE_END);
    }

    public void stateChanged(ChangeEvent e) {
        PaintMain.penColor = chooser.getColor();
        PaintMain.hasBeenChanged = true;
    }

}