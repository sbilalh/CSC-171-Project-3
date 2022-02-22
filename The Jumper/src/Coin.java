import java.awt.*;

public class Coin {
    int x, y, width, height;
    Rectangle hitBox;
    public Coin(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        hitBox = new Rectangle(x,y,width-2,height-2);
    }
    public void draw(Graphics2D gtd){
        gtd.setColor(Color.BLACK);
        gtd.drawOval(x,y,width,height);
        gtd.setColor(Color.WHITE);
        gtd.fillOval(x+1,y+1,width-2,height-2);;
    }
}
