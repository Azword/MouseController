package fr.enoviah.crossmouse;

import fr.enoviah.crossmouse.client.Client;
import fr.enoviah.crossmouse.server.Server;
import fr.enoviah.utils.ResourceFinder;
import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.event.SwingerEvent;
import fr.theshark34.swinger.event.SwingerEventListener;
import fr.theshark34.swinger.textured.STexturedButton;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

/**
 * Created by Azword on 09/06/2017.
 */
public class CrossMousePanel extends JPanel implements SwingerEventListener {

    private final Optional<Image> background = ResourceFinder.getImagePath("bg.png");
    private final JTextField ipField = new JTextField("");
    private final STexturedButton join = new STexturedButton(ResourceFinder.getImageBuffered("connect.png"), ResourceFinder.getImageBuffered("connectHover.png"), ResourceFinder.getImageBuffered("connectHover.png"));
    private final STexturedButton host = new STexturedButton(ResourceFinder.getImageBuffered("connect.png"), ResourceFinder.getImageBuffered("connectHover.png"), ResourceFinder.getImageBuffered("connectHover.png"));
    private final JLabel joinMsg = new JLabel("Connect !");
    private final JLabel hostMsg = new JLabel("Hosting !");

    public CrossMousePanel() {
        setLayout(null);
        setBackground(Swinger.TRANSPARENT);

        this.joinMsg.setForeground(Color.BLACK);
        this.joinMsg.setFont(this.joinMsg.getFont().deriveFont(30.0F));
        this.joinMsg.setBounds(325, 440, 300, 40);
        add(this.joinMsg);

        this.hostMsg.setForeground(Color.BLACK);
        this.hostMsg.setFont(this.hostMsg.getFont().deriveFont(30.0F));
        this.hostMsg.setBounds(325, 300, 300, 40);
        add(this.hostMsg);

        this.join.setBounds(270, 400, 250, 120);
        this.join.addEventListener(this);
        add(this.join);

        this.host.setBounds(270, 260, 250, 120);
        this.host.addEventListener(this);
        add(this.host);

        this.ipField.setBounds(270, 550, 250, 30);
        this.ipField.setToolTipText("Syntax : XXX.XXX.XXX.XXX.");
        add(this.ipField);

    }

    public void onEvent(SwingerEvent e) {
        if (e.getSource() == this.join) {
            if (isCorrectIp(ipField.getText())) {
                this.join.setEnabled(false);
                Thread t = new Thread(() -> {
                    try {
                        new Client(ipField.getText());
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                });
                t.start();

            } else
                JOptionPane.showMessageDialog(this, "Bad Syntax for IP Correct : \n192.x.x.x.", "Erreur", 0);
        } else if (e.getSource() == this.host) {
            this.host.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Your mouse is accessible in lan now.", "Info", 0);
            try {
                new Server();
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }

    private boolean isCorrectIp(String s) {
        char[] tab = s.toCharArray();
        int i = 0;
        int count = 0;
        while (i != s.length()) {
            if (tab[i] == '.')
                count++;
            i++;
        }
        return count == 3;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        background.ifPresent(image -> graphics.drawImage(image, getWidth() / 2 - 300, getHeight() / 2 - 250, 600, 570, this));
    }

}
