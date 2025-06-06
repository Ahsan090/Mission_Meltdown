package entity;

import java.awt.Rectangle;
import java.util.Random;

import game.GamePanel;

public class NPC extends Entity{

    public NPC(GamePanel gp) {
        super(gp);

        speed = 2;
        direction = "down";
        solidArea = new Rectangle(2, 28, 56, 56);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        getNPCImage();
        setDialogue();
    }

    public void getNPCImage() { // loaded all the sprites (these files are currently for testing purpose only, will change)
        
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

    public void setDialogue() {

        dialogue[0] = "Wazz uppp";
        dialogue[1] = "Soo.. What brought you here?";
        dialogue[2] = "Nvm, I don't care enough";
        dialogue[3] = "You know what? I'ma keep talking you can do nothin \nabout it hahahahaha  hehehifaada  huadhau a ahhadahdha dh dwhadn n";
    }

    public void setAction() {
        actionLockCounter++;

        if(actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if(i <= 25) {
                tempDirection = "up";
            } else if(i <= 50) {
                tempDirection = "down";
            } else if(i <= 75) {
                tempDirection = "left";
            } else if(i <= 100) {
                tempDirection = "right";
            }

            actionLockCounter = 0;
        }    
    }

    public void speak() {
        
        super.speak();
    }
}
