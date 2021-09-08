package ms.gol;

import ms.gol.input.MouseAdapter;

import javax.swing.JPanel;
import java.awt.*;

import static java.lang.Integer.parseInt;

public class Draw extends JPanel {

    private int counter;
    private final Computation computation;

    {
        counter = 0;
        computation = new Computation();
    }

    public Draw() {
        setSize(GameOfLife.WIDTH, GameOfLife.HEIGHT);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        counter++;
        computation.draw(g);
        if (MouseAdapter.isInsideWindow && MouseAdapter.isPressed) {
            counter--;
            computation.setCompute(false);
            int[] loc = startByMouse();
            int x = loc[0];
            int y = loc[1];
            for (int i = 0; i < computation.getGridSize(); i++) {
                for (int j = 0; j < computation.getGridSize(); j++) {
                    if (round(x) == i * 10 && round(y) == j * 10)
                        computation.getGrid()[i][j] = 1;
                }
            }
        } else if (MouseAdapter.isInsideWindow) {
            counter--;
        } else if (!MouseAdapter.isInsideWindow && !MouseAdapter.isPressed) {
            computation.setCompute(true);
        }


        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Counter
        g.setColor(computation.bl);
        g.setFont(new Font("Arcade", Font.BOLD, 25));
        g.drawString(String.format("%d", counter), 650, 50);
        repaint();
    }

    int[] startByMouse() {
        int[] location = new int[2];
        PointerInfo pi = MouseInfo.getPointerInfo();
        Point currentMouse = pi.getLocation();
        int x = (int) currentMouse.getX();
        int y = (int) currentMouse.getY();

        location[0] = x - 560;
        location[1] = y - 140;

        return location;
    }

    private int round(int i) {
        double ret = i / 10;
        String[] f = String.valueOf(i).split("");
        if (parseInt(f[f.length - 1]) > 4) {
            ret = (int) Math.ceil(ret);
        } else {
            ret = (int) Math.floor(ret);
        }
        return (int) (ret * 10);
    }


}
