
public class GameLoop implements Runnable {
    boolean running;
    Panel panel = new Panel();
    Collisions collision;
    public GameLoop(Panel panel) {
        this.panel=panel;
        collision = new Collisions(panel);
        run();
        loop();
    }

    @Override
    public void run() {
        running=true;
    }

    public void stop() {
        running=false;
    }

    public void loop() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 120.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
            while(running){
	            long now = System.nanoTime();
	            delta += (now - lastTime) / ns;
	            lastTime = now;
	        while(delta >= 1){
		        tick();
		        updates++;
		        delta--;
	}
	    render();
	    frames++;
			
	if(System.currentTimeMillis() - timer > 1000){
		timer += 1000;
		//System.out.println("FPS: " + frames + " TICKS: " + updates);
		frames = 0;
		updates = 0;
	}
}
    }

    public void tick() {
        keyCheck();
        panel.repaint();
        //System.out.println("x: " + panel.x + " " + "y: " + panel.y + " " + "scalex: " + panel.scaleX + " scaley: " + panel.scaleY);
    }

    public void render() {
        update();
    }

    public void keyCheck() {
        int velo = 5;
        if(panel.up) {
            panel.paddle1.y-=velo;
            panel.y-=velo;
        } else if(panel.down) {
            panel.paddle1.y+=velo;
            panel.y+=velo;
        } else if(panel.right) {
            panel.x+=velo;
        } else if(panel.left) {
            panel.x-=velo;
        }
        keyCheckDiagonal(velo);
        keyCheckScale();
    }

    public void keyCheckDiagonal(int velo) {
        if(panel.up&&panel.right) {
            panel.x+=velo/2;
            panel.y-=velo/2;
        }

        if(panel.up&&panel.left) {
            panel.x-=velo/2;
            panel.y-=velo/2;
        }
        
        if(panel.down&&panel.right) {
            panel.x+=velo/2;
            panel.y+=velo/2;
        }

        if(panel.down&&panel.left) {
            panel.x-=velo/2;
            panel.y+=velo/2;
        }
    }

    public void keyCheckScale() {
        if(panel.scaleXdec) {
            panel.scaleX-=5;
        }
        if(panel.scaleXinc) {
            panel.scaleX+=5;
        }
        if(panel.scaleYdec) {
            panel.paddle2.y-=5;
            panel.scaleY-=5;
        }
        if(panel.scaleYinc) {
            panel.paddle2.y+=5;
            panel.scaleY+=5;
        }


    }

    public void update() {
        collision.checkPaddleY();
        if(panel.ball.Ballx<0) {
            panel.ball.Ballx=400;
            panel.ball.Bally=435;
            panel.paddle1.x=0;
            panel.paddle1.y=402;
            panel.paddle2.x=787;
            panel.paddle2.y=402;
            panel.directionY=0;
            panel.score2++;

        } else if(panel.ball.Ballx>787) {
            panel.ball.Ballx=400;
            panel.ball.Bally=435;
            panel.paddle1.x=0;
            panel.paddle1.y=402;
            panel.paddle2.x=787;
            panel.paddle2.y=402;
            panel.directionY=0;
            panel.score1++;
        }
    }

}