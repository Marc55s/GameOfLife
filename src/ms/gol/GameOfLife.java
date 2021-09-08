package ms.gol;

import ms.gol.input.GameKeys;
import ms.gol.input.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

public class GameOfLife {

    public final static int WIDTH = 800, HEIGHT = 800;
    public static int generator = 0;

    public GameOfLife() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int monitorWidth = gd.getDisplayMode().getWidth();
        int monitorHeight = gd.getDisplayMode().getHeight();
        JFrame f = new JFrame();
        f.add(new Draw());
        f.addMouseListener(new MouseAdapter());
        f.addKeyListener(new GameKeys());
        f.setBackground(Computation.bl);
        f.setLayout(null);
        f.setUndecorated(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(new Point(monitorWidth / 2 - WIDTH / 2, monitorHeight / 2 - HEIGHT / 2));
        f.setSize(WIDTH, HEIGHT);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        generator = JOptionPane.showConfirmDialog(null, "Generate random map?");
        new GameOfLife();
    }

}
