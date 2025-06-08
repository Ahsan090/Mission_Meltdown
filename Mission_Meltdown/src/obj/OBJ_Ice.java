package obj;

import java.awt.Rectangle;

import entity.Entity;
import game.GamePanel;

public class OBJ_Ice extends Entity {

    int iceWorldCol;
    int iceWorldRow;
    int tileIndex;
    String playerDirection;
    boolean iceBreak = false;

    public OBJ_Ice(GamePanel gp) {
        super(gp);
        name = "Ice";
        down1 = setup("/res/objects/ice block", gp.blockWidth, gp.blockHeight);

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 60;
        solidArea.height = 60;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        collision = true;
        isObject = true;
        objectWidth = gp.blockWidth;
        objectHeight = gp.blockHeight;
        objectOffSetX = 0;
        objectOffSetY = -12;

        isIce = true;
    }
    

    public void iceInteraction(String direction, int playerWorldCol, int playerWorldRow, int iceCounter, GamePanel gp) {

        if(iceCounter == 1) {
            playerDirection = direction;
            iceWorldCol = playerWorldCol;
            iceWorldRow = playerWorldRow;
        }
        if(iceBreak == false) {
            switch (playerDirection) {
                case "up":
                    iceWorldRow--;
                    tileIndex = gp.tileM.mapTileNum[iceWorldCol][iceWorldRow];
                    if(gp.tileM.tile[tileIndex].collision == true) {
                        gp.player.iceCounter = 10;
                        break;
                    }
                    if(gp.obj[iceWorldCol][iceWorldRow] != null) {

                        if(gp.obj[iceWorldCol][iceWorldRow].isIce == false) {
                            gp.player.iceCounter = 10;
                            break;
                        }

                        if(iceCounter == 1) {
                            iceBreak = true;
                            gp.obj[iceWorldCol][iceWorldRow] = null;
                            break;
                        } else if (iceBreak == false) {
                            gp.player.iceCounter = 10;
                            break;
                        }
                    }
                    
                    gp.obj[iceWorldCol][iceWorldRow] = new OBJ_Ice(gp);
                    gp.obj[iceWorldCol][iceWorldRow].worldX = iceWorldCol * gp.tileSize;
                    gp.obj[iceWorldCol][iceWorldRow].worldY = iceWorldRow * gp.tileSize;
                    break;
                case "down":
                    iceWorldRow++;
                    tileIndex = gp.tileM.mapTileNum[iceWorldCol][iceWorldRow];
                    if(gp.tileM.tile[tileIndex].collision == true) {
                        gp.player.iceCounter = 10;
                        break;
                    }
                    if(gp.obj[iceWorldCol][iceWorldRow] != null) {
                        
                        if(gp.obj[iceWorldCol][iceWorldRow].isIce == false) {
                            gp.player.iceCounter = 10;
                            break;
                        }

                        if(iceCounter == 1) {
                            iceBreak = true;
                            gp.obj[iceWorldCol][iceWorldRow] = null;
                            break;
                        } else if (iceBreak == false) {
                            gp.player.iceCounter = 10;
                            break;
                        }
                    }
                    
                    gp.obj[iceWorldCol][iceWorldRow] = new OBJ_Ice(gp);
                    gp.obj[iceWorldCol][iceWorldRow].worldX = iceWorldCol * gp.tileSize;
                    gp.obj[iceWorldCol][iceWorldRow].worldY = iceWorldRow * gp.tileSize;
                    break;
                case "left":
                    iceWorldCol--;
                    tileIndex = gp.tileM.mapTileNum[iceWorldCol][iceWorldRow];
                    if(gp.tileM.tile[tileIndex].collision == true) {
                        gp.player.iceCounter = 10;
                        break;
                    }
                    if(gp.obj[iceWorldCol][iceWorldRow] != null) {
                        
                        if(gp.obj[iceWorldCol][iceWorldRow].isIce == false) {
                            gp.player.iceCounter = 10;
                            break;
                        }

                        if(iceCounter == 1) {
                            iceBreak = true;
                            gp.obj[iceWorldCol][iceWorldRow] = null;
                            break;
                        } else if (iceBreak == false) {
                            gp.player.iceCounter = 10;
                            break;
                        }
                    }
                    
                    gp.obj[iceWorldCol][iceWorldRow] = new OBJ_Ice(gp);
                    gp.obj[iceWorldCol][iceWorldRow].worldX = iceWorldCol * gp.tileSize;
                    gp.obj[iceWorldCol][iceWorldRow].worldY = iceWorldRow * gp.tileSize;
                    break;
                case "right":
                    iceWorldCol++;
                    tileIndex = gp.tileM.mapTileNum[iceWorldCol][iceWorldRow];
                    if(gp.tileM.tile[tileIndex].collision == true) {
                        gp.player.iceCounter = 10;
                        break;
                    }
                    if(gp.obj[iceWorldCol][iceWorldRow] != null) {
                        
                        if(gp.obj[iceWorldCol][iceWorldRow].isIce == false) {
                            gp.player.iceCounter = 10;
                            break;
                        }

                        if(iceCounter == 1) {
                            iceBreak = true;
                            gp.obj[iceWorldCol][iceWorldRow] = null;
                            break;
                        } else if (iceBreak == false) {
                            gp.player.iceCounter = 10;
                            break;
                        }
                    }
                    
                    gp.obj[iceWorldCol][iceWorldRow] = new OBJ_Ice(gp);
                    gp.obj[iceWorldCol][iceWorldRow].worldX = iceWorldCol * gp.tileSize;
                    gp.obj[iceWorldCol][iceWorldRow].worldY = iceWorldRow * gp.tileSize;
                    break;
            }
        } else if(iceBreak == true) {
            switch (playerDirection) {
                case "up":
                    iceWorldRow--;
                    if(gp.obj[iceWorldCol][iceWorldRow] != null) {
                        
                        if(gp.obj[iceWorldCol][iceWorldRow].isIce == false) {
                            gp.player.iceCounter = 10;
                            break;
                        }

                        gp.obj[iceWorldCol][iceWorldRow] = null;
                    } else {
                        gp.player.iceCounter = 10;
                        iceBreak = false;
                        break;
                    }
                    break;
                case "down":
                    iceWorldRow++;
                    if(gp.obj[iceWorldCol][iceWorldRow] != null) {
                        
                        if(gp.obj[iceWorldCol][iceWorldRow].isIce == false) {
                            gp.player.iceCounter = 10;
                            break;
                        }

                        gp.obj[iceWorldCol][iceWorldRow] = null;
                    } else {
                        gp.player.iceCounter = 10;
                        iceBreak = false;
                        break;
                    }
                    break;
                case "left":
                    iceWorldCol--;
                    if(gp.obj[iceWorldCol][iceWorldRow] != null) {
                        
                        if(gp.obj[iceWorldCol][iceWorldRow].isIce == false) {
                            gp.player.iceCounter = 10;
                            break;
                        }

                        gp.obj[iceWorldCol][iceWorldRow] = null;
                    } else {
                        gp.player.iceCounter = 10;
                        iceBreak = false;
                        break;
                    }
                    break;
                case "right":
                    iceWorldCol++;
                    if(gp.obj[iceWorldCol][iceWorldRow] != null) {
                        
                        if(gp.obj[iceWorldCol][iceWorldRow].isIce == false) {
                            gp.player.iceCounter = 10;
                            break;
                        }

                        gp.obj[iceWorldCol][iceWorldRow] = null;
                    } else {
                        gp.player.iceCounter = 10;
                        iceBreak = false;
                        break;
                    }
                    break;
            }
        }
    }
}
