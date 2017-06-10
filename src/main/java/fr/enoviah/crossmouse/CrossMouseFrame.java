package fr.enoviah.crossmouse;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.util.WindowMover;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Azword on 09/06/2017.
 */
public class CrossMouseFrame extends JFrame {

    private final CrossMousePanel panel;

    public CrossMouseFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("Borne | Epitech");
        setSize(800, 800);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setContentPane(this.panel = new CrossMousePanel());
        setBackground(Swinger.TRANSPARENT);
        WindowMover mover = new WindowMover(this);
        addMouseListener(mover);
        addMouseMotionListener(mover);
        setVisible(true);
    }

    public CrossMousePanel getPanel() {
        return (panel);
    }
}
