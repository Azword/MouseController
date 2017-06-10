package fr.enoviah.crossmouse;


/**
 * Created by Azword on 09/06/2017.
 */
public class CrossMouse {

    private CrossMouse() {
        CrossMouseFrame crossMouseFrame = new CrossMouseFrame();
        CrossMousePanel crossMousePanel = crossMouseFrame.getPanel();
    }

    public static void main(String[] args) {
        CrossMouse crossMouse = new CrossMouse();
    }
}
