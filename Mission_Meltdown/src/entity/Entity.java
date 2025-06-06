package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.GamePanel;
import game.ImageScaling;

public class Entity { // a main class for all the entities in our game (i.e the player and the enemies)
    GamePanel gp;

    public int worldX, worldY;
    public int speed;

    public BufferedImage up1, up2, up3, up4, up5, up6, down1, down2, down3, down4, down5, down6, left1, left2, left3, left4, left5, left6, right1, right2, right3, right4, right5, right6;
    public String direction = "down";
    public String tempDirection = direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public int actionLockCounter = 0;

    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn;
    public boolean npcMoving = false;
    public int pixelCounter = 0;

    public String dialogue[] = new String[20];
    public int dialogueIndex = 0;

    public BufferedImage image, image2, image3;
    public String name;
    public boolean collision = false;
    public boolean isObject = false;
    public int objectWidth;
    public int objectHeight;
    public int objectOffSetX;
    public int objectOffSetY;

    public Entity(GamePanel gp) {
        this.gp = gp;

        objectWidth = gp.tileSize;
        objectHeight = gp.tileSize;
        objectOffSetX = 0;
        objectOffSetY = 0;
    }

    public void setAction() {}
    public void speak() {

        if(dialogue[dialogueIndex] == null) {
            dialogueIndex = 0;
        }
        gp.ui.currentDialogue = dialogue[dialogueIndex];
        dialogueIndex++;

        switch (gp.player.direction) {
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
        }
    }

    public void update() {
        
        setAction();
        pixelCounter += speed;
        if(pixelCounter == 60) {
            direction = tempDirection;
            pixelCounter = 0;
        }

        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkPlayer(this);

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
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
            worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && 
            worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
            worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

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
            if(isObject == true) {
                g2.drawImage(image, screenX + objectOffSetX, screenY + objectOffSetY, objectWidth, objectHeight, null);
                g2.setColor(Color.red);
                g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
            } else {
                g2.drawImage(image, screenX, screenY, gp.characterWidth, gp.characterHeight, null);
                g2.setColor(Color.red);
                g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
            }
        }
        
    }

    public BufferedImage setupPlayer(String imagePath) {
        ImageScaling imageScale = new ImageScaling();
        BufferedImage image = null;

        try {          
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = imageScale.scaledImage(image, gp.characterWidth, gp.characterHeight);

        } catch (IOException e) {
            e.getStackTrace();
        }

        return image;
    }
    
    public BufferedImage setup(String imagePath, int width, int height) {
        ImageScaling imageScale = new ImageScaling();
        BufferedImage image = null;

        try {          
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = imageScale.scaledImage(image, width, height);

        } catch (IOException e) {
            e.getStackTrace();
        }

        return image;
    }
}
