import java.awt.Dimension;
import javax.swing.JFrame;

public class Frame extends JFrame {
    public Frame() {
        Panel panel = new Panel();
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setPreferredSize(new Dimension(800, 800));
        pack();
        setLocationRelativeTo(null);
        setTitle("pong game");
        GameLoop gameLoop = new GameLoop(panel);
    }
}
