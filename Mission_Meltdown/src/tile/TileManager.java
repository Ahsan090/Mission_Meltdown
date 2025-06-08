package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
// import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import game.GamePanel;
import game.ImageScaling;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[20];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/res/maps/map01.txt");
    }

    public void getTileImage() {
        
        // Place Holders
        setupTile(0, "black01", false);
        setupTile(1, "black01", false);
        setupTile(2, "black01", false);
        setupTile(3, "black01", false);
        setupTile(4, "black01", false);
        setupTile(5, "black01", false);
        setupTile(6, "black01", false);
        setupTile(7, "black01", false);
        setupTile(8, "black01", false);
        setupTile(9, "snow01", true);

        // Actual Tiles
        setupTile(10, "grass01", false);
        setupTile(11, "grass02", false);
        setupTile(12, "snow01", false);
        setupTile(13, "snow02", false);
        setupTile(14, "snow03", false);
        setupTile(15, "water01", true);
        setupTile(16, "water02", true);
    }

    public void setupTile(int index, String imagePath, boolean collision) {
        ImageScaling imageScale = new ImageScaling();

        try {          
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/" + imagePath + ".png"));
            tile[index].image = imageScale.scaledImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void loadMap(String filePath) { // The is some problem with this method (not letting me run the program), will check later
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int row = 0;
            int col = 0;

            while(row < gp.maxWorldRow && col < gp.maxWorldCol) {
                String line = br.readLine();

                while(col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }

                if(col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }

            br.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        int worldRow = 0;
        int worldCol = 0;

        int tileNum;

        int worldX, worldY;
        int screenX, screenY;

        while(worldRow < gp.maxWorldRow &&  worldCol < gp.maxWorldCol) {
            
            tileNum = mapTileNum[worldCol][worldRow];

            worldX = worldCol * gp.tileSize;
            worldY = worldRow * gp.tileSize;
            screenX = worldX - gp.player.worldX + gp.player.screenX;
            screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
               worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && 
               worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
               worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            
            worldCol++;

            if(worldCol == gp.maxWorldCol) {
                worldCol = 0;           
                worldRow++;
            }
        }
    }
}
