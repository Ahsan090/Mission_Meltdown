package game;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable {
    // Screen Settings
    
    final int orignalTileSize = 30; // going 30x30
    final int upScale = 2; // all the images will be scaled to 2x the original image size

    final int originalCharacterWidth = 30;
    final int originalCharacterHeight = 44;

    final int CharacterWidth = originalCharacterWidth * upScale;  // 60px
    final int CharacterHeight = originalCharacterHeight * upScale; // 88px
    final int tileSize = orignalTileSize * upScale; // This will result in 60x60 tiles
    final int maxScreenCol = 32;
    final int maxScreenRow = 18;
    final int screenWidth = tileSize * maxScreenCol; // 1920
    final int screenHeight = tileSize * maxScreenRow; // 1080

    // The game's frames per second
    int FPS = 60;

    Thread gameThread;
    KeyHandler keyH = new KeyHandler();

    // player default position & speed (for testing purpose only, will change later)
    int playerX = 200;
    int playerY = 200;
    int playerSpeed = 4;

    public GamePanel () { //constructor
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);        
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {

        double drawInterval = 1000000000/FPS; // Calculating FPS in nano seconds
        double delta = 0;
        long previousTime = System.nanoTime();
        long currentTime;

        // Variables for fps tracking
        // long timer = 0;
        // int drawCount = 0;

        while(gameThread != null) {
            
            currentTime = System.nanoTime();

            delta += (currentTime - previousTime) / drawInterval; // results in how many frames worth of time has passed since the last update
            // timer += currentTime - previousTime; // adds up till it reaches the 1 second mark (used for fps tracking)
            previousTime = currentTime;
            
            if(delta >= 1) { // When delta reaches 1, it means that 1 frame worth of time has passed (time to update)           
                update(); // Updates any changes made      
                repaint(); // Display any changes made
                delta--; // Once the frame is updated, the frame is subtracted from delta (in simpler words it resets)
                // drawCount++; // adds a +1 each time the frame is updated (Used for fps tracking) 
            }

            // prints the number of frames updated each second
            // if(timer >= 1000000000) {
            //     System.out.println("FPS: " + drawCount);
            //     timer = 0;
            //     drawCount = 0;
            // }
        }
    }

    public void update(){

        if(keyH.upPressed == true) {
            playerY -= playerSpeed;
        } else if (keyH.downPressed == true) {
            playerY += playerSpeed;
        } else if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
        } else if (keyH.rightPressed == true) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // object created to check player movement in game
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }
}
