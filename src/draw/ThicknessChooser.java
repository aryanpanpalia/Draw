package draw;

import javax.swing.*;

public class ThicknessChooser extends JPanel {

    private final JSlider slider;

    public ThicknessChooser(int max) {
        slider = new JSlider(JSlider.HORIZONTAL, 0, max, 5);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);

        slider.addChangeListener(e -> {
            PaintMain.thickness = slider.getValue();
            PaintMain.hasBeenChanged = true;
        });

        this.add(slider);

    }

}