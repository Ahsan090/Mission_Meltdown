package obj;

import java.awt.Rectangle;

import entity.Entity;
import game.GamePanel;

public class OBJ_Ice extends Entity {

    public OBJ_Ice(GamePanel gp) {
        super(gp);
        name = "Ice";
        down1 = setup("/res/objects/ice block", gp.blockWidth, gp.blockHeight);

        solidArea = new Rectangle();
        solidArea.x = 5;
        solidArea.y = 12;
        solidArea.width = 50;
        solidArea.height = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        collision = true;
        isObject = true;
        objectWidth = gp.blockWidth;
        objectHeight = gp.blockHeight;
        objectOffSetX = 0;
        objectOffSetY = -12;
    }
    

    public void iceInteraction(String direction, GamePanel gp) {
        
        int playerWorldCol = gp.player.worldX/gp.tileSize;
        int playerWorldRow = gp.player.worldY/gp.tileSize;

        // int playerIcePositionX;
        // int playerIcePositionY;

        switch (direction) {
            case "up":
                gp.player.worldX = playerWorldCol * gp.tileSize;
                gp.player.worldY = playerWorldRow * gp.tileSize + gp.tileSize/2;
                // playerIcePositionX = playerWorldCol * gp.tileSize;
                // playerIcePositionY = playerWorldRow * gp.tileSize + gp.tileSize/2;
                // while(gp.player.worldX != playerIcePositionX && gp.player.worldY != playerIcePositionY) {
                //     if(gp.player.worldX > playerIcePositionX) {
                //         gp.player.direction = "left";
                //         gp.player.worldX -= gp.player.speed;
                //     } else if(gp.player.worldX < playerIcePositionX) {
                //         gp.player.direction = "right";
                //         gp.player.worldX += gp.player.speed;
                //     }
                //     if(gp.player.worldY < playerIcePositionY) {
                //         gp.player.direction = "down";
                //         gp.player.worldY += gp.player.speed;
                //     }
                //     if(gp.player.worldY > playerIcePositionY) {
                //         gp.player.direction = "up";
                //         gp.player.worldY -= gp.player.speed;
                //     }
                // }
                for(int i = 0; i < 10; i++) {
                    playerWorldRow--;
                    if(gp.obj[playerWorldCol][playerWorldRow + 1] != null) {
                        break;
                    }
                    gp.obj[playerWorldCol][playerWorldRow + 1] = new OBJ_Ice(gp);
                    gp.obj[playerWorldCol][playerWorldRow + 1].worldX = playerWorldCol * gp.tileSize;
                    gp.obj[playerWorldCol][playerWorldRow + 1].worldY = playerWorldRow * gp.tileSize + gp.tileSize;
                }
                break;
            case "down":
                gp.player.worldX = playerWorldCol * gp.tileSize;
                gp.player.worldY = playerWorldRow * gp.tileSize + gp.tileSize/2;
                for(int i = 0; i < 10; i++) {
                    playerWorldRow++;
                    if(gp.obj[playerWorldCol][playerWorldRow + 1] != null) {
                        break;
                    }
                    gp.obj[playerWorldCol][playerWorldRow + 1] = new OBJ_Ice(gp);
                    gp.obj[playerWorldCol][playerWorldRow + 1].worldX = playerWorldCol * gp.tileSize;
                    gp.obj[playerWorldCol][playerWorldRow + 1].worldY = playerWorldRow * gp.tileSize + gp.tileSize;
                }
                //gp.player.worldY -= 2;
                break;
            case "left":
                gp.player.worldX = playerWorldCol * gp.tileSize + 20;
                gp.player.worldY = playerWorldRow * gp.tileSize + gp.tileSize/2;
                for(int i = 0; i < 10; i++) {
                    playerWorldCol--;
                    if(gp.obj[playerWorldCol][playerWorldRow + 1] != null) {
                        break;
                    }
                    gp.obj[playerWorldCol][playerWorldRow + 1] = new OBJ_Ice(gp);
                    gp.obj[playerWorldCol][playerWorldRow + 1].worldX = playerWorldCol * gp.tileSize;
                    gp.obj[playerWorldCol][playerWorldRow + 1].worldY = playerWorldRow * gp.tileSize + gp.tileSize;
                }
                //gp.player.worldX += 2;
                break;
            case "right":
                gp.player.worldX = playerWorldCol * gp.tileSize + gp.tileSize/2;
                gp.player.worldY = playerWorldRow * gp.tileSize + gp.tileSize/2;
                for(int i = 0; i < 10; i++) {
                    playerWorldCol++;
                    if(gp.obj[playerWorldCol + 1][playerWorldRow + 1] != null) {
                        break;
                    }
                    gp.obj[playerWorldCol + 1][playerWorldRow + 1] = new OBJ_Ice(gp);
                    gp.obj[playerWorldCol + 1][playerWorldRow + 1].worldX = playerWorldCol * gp.tileSize + gp.tileSize;
                    gp.obj[playerWorldCol + 1][playerWorldRow + 1].worldY = playerWorldRow * gp.tileSize + gp.tileSize;
                }
                //gp.player.worldX -= 2;
                break;
        }
    }
}
