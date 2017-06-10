package fr.enoviah.crossmouse.server;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Azword on 09/06/2017.
 */
public class Server {

    private int x = 0;
    private int y = 0;

    public Server() throws Exception {
        ServerSocket listener = new ServerSocket(9090);
        try {
            while (true) {
                Socket s = listener.accept();
                try {
                    BufferedReader input =
                            new BufferedReader(new InputStreamReader(s.getInputStream()));
                    String answer = input.readLine();
                    System.out.println("Recu : " + answer);
                    getPos(answer);
                    if (answer != null) {
                        updateMouse(answer);
                    }
                } finally {
                    s.close();
                }
            }
        } finally {
            listener.close();
        }

    }

    private void getPos(String s) {
        Pattern p = Pattern.compile("-?\\d+(,\\d+)*?\\.?\\d+?");
        List<String> numbers = new ArrayList<>();
        Matcher m = p.matcher(s);
        while (m.find()) {
            numbers.add(m.group());
        }
        if (numbers.size() == 2) {
            x = Integer.parseInt(numbers.get(0));
            y = Integer.parseInt(numbers.get(1));
        }
    }

    private void updateMouse(String s) throws Exception {
        Robot robot = new Robot();
        robot.mouseMove(x, y);
    }
}
