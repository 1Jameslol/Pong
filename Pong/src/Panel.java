import PongParts.Ball;
import PongParts.Paddle;
import gui.UI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Panel extends JPanel implements KeyListener {
    UI ui;
    int score1;
    int score2;
    boolean direction;
    int directionY;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    int ballVeloX;
    int ballVeloY;
    boolean started2;
    int increment;
    boolean up;
    boolean down;
    boolean left;
    boolean right;

    boolean started;

    boolean scaleXinc;
    boolean scaleXdec;
    boolean scaleYinc;
    boolean scaleYdec;

    int scaleX;
    int scaleY;
    int x;
    int y;

    int gameState;

    /*
        gameState 0 = ui
        gameState 1 = pong
    */

    public Panel() {
        score1=0;
        score2=0;
        directionY=0;
        direction=true;
        ballVeloX=-3;
        ballVeloY=0;
        started2=false;
        gameState = 0;
        increment=0;
        paddle1 = new Paddle(0, 402);
        paddle2 = new Paddle(787, 402);
        ball = new Ball(400, 435, 25, 25);
        initKeyListener();
        started=true;
        ui = new UI();
        initVars();
        setBackground(Color.black);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(gameState==0) {
        increment++;
        if(increment<=175&increment>=75) {
            ui.paintUI2(g);
            if(increment==175) 
            increment=0;
        } else if(increment<=75) {
            ui.paintUI(g);
        }
        //System.out.println(increment);
        } else if (gameState==1) {
            if(direction) {
                ball.Ballx+=ballVeloX;
                ball.Bally+=ballVeloY;
            } else {
                ball.Ballx-=ballVeloX;
                ball.Bally-=ballVeloY;
            }

            if(directionY==0) {
                ball.Bally+=0;
            } else if(directionY==1) {
                ball.Bally+=-3;
            } else if(directionY==2) {
                ball.Bally-=-3;
            }

            paddle1.drawPaddle(g);
            paddle2.drawPaddle(g);
            g.setColor(Color.white);
            //g.fillRect(x, y, scaleX, scaleY);
            ball.drawBall(g);
            //paddle1.drawPaddlePart1(g);
            //paddle1.drawPaddlePart2(g);
            //paddle1.drawPaddlePart3(g);
        }
        g.setColor(Color.white);
        g.setFont(new Font("Comic Sans", 1, 70));
        g.drawString("" +score1 +"-" + score2, 326, 131);
        //System.out.println(paddle1.x + " " + paddle1.y + " " + paddle1.scaleX + " " + paddle1.scaleY);
        g.dispose();
        
        
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(started2) {
        checkKeyPress(e);
        keyScaleCheckPress(e);
        }
        if(e.getKeyCode()==KeyEvent.VK_ENTER) {
            gameState=1;
            started2=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        checkKeyRel(e);
        keyScaleCheckRel(e);
    }

    public void checkKeyRel(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W) {
            up=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_A) {
            left=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_S) {
            down=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_D) {
            right=false;
        }
    }

    public void checkKeyPress(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W) {
            up=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_A) {
            left=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_S) {
            down=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_D) {
            right=true;
        }
    }

    public void keyScaleCheckPress(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP) {
            scaleYdec=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN) {
            scaleYinc=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            scaleXdec=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            scaleXinc=true;
        }
    }

    public void keyScaleCheckRel(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP) {
            scaleYdec=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN) {
            scaleYinc=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            scaleXdec=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            scaleXinc=false;
        }
    }



    public void initVars() {
        scaleX=100;
        scaleY=100;
        x=0;
        y=0;
        up=false;
        down=false;
        left=false;
        right=false;
        scaleXinc=false;
        scaleXdec=false;
        scaleYinc=false;
        scaleYdec=false;
    }

    public void initKeyListener() {
        setFocusable(true);
        addKeyListener(this);
    }
}
