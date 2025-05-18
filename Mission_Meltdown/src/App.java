import javax.swing.JFrame;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Mission Meltdown");
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        // Set the JFrame to full-screen mode
        window.setUndecorated(true); // Remove window decorations (title bar, borders)
        gd.setFullScreenWindow(window); // Make the frame full-screen

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
