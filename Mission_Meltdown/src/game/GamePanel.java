package game;
import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import tile.TileManager;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable {
    // Screen Settings
    
    final int orignalTileSize = 30; // going 30x30
    final int upScale = 2; // all the images will be scaled to 2x the original image size

    final int originalBlockWidth = 30;
    final int originalBlockHeight = 36;

    final int originalCharacterWidth = 30;
    final int originalCharacterHeight = 44;

    public final int characterWidth = originalCharacterWidth * upScale;  // 60px
    public final int characterHeight = originalCharacterHeight * upScale; // 88px
    public final int blockWidth = originalBlockWidth * upScale; // 60 px
    public final int blockHeight = originalBlockHeight * upScale; // 72 px
    public final int tileSize = orignalTileSize * upScale; // This will result in 60x60 tiles

    public final int maxScreenCol = 19;
    public final int maxScreenRow = 11;
    public final int screenWidth = tileSize * maxScreenCol; // 1920
    public final int screenHeight = tileSize * maxScreenRow; // 1080

    public final int maxWorldCol = 45;
    public final int maxWorldRow = 29;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    // The game's frames per second
    int FPS = 60;

    Thread gameThread;
    public KeyHandler keyH = new KeyHandler(this);

    public Player player = new Player(this, keyH);
    public TileManager tileM = new TileManager(this);
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetsManager assetsM = new AssetsManager(this);
    public Entity obj[][] = new Entity[92][90];
    public Entity npc[] = new Entity[8];
    public Entity npc_e[] = new Entity[8];
    public EventHandler eHandler = new EventHandler(this);
    public UI ui = new UI(this);

    public ArrayList<Entity> entityList = new ArrayList<>();
    public ArrayList<Entity> projectileList = new ArrayList<>();

    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;

    public GamePanel () { //constructor
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);        
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame() {
        assetsM.setObject();
        assetsM.setNPC();
        gameState = titleState;
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
        if(gameState == playState) {
            player.update();

            for(int i = 0; i < npc.length; i++) {
                if(npc[i] != null) {
                    npc[i].update();
                }

                if(npc_e[i] != null) {
                    npc_e[i].update();
                }
            }
            
        } else if(gameState == pauseState){
            //pause the game
        }
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        if(gameState == titleState) {
            ui.draw(g2);
        } else {
            tileM.draw(g2);

            entityList.add(player);

            for(int i = 0; i < npc.length; i++) {
                if(npc[i] != null) {
                    entityList.add(npc[i]);
                }
                if(npc_e[i] != null) {
                    entityList.add(npc_e[i]);
                }
            }

            for(int i = 0; i < obj.length; i++) {
                for(int j = 0; j < obj[i].length; j++) {
                    if(obj[i][j] != null) {
                        entityList.add(obj[i][j]);
                    }
                }
            }

            // for(int i = 0; i < iceBlocks.size(); i++) {
            //     if(obj[i] != null) {
            //         entityList.add(iceBlocks.get(i));
            //     }
            // }

            // now sorting the entities by their y positioning
            Collections.sort(entityList, new Comparator<Entity>() {

                @Override
                public int compare(Entity e1, Entity e2) {
                    
                    int result = Integer.compare(e1.worldY, e2.worldY);
                    return result;
                }
                
            });

            // and now we can draw the entities in order
            for(int i = 0; i < entityList.size(); i++) {
                entityList.get(i).draw(g2);
            }
            entityList.clear(); // clearing the list for the next loop

            ui.draw(g2);
        }
        g2.dispose();
    }
}
