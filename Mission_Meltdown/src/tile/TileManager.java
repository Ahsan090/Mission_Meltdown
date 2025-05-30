package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
// import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import game.GamePanel;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldRow][gp.maxWorldCol];
        getTileImage();
        loadMap("/res/maps/map01.txt");
    }

    public void getTileImage() {
        try {          
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Ice block.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/wall.png"));
            tile[2].collision = true;

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

                    mapTileNum[row][col] = num;
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
            
            tileNum = mapTileNum[worldRow][worldCol];

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
