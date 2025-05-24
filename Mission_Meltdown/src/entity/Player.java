package entity;

//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.GamePanel;
import game.KeyHandler;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX, screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = (gp.screenWidth / 2) - (gp.tileSize / 2);
        screenY = (gp.screenHeight / 2) - (gp.tileSize / 2);

        solidArea = new Rectangle(10, 44, 45, 40);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX = gp.tileSize * 16;
        worldY = gp.tileSize * 9;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() { // loaded all the sprites (these files are currently for testing purpose only, will change)
        
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_walkup_1-removebg-preview.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_walkup_2-removebg-preview.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_walkup_3-removebg-preview.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_walkup_4-removebg-preview.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_down_2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_down_3.png"));
            down4 = down2;

            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_walkleft_1-removebg-preview.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_walkleft_2-removebg-preview.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_walkleft_3-removebg-preview.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_walkleft_4-removebg-preview.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_walkright_1-removebg-preview.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_walkright_2-removebg-preview.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_walkright_3-removebg-preview.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_walkright_4-removebg-preview.png"));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void update() {
        
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {

            if(keyH.upPressed == true) {
                direction = "up";               
            } else if (keyH.downPressed == true) {
                direction = "down";              
            } else if (keyH.leftPressed == true) {
                direction = "left";                
            } else if (keyH.rightPressed == true) {
                direction = "right";            
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

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
            if(spriteCounter > 10) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                } else if(spriteNum == 2) {
                    spriteNum = 3;
                } else if(spriteNum == 3) {
                    spriteNum = 4;
                } else if(spriteNum == 4) {
                    spriteNum = 1;
                }

                spriteCounter = 0;
            }
        }
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
                }
                break;
        }

        g2.drawImage(image, screenX, screenY, gp.characterWidth, gp.characterHeight, null);
    }
}
