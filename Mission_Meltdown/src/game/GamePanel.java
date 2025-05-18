package game;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable {
    // Screen Settings
    
    final int orignalTileSize = 30; // going 30x30
    final int tileScale = 2;
    
    final int tileSize = orignalTileSize * tileScale; // This will result in 60x60 tiles
    final int maxScreenCol = 32;
    final int maxScreenRow = 18;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    Thread gameThread;

    public GamePanel () {
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);        
        
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        while(gameThread != null) {
            
            // Updates any changes made
            update();

            // Display any changes made
            repaint();
        }
    }

    public void update(){

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
    }
}
