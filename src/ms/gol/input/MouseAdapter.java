package ms.gol.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseAdapter implements MouseListener {
    public static boolean isInsideWindow = false;
    public static boolean isPressed = false;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        isPressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isPressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        isInsideWindow = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        isInsideWindow = false;
    }

}
