import java.awt.*;

public class Player {
    GamePanel panel;    // define variables
    int x, y, width, height;
    double xspeed;
    double yspeed;
    Rectangle hitBox;
    boolean keyLeft;
    boolean keyRight;
    boolean keyUp;
    boolean keyDown;
    boolean finish = false;

    public Player(int x, int y, GamePanel panel){
         this.panel = panel;
         this.x = x;
         this.y = y;
         width = 15;    // define width of player
         height = 20;   // define height of player
         hitBox = new Rectangle(x,y,width,height);  // set hit box of player
    }
    public void set(){
       // set velocity on player when key is pressed
        if(keyLeft && keyRight || !keyLeft && !keyRight){
            xspeed*=0.8;
        }else if(keyLeft){
            xspeed--;
       } else if(keyRight){
            xspeed++;
       }
       // prevent sliding
       if(xspeed> 0 && xspeed < 0.75){
           xspeed = 0;
       }
       if(xspeed< 0 && xspeed > -0.75){
           xspeed = 0;
       }
       // set speed limit
       if(xspeed > 2.5){
           xspeed = 2.5;
       }
       if(xspeed < -2){
           xspeed = -2;
       }
       // allow jumping only when touching a block
       if(keyUp){
           hitBox.y++;      // move hit box;
           for(Wall wall: panel.walls) {
               if(wall.hitBox.intersects(hitBox)) yspeed = -7;
           }
       }
       yspeed += .25; // gravity
       hitBox.x += xspeed; // move hit box

        // horizontal wall collision
        for(Wall wall: panel.walls){
            if(hitBox.intersects(wall.hitBox)){
                hitBox.x -= xspeed;
                while(!wall.hitBox.intersects(hitBox)) hitBox.x += Math.signum(xspeed);
                hitBox.x -= Math.signum(xspeed);
                xspeed = 0;
                x = hitBox.x;
            }
        }
        // vertical wall collision
        hitBox.y += yspeed;
        for(Wall wall: panel.walls){
            if(hitBox.intersects(wall.hitBox)){
                hitBox.y -= yspeed;
                while(!wall.hitBox.intersects(hitBox)) hitBox.y += Math.signum(yspeed);
                hitBox.y -= Math.signum(yspeed);
                yspeed = 0;
                y = hitBox.y;
            }
        }
        x += xspeed;    // increment x position by x speed
        y += yspeed;    // increment y position by y speed

        hitBox.x = x;   // move hit box to x
        hitBox.y = y;   // move hit box to y
        // horizontal coin collision
        for(Coin coin: panel.coins){
            if(hitBox.intersects(coin.hitBox)){
                hitBox.x -= xspeed;
                //while(!coin.hitBox.intersects(hitBox)) hitBox.x += Math.signum(xspeed);
                //hitBox.x -= Math.signum(xspeed);
                xspeed = 0;
                x = hitBox.x;
                finish = true;
            }
        }
        // vertical wall collision
        for(Coin coin: panel.coins){
            if(hitBox.intersects(coin.hitBox)){
                hitBox.y -= yspeed;
                //(!coin.hitBox.intersects(hitBox)) hitBox.y += Math.signum(yspeed);
                //hitBox.y -= Math.signum(yspeed);
                yspeed = 0;
                y = hitBox.y;
                finish = true;
            }
        }

    }
    public void draw(Graphics2D gtd){
        gtd.setColor(Color.WHITE);
        gtd.fillRect(x,y,width,height);
    }
    // objective complete
    public boolean getFinish(){
        return finish;
    }
}

