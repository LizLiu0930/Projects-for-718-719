package ictgradschool.industry.test02.q1;

import java.awt.*;

/**
 * Created by Andrew Meads on 9/01/2018.
 */
public class Star {

    private int x, y, size, speed;

    public Star(int x, int y, int size, int speed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public int getSpeed() {
        return speed;
    }

    public void move(int windowWidth, int windowHeight) {
        // TODO Step 1a.
        y += speed;

        if (y > windowHeight){
            y = 0;
        }

    }


    public void paint(Graphics g) {
        // TODO Step 1b.
        g.setColor(Color.WHITE);
        g.fillOval(x, y, size, size);
        g.setColor(Color.white);
        g.drawOval(x, y, size, size);
    }
}
