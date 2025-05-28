package game;
import javax.swing.JFrame;
//import java.awt.GraphicsEnvironment;
//import java.awt.GraphicsDevice;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Mission Meltdown");
        
        // key press are not registered in fullscreen soo commenting it out for now, will check it later
        //GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //GraphicsDevice gd = ge.getDefaultScreenDevice();

        // Set the JFrame to full-screen mode
        //window.setUndecorated(true); // Remove window decorations (title bar, borders)
        //gd.setFullScreenWindow(window); // Make the frame full-screen

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}
