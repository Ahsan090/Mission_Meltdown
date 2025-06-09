package entity;

//import java.awt.Color;
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

    BufferedImage playerImage;

    int playerWorldCol;
    int playerWorldRow;
    public int iceCounter = 0;
    String playerDirection;
    public boolean iceInteract = false;
    public boolean hasKey = false;

    public final int screenX, screenY;
    int standCounter = 0;
    boolean moving = false;
    int pixelCounter = 0;
    public boolean turn = false;
    public int turnCounter = 0;
    public int dialogueCount = -1;
    public int npcNum = 7;
    public boolean continueDialogue = false;
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
        worldX = gp.tileSize * 9;
        worldY = gp.tileSize * 6;
        speed = 4;
        direction = "right";
    }

    public void getPlayerImage() { // loaded all the sprites (these files are currently for testing purpose only, will change)
        
        up1 = setupPlayer("/res/player/shaikh_up_0");
        up2 = setupPlayer("/res/player/shaikh_up_1");
        up3 = setupPlayer("/res/player/shaikh_up_2");
        up4 = setupPlayer("/res/player/shaikh_up_3");

        down1 = setupPlayer("/res/player/shaikh_down_0");
        down2 = setupPlayer("/res/player/shaikh_down_1");
        down3 = setupPlayer("/res/player/shaikh_down_2");
        down4 = setupPlayer("/res/player/shaikh_down_3");

        left1 = setupPlayer("/res/player/shaikh_left_0");
        left2 = setupPlayer("/res/player/shaikh_left_1");
        left3 = setupPlayer("/res/player/shaikh_left_2");
        left4 = setupPlayer("/res/player/shaikh_left_3");
        left5 = setupPlayer("/res/player/shaikh_left_4");
        left6 = setupPlayer("/res/player/shaikh_left_5");

        right1 = setupPlayer("/res/player/shaikh_right_0");
        right2 = setupPlayer("/res/player/shaikh_right_1");
        right3 = setupPlayer("/res/player/shaikh_right_2");
        right4 = setupPlayer("/res/player/shaikh_right_3");
        right5 = setupPlayer("/res/player/shaikh_right_4");
        right6 = setupPlayer("/res/player/shaikh_right_5");

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
            int objIndex[] = gp.cChecker.checkObject(this, true);
            objectInteraction(objIndex);

            // Check NPC Collision
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            npcInteraction(npcIndex);

            // Check Event
            gp.eHandler.checkEvent();
        } else if(moving == false) {
            turn = true;
            turnCounter = 0;
            standCounter++;
            if(standCounter == 20) {
                spriteNum = 1;
                standCounter = 0;
            }
        }

        if(moving == true && turn == false) {
            // Check Tile Collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // Check Object Collision
            int[] objIndex = gp.cChecker.checkObject(this, true);
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
                    if(direction == "up" || direction == "down") {
                        spriteNum = 1;
                    } else{
                        spriteNum = 5;
                    }
                } else if(spriteNum == 5) {
                    if(direction == "up" || direction == "down") {
                        spriteNum = 1;
                    } else{
                        spriteNum = 6;
                    }
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

        if(turn == true && moving == true) {
            turnCounter++;
            moving = false;
            if(turnCounter == 7) {
                turn = false;
                turnCounter = 0;
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
            iceInteract = true;
            gp.keyH.spacePressed = false;
        }

        if(iceInteract == true) {
            iceMakeOrBreak();
        }
    }

    public void objectInteraction(int objIndex[]) {
        if(objIndex[0] != 999) {
            if(gp.obj[objIndex[0]][objIndex[1]].name.equals("Key")) {
                gp.obj[objIndex[0]][objIndex[1]] = null;
                hasKey = true;
                gp.ui.showMessage("You got the key");
            } else if(gp.obj[objIndex[0]][objIndex[1]].name.equals("Door")) {
                if(hasKey == true){
                    gp.obj[12][18] = null;
                    gp.obj[13][18] = null;
                    gp.ui.showMessage("You opened the door");
                } else {
                    gp.ui.showMessage("You need a key");
                }
            }
        }
    }

    public void npcInteraction(int i) {
        if(i != 999 || npcNum != 7) {
            if(gp.keyH.ePressed == true || gp.keyH.spacePressed == true) {
                gp.gameState = gp.dialogueState;
                dialogueCount = -1;
                npcNum = i;
            }
            continueDialogue = true;
            
            dialogueCount++;
            if(gp.npc[npcNum] != null && gp.npc[npcNum].dialogue[dialogueCount] != null) {
                gp.npc[npcNum].speak(dialogueCount);
            } else {
                continueDialogue = false;
                dialogueCount = -1;
                npcNum = 7;
            }
        }
        gp.keyH.ePressed = false;
    }

    public void iceMakeOrBreak(){
        if(iceCounter == 0) {
            playerWorldCol = gp.player.worldX/gp.tileSize;
            playerWorldRow = gp.player.worldY/gp.tileSize;
            playerDirection = direction;
        }
        iceCounter++;
        ice.iceInteraction(playerDirection, playerWorldCol, playerWorldRow, iceCounter, gp);
        if(iceCounter == 10) {
            ice.iceBreak = false;
            iceCounter = 0;
            iceInteract = false;
        }
    }

    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        playerImage = null;

        switch (direction) {
            case "up":
                if(spriteNum == 1) {
                    playerImage = up1;
                } else if(spriteNum == 2) {
                    playerImage = up2;
                } else if(spriteNum == 3) {
                    playerImage = up3;
                } else if(spriteNum == 4) {
                    playerImage = up4;
                } else if(spriteNum == 5) {
                    playerImage = up1;
                } else if(spriteNum == 6) {
                    playerImage = up1;
                }
                break;
            case "down":
                if(spriteNum == 1) {
                    playerImage = down1;
                } else if(spriteNum == 2) {
                    playerImage = down2;
                } else if(spriteNum == 3) {
                    playerImage = down3;
                } else if(spriteNum == 4) {
                    playerImage = down4;
                } else if(spriteNum == 5) {
                    playerImage = down1;
                } else if(spriteNum == 6) {
                    playerImage = down1;
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    playerImage = left1;
                } else if(spriteNum == 2) {
                    playerImage = left2;
                } else if(spriteNum == 3) {
                    playerImage = left3;
                } else if(spriteNum == 4) {
                    playerImage = left4;
                } else if(spriteNum == 5) {
                    playerImage = left5;
                } else if(spriteNum == 6) {
                    playerImage = left6;
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    playerImage = right1;
                } else if(spriteNum == 2) {
                    playerImage = right2;
                } else if(spriteNum == 3) {
                    playerImage = right3;
                } else if(spriteNum == 4) {
                    playerImage = right4;
                } else if(spriteNum == 5) {
                    playerImage = right5;
                } else if(spriteNum == 6) {
                    playerImage = right6;
                }
                break;
        }

        g2.drawImage(playerImage, screenX, screenY - 28, gp.characterWidth, gp.characterHeight, null);
        // g2.setColor(Color.red);
        // g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
    }
}
