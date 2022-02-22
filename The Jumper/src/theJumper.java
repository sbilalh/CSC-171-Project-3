import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class theJumper {
    public static void main(String[] args) throws InterruptedException {
        MainFrame frame = new MainFrame();
        JFrame F = new JFrame();
        JProgressBar bar = new JProgressBar();
        JPanel f = new JPanel();
        JLabel L1 = new JLabel("Timer: ");
        int score = 0;
        JLabel lab = new JLabel();
        JPanel pan = new JPanel();

        frame.setSize(1000,775);

        F.setSize(1000,775);
        F.setVisible(false);

        JLabel scorePanel = new JLabel(("Score: "));
        scorePanel.setBounds(10,10,100,50);
        scorePanel.setText("Score: "+ score);
        f.add(scorePanel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));
        frame.setResizable(false);
        frame.setTitle("The Jumper");
        frame.setVisible(true);

        f.setBackground(Color.BLACK);

        frame.add(f,BorderLayout.NORTH);
        f.add(L1);
        f.add(bar);
        bar.setBackground(Color.BLACK);
        bar.setForeground(Color.RED);
        bar.setBounds(0,0,200, 50); // x, y coordinates & width, height of bar
        int counter = 100;
        while (counter > 0) {
            bar.setValue(counter);
            counter --; // decrement counter
            Thread.sleep(400);  // delay
            if (frame.gameFinish()){
                frame.dispose();
                score += 1;
                frame.reset();
                frame = new MainFrame();
                bar = new JProgressBar();
                f = new JPanel();
                L1 = new JLabel("Timer: ");
                frame.setSize(1000,775);
                scorePanel = new JLabel(("Score: "));
                scorePanel.setBounds(10,10,100,50);
                scorePanel.setText("Score: "+ score);
                f.add(scorePanel);
                screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));
                frame.setResizable(false);
                frame.setTitle("The Jumper");
                frame.setVisible(true);

                f.setBackground(Color.GRAY);

                frame.add(f,BorderLayout.NORTH);
                f.add(L1);
                f.add(bar);
                bar.setBackground(Color.BLACK);
                bar.setForeground(Color.RED);
                bar.setBounds(0,0,200, 50); // x, y coordinates & width, height of bar
                counter = 100;
            } else if (counter == 0){
                frame.dispose();
                pan.add(lab);
                pan.setBackground(Color.BLACK);
                lab.setText("GAME OVER");
                lab.setForeground(Color.WHITE);
                F.add(pan, BorderLayout.CENTER);
                F.setVisible(true);
                break;
            }

        }
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
}
