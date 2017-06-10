package fr.enoviah.crossmouse.client;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

/**
 * Created by Azword on 09/06/2017.
 */
public class MouseListener implements NativeMouseInputListener {

    private static int x = 0;
    private static int y = 0;

    public void nativeMouseClicked(NativeMouseEvent e) {
    }

    public void nativeMousePressed(NativeMouseEvent e) {

    }

    public void nativeMouseReleased(NativeMouseEvent e) {

    }

    public void nativeMouseMoved(NativeMouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public void nativeMouseDragged(NativeMouseEvent e) {
    }

    public int getX() {
        return (x);
    }

    public int getY() {
        return (y);
    }
}