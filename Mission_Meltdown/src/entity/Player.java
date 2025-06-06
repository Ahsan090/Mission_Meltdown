package entity;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.GamePanel;
import game.KeyHandler;
import obj.OBJ_Ice;

public class Player extends Entity {
    KeyHandler keyH;
    OBJ_Ice ice;

    int playerWorldCol;
    int playerWorldRow;

    boolean iceInteract = false;

    public final int screenX, screenY;
    int standCounter = 0;
    boolean moving = false;
    int pixelCounter = 0;
    // boolean lockMove = false;
    // int moveLockCounter = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.keyH = keyH;

        screenX = (((gp.maxScreenCol/2)) * gp.tileSize);
        screenY = (((gp.maxScreenRow/2)) * gp.tileSize);

        solidArea = new Rectangle(2, 0, 56, 58);
        ice = new OBJ_Ice(gp);

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX = gp.tileSize * 20;
        worldY = gp.tileSize * 74;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() { // loaded all the sprites (these files are currently for testing purpose only, will change)
        
        up1 = setupPlayer("/res/player/player_walkup_1-removebg-preview");
        up2 = setupPlayer("/res/player/player_walkup_2-removebg-preview");
        up3 = setupPlayer("/res/player/player_walkup_3-removebg-preview");
        up4 = setupPlayer("/res/player/player_walkup_4-removebg-preview");
        up5 = up4;
        up6 = up1;

        down1 = setupPlayer("/res/player/player_down_1");
        down2 = setupPlayer("/res/player/player_down_2");
        down3 = setupPlayer("/res/player/player_down_3");
        down4 = down2;
        down5 = down3;
        down6 = down1;

        left1 = setupPlayer("/res/player/player_walkleft_1-removebg-preview");
        left2 = setupPlayer("/res/player/player_walkleft_2-removebg-preview");
        left3 = setupPlayer("/res/player/player_walkleft_3-removebg-preview");
        left4 = setupPlayer("/res/player/player_walkleft_4-removebg-preview");
        left5 = left4;
        left6 = left1;

        right1 = setupPlayer("/res/player/player_right110");
        right2 = setupPlayer("/res/player/player_right111");
        right3 = setupPlayer("/res/player/player_right112");
        right4 = setupPlayer("/res/player/player_right113");
        right5 = setupPlayer("/res/player/player_right114");
        right6 = setupPlayer("/res/player/player_right115");
    }

    public void update() {
        
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            if(moving == false) {
                if(keyH.upPressed == true) {
                    direction = "up";               
                } else if (keyH.downPressed == true) {
                    direction = "down";              
                } else if (keyH.leftPressed == true) {
                    direction = "left";                
                } else if (keyH.rightPressed == true) {
                    direction = "right";            
                }

                moving = true;
            }
            // Check Tile Collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // Check Object Collision
            int objIndex = gp.cChecker.checkObject(this, true);
            objectInteraction(objIndex);

            // Check NPC Collision
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            npcInteraction(npcIndex);

            // Check Event
            gp.eHandler.checkEvent();
        } else if(moving == false) {
            standCounter++;
            if(standCounter == 20) {
                spriteNum = 1;
                standCounter = 0;
            }
        }

        if(moving == true) {
            // Check Tile Collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // Check Object Collision
            int objIndex = gp.cChecker.checkObject(this, true);
            objectInteraction(objIndex);

            // Check NPC Collision
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            npcInteraction(npcIndex);

            // Check Event
            gp.eHandler.checkEvent();
            
            if(collisionOn == false) {
                switch(direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            spriteCounter++;
            if(spriteCounter > 7) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                } else if(spriteNum == 2) {
                    spriteNum = 3;
                } else if(spriteNum == 3) {
                    spriteNum = 4;
                } else if(spriteNum == 4) {
                    spriteNum = 5;
                } else if(spriteNum == 5) {
                    spriteNum = 6;
                } else if(spriteNum == 6) {
                    spriteNum = 1;
                }

                spriteCounter = 0;
            }

            pixelCounter += speed;
            if(pixelCounter == 60) {
                moving = false;
                pixelCounter = 0;
            }
            
        }

        // if(lockMove == true) {
        //     moveLockCounter++;
        //     int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
        //     npcInteraction(npcIndex);
        //     if(moveLockCounter == 10) {
        //         lockMove = false;
        //         moveLockCounter = 0;
        //     }
        // }
        // double playerCol = worldX/60.0;
        // double playerRow = worldY/60.0;
        // System.out.println("Player Col: " + playerCol + " Player Row: " + playerRow);
        if(gp.keyH.spacePressed == true &&  moving == false) {
            playerWorldCol = gp.player.worldX/gp.tileSize;
            playerWorldRow = gp.player.worldY/gp.tileSize;
            ice.iceInteraction(direction, playerWorldCol, playerWorldRow, gp);
            gp.keyH.spacePressed = false;
        }
        // else if(keyH.spacePressed == true) {
        //     switch(direction) {
        //             case "up":
        //                 worldY -= speed;
        //                 break;
        //             case "down":
        //                 worldY += speed;
        //                 break;
        //             case "left":
        //                 worldX -= speed;
        //                 break;
        //             case "right":
        //                 worldX += speed;
        //                 break;
        //         }
        // }
    }

    public void objectInteraction(int i) {
        if(i != 999) {
            // something
        } else {
            // jja
        }
    }

    public void npcInteraction(int i) {
        if(i != 999) {
            if(gp.keyH.ePressed == true) {
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
        }
        gp.keyH.ePressed = false;
    }

    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if(spriteNum == 1) {
                    image = up1;
                } else if(spriteNum == 2) {
                    image = up2;
                } else if(spriteNum == 3) {
                    image = up3;
                } else if(spriteNum == 4) {
                    image = up4;
                } else if(spriteNum == 5) {
                    image = up5;
                } else if(spriteNum == 6) {
                    image = up6;
                }
                break;
            case "down":
                if(spriteNum == 1) {
                    image = down1;
                } else if(spriteNum == 2) {
                    image = down2;
                } else if(spriteNum == 3) {
                    image = down3;
                } else if(spriteNum == 4) {
                    image = down4;
                } else if(spriteNum == 5) {
                    image = down5;
                } else if(spriteNum == 6) {
                    image = down6;
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    image = left1;
                } else if(spriteNum == 2) {
                    image = left2;
                } else if(spriteNum == 3) {
                    image = left3;
                } else if(spriteNum == 4) {
                    image = left4;
                } else if(spriteNum == 5) {
                    image = left5;
                } else if(spriteNum == 6) {
                    image = left6;
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    image = right1;
                } else if(spriteNum == 2) {
                    image = right2;
                } else if(spriteNum == 3) {
                    image = right3;
                } else if(spriteNum == 4) {
                    image = right4;
                } else if(spriteNum == 5) {
                    image = right5;
                } else if(spriteNum == 6) {
                    image = right6;
                }
                break;
        }

        g2.drawImage(image, screenX, screenY - 28, gp.characterWidth, gp.characterHeight, null);
        g2.setColor(Color.red);
        g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
    }
}
