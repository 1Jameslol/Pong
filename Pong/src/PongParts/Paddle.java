package PongParts;
import java.awt.Color;
import java.awt.Graphics;

public class Paddle {

    //paddle1 coords x: 2 y: 402 scaleX: 15 scaleY 100
    //paddle2 coords x: 787 y: 402 scaleX: 15 scaleY 100

    public int x;
    public int y;
    public int scaleX;
    public int scaleY;
    public Paddle(int x, int y) {
        scaleX = 15;
        scaleY = 100;
        this.x=x;
        this.y=y;
    }

    public void drawPaddle(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, scaleX, scaleY);
    }

    public void drawPaddlePart1(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, 15, 100/3);
    }

    public void drawPaddlePart2(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y+100/3, 15, 100/3);
    }

    public void drawPaddlePart3(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y+200/3, 15, 100/3);
    }
}
