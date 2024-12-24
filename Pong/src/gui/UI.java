package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class UI {
    BufferedImage title;
    BufferedImage start;
    BufferedImage start2;
    BufferedImage pressEnter;
    public UI() {
        initImages();
    }

    public void paintUI(Graphics g) {
        g.drawImage(title, 250, 0, 300, 300, null);
        g.drawImage(start, 120, 245, 540, 330, null);
        g.drawImage(pressEnter, 70, 375, 640, 640, null);
        g.dispose();
    }

    public void paintUI2(Graphics g) {
        g.drawImage(title, 250, 0, 300, 300, null);
        g.drawImage(start2, 120, 245, 540, 330, null);
        g.drawImage(pressEnter, 70, 375, 640, 640, null);
        g.dispose();
    }
    public void initImages() {
        try {
            title=ImageIO.read(getClass().getResourceAsStream("title.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            start=ImageIO.read(getClass().getResourceAsStream("buttons.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            start2=ImageIO.read(getClass().getResourceAsStream("buttons.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            pressEnter=ImageIO.read(getClass().getResourceAsStream("pressEnter.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        start = start.getSubimage(0, 0, 36, 22);
        start2 = start2.getSubimage(0, 36, 36, 22);
    }

    public BufferedImage cropImage(BufferedImage image) {
        return null;
    }
}
