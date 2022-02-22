import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    GamePanel panel = new GamePanel();

    public MainFrame() {
        panel.setLocation(0, 0);
        panel.setSize(this.getSize());
        panel.setBackground(Color.black);
        panel.setVisible(true);
        this.add(panel, BorderLayout.CENTER);
        addKeyListener(new KeyChecker(panel));
    }
    public boolean gameFinish(){
        return panel.playerGetFinish();
    }
    public void reset(){
        this.remove(panel);
        ;
        panel = new GamePanel();
        this.add(panel);
        SwingUtilities.updateComponentTreeUI(this);
    }
}
