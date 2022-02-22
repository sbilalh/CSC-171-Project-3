import java.awt.*;

public class Wall {
    int x, y, width, height;
    Rectangle hitBox;
    Color color;
    public Wall(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        hitBox = new Rectangle(x,y,width,height);
    }
    public void draw(Graphics2D gtd){
        Color tessiesColor = new Color(130,207,89);
        Color soDemanding = new Color(51,76,245);
        gtd.setColor(soDemanding);
        gtd.drawRect(x,y,width,height);
        gtd.setColor(tessiesColor);
        gtd.fillRect(x+1,y+1,width-2,height-2);
    }
}
