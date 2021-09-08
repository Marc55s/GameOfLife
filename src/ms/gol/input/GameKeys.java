package ms.gol.input;

import ms.gol.Computation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeys implements KeyListener {

    private final Computation computation;
    private boolean flag = false;

    {
        computation = new Computation();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        flag = !flag;
        if (flag) {
            computation.darkmode();
        } else {
            computation.whitemode();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
