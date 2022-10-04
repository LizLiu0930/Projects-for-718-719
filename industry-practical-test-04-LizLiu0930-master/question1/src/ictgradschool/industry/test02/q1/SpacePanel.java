package ictgradschool.industry.test02.q1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Andrew Meads on 9/01/2018.
 *
 * TODO Steps 4 and 5 (implement interfaces)
 */
public class SpacePanel extends JPanel implements KeyListener, ActionListener {

    public static final int PREFERRED_WIDTH = 500;
    public static final int PREFERRED_HEIGHT = 500;

    private Starfield stars;

    private Spaceship ship;

    private Direction moveDirection = Direction.None;

    private Timer timer;

    public SpacePanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public SpacePanel() {
        setPreferredSize(new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT));

        this.stars = new Starfield(PREFERRED_WIDTH, PREFERRED_HEIGHT);

        this.ship = new Spaceship(PREFERRED_WIDTH / 2, PREFERRED_HEIGHT / 2, 10);

        // TODO Step 4b.

        this.timer = new Timer(20, this);

        addKeyListener(this);

    }

    // TODO Step 4c (modify the two methods below).

    public void start() {
        timer.start();
        stars.move(getWidth(), getHeight());
        ship.move(moveDirection, getWidth(), getHeight());
        requestFocusInWindow();
    }

    public void stop() {
        timer.stop();
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            moveDirection =  Direction.Up;
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                moveDirection =  Direction.Right;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moveDirection =  Direction.Down;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveDirection =  Direction.Left;
        }
        else {
            moveDirection =  Direction.None;
        }
        repaint();
    }

            @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());

        String path = "spaceship.png";
        URL url = getClass().getResource(path);
        Image image = null;
        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(moveDirection == Direction.Up) {
            g.drawImage(image,getWidth()/2, getHeight()/2, this);
        }
        else if (moveDirection == Direction.Down){
            g.drawImage(image,getWidth()/2, getHeight()/2, this);
        }
        else if (moveDirection == Direction.Right){
            g.drawImage(image,getWidth()/2, getHeight()/2, this);
        }
        else if (moveDirection == Direction.Left){
            g.drawImage(image,getWidth()/2, getHeight()/2, this);
        }


                // TODO Step 3.
//        for (Star star: stars) {
//            star.paint(g);
//        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}