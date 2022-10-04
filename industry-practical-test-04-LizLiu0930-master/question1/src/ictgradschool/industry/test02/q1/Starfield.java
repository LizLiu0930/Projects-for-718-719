package ictgradschool.industry.test02.q1;

import java.awt.*;
import java.util.List;

/**
 * Created by Andrew Meads on 9/01/2018.
 */
public class Starfield {

    private int x;
    private int y;
    private int size;
    private int speed;

    private List<Star> stars;

    public Starfield(int width, int height) {

        // TODO Step 2a.
        x = (int)(Math.random() * width);
        y = (int)(Math.random() * height);

        size = (int)(Math.random() * 4 + 2);
        speed = (int)(Math.random() * 6 + 5);

    }

    public void move(int windowWidth, int windowHeight) {

        // TODO Step 2b.

        for (Star star: stars) {
            star.move(windowWidth, windowHeight);
        }
    }

    public void paint(Graphics g) {

        // TODO Step 2c.

        for (Star star: stars) {
            star.paint(g);
        }
    }

}
