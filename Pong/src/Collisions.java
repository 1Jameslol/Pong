import java.awt.Rectangle;
public class Collisions {
    Rectangle paddle1;
    Rectangle paddle2;
    Rectangle top;
    Rectangle bottom;
    Rectangle ball;

    Rectangle paddle1piece1;
    Rectangle paddle1piece2;
    Rectangle paddle1piece3;
    
    Rectangle paddle2piece1;
    Rectangle paddle2piece2;
    Rectangle paddle2piece3;

    Panel panel;
    public Collisions(Panel panel) {
        this.panel=panel;
        top = new Rectangle(0, -99, 805, 100);
        bottom = new Rectangle(0, 770, 810, 100);
    }

    public void checkPaddleY() {
        paddle1 = new Rectangle(panel.paddle1.x, panel.paddle1.y, panel.paddle1.scaleX, panel.paddle1.scaleY);
        paddle2 = new Rectangle(panel.paddle2.x, panel.paddle2.y, panel.paddle2.scaleX, panel.paddle2.scaleY);
        ball = new Rectangle(panel.ball.Ballx, panel.ball.Bally, panel.ball.BallscaleX, panel.ball.BallscaleY);

        paddle1piece1 = new Rectangle(panel.paddle1.x, panel.paddle1.y, 15, 100/3);
        paddle1piece2 = new Rectangle(panel.paddle1.x, panel.paddle1.y+100/3, 15, 100/3);
        paddle1piece3 = new Rectangle(panel.paddle1.x, panel.paddle1.y+200/3, 15, 100/3);

        paddle2piece1 = new Rectangle(panel.paddle2.x, panel.paddle2.y, 15, 100/3);
        paddle2piece2 = new Rectangle(panel.paddle2.x, panel.paddle2.y+100/3, 15, 100/3);
        paddle2piece3 = new Rectangle(panel.paddle2.x, panel.paddle2.y+200/3, 15, 100/3);

        if(ball.intersects(paddle1piece1)) {
            panel.directionY=1;
        } else if(ball.intersects(paddle1piece2)) {
            //panel.directionY=0;
        } else if(ball.intersects(paddle1piece3)) {
            panel.directionY=2;
        }

        if(ball.intersects(paddle2piece1)) {
            panel.directionY=1;
        } else if(ball.intersects(paddle2piece2)) {
            //panel.directionY=0;
        } else if(ball.intersects(paddle2piece3)) {
            panel.directionY=2;
        }

        if(paddle1.intersects(top)) {
            System.out.println("test");
            panel.up=false;
        } else if(paddle1.intersects(bottom)) {
            panel.down=false;
        }

        if(paddle2.intersects(top)) {
            System.out.println("test");
            panel.scaleYdec=false;
        } else if(paddle2.intersects(bottom)) {
            panel.scaleYinc=false;
        }

        if(ball.intersects(paddle1)) {
            panel.direction=false;
        } else if(ball.intersects(paddle2)) {
            panel.direction=true;
        }

        if(ball.intersects(bottom)) {
            panel.directionY=1;
        } else if(ball.intersects(top)) {
            panel.directionY=2;
        }
    }

}
