package draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Draw implements Runnable {

    private final JFrame f;
    private int lastX;
    private int lastY;
    private int x;
    private int y;

    private boolean repaint = true;

    public Draw(int width, int height) {
        f = new JFrame("Aryan's malware") {
            public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;

                if (PaintMain.choice.equals("eraser"))
                    g2d.setColor(Color.white);
                else
                    g2d.setColor(PaintMain.penColor);

                g2d.setStroke(new BasicStroke(PaintMain.thickness));
                g.drawLine(lastX, lastY, x, y);

                g.dispose();
                g2d.dispose();

                repaint = false;
            }
        };

        f.setSize(width, height);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLocale(null);

        f.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                lastX = e.getX();
                lastY = e.getY();
                x = e.getX();
                y = e.getY();
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        });

        f.addMouseMotionListener(new MouseMotionListener() {

            public void mouseDragged(MouseEvent e) {
                repaint = true;
                lastX = x;
                lastY = y;
                x = e.getX();
                y = e.getY();
            }

            public void mouseMoved(MouseEvent e) {
            }

        });

    }

    public void run() {
        while (true) {
            System.out.println();
            if (repaint)
                f.repaint();
        }
    }

}