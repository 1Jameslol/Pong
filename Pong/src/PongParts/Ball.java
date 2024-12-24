package PongParts;

import java.awt.Graphics;

public class Ball {
    public int Ballx;
    public int Bally;
    public int BallscaleX;
    public int BallscaleY;
    public Ball(int x, int y, int scaleX, int scaleY) {
        this.Ballx=x;
        this.Bally=y;
        this.BallscaleX=scaleX;
        this.BallscaleY=scaleY;
    }

    public void drawBall(Graphics g) {
        g.fillRect(Ballx, Bally, BallscaleX, BallscaleY);
    }
}
