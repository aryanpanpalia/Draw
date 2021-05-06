package draw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class PaintMain {

    public static Color penColor;
    public static int thickness;
    public static String choice = "pen";

    public static boolean hasBeenChanged;

    public static int width;
    public static int height;

    public static void main(String[] args) {
        // sets the dimensions of the frames to be proper size on all screens
        Dimension sc = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) sc.getWidth();
        height = (int) sc.getHeight();

        JFrame changeFrame = new JFrame("Use this frame to change settings!");
        changeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changeFrame.setSize((int) (width / 2.5), (int) (height / 1.7));
        changeFrame.setLocation(width / 2, 0);
        changeFrame.setLayout(new FlowLayout());

        TheColorChooser colorChooser = new TheColorChooser();
        ThicknessChooser thicknessChooser = new ThicknessChooser(20);
        Options optionsChooser = new Options();

        changeFrame.add(colorChooser);
        changeFrame.add(thicknessChooser);
        changeFrame.add(optionsChooser);

        changeFrame.setVisible(true);

        // creates frame on which to draw
        Draw d = new Draw(width / 2, (int) (height / 1.25));
        d.run();
    }
}