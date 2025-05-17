package main;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;

public class GamePanel extends JPanel {
    // Screen Settings
    
    final int orignalTileSize = 20; // I Have done 20x20 tile because 30x30 was too big
    final int tileScale = 2;
    
    final int tileSize = orignalTileSize * tileScale; // This will result in 60x60 tiles
    final int maxScreenCol = 32;
    final int maxScreenRow = 18;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    
    public GamePanel () {
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);        
    
    }
    

}
