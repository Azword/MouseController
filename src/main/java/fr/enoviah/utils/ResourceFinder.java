package fr.enoviah.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

/**
 * Created by Azword on 05/06/2017.
 */
public class ResourceFinder {

    private static String path = "";

    public static BufferedImage getImageBuffered(String s) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream(path + s);
        try {
            return ImageIO.read(is);
        } catch (IOException | IllegalArgumentException var2) {
            throw new IllegalArgumentException("Can't load the given resource ) : ");
        }
    }

    public static Optional<Image> getImagePath(String s) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream(path + s);
        try {
            return (Optional.ofNullable(ImageIO.read(is)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (Optional.empty());
    }
}
