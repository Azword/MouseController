package fr.enoviah.crossmouse.client;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Azword on 09/06/2017.
 */
public class Client {

    public Client(String ip) throws Exception {
        MouseListener mouseListener = enableListening();
        while (true) {
            if (mouseListener.getX() >= 0 && mouseListener.getY() >= 0) {
                Socket s = new Socket(ip, 9090);
                PrintWriter out =
                        new PrintWriter(s.getOutputStream(), true);
                String str = "X: " + mouseListener.getX() + " Y: " + mouseListener.getY();
                out.println(str);
            }
        }
    }

    private MouseListener enableListening() {
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        logger.setUseParentHandlers(false);
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
        MouseListener listener = new MouseListener();
        GlobalScreen.addNativeMouseListener(listener);
        GlobalScreen.addNativeMouseMotionListener(listener);
        return (listener);
    }
}
