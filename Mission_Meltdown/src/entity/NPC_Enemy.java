package entity;

import java.awt.Rectangle;
import java.util.Random;

import game.GamePanel;

public class NPC_Enemy extends Entity{

    public NPC_Enemy(GamePanel gp) {
        super(gp);

        speed = 2;
        direction = "down";
        solidArea = new Rectangle(2, 0, 56, 58);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        isEnemy = true;
        getNPCImage();
        setDialogue();
    }

    public void getNPCImage() {
        
        up1 = setupPlayer("/res/enemy/chai_up_0");
        up2 = setupPlayer("/res/enemy/chai_up_1");
        up3 = setupPlayer("/res/enemy/chai_up_2");
        up4 = setupPlayer("/res/enemy/chai_up_3");
        up5 = setupPlayer("/res/enemy/chai_up_4");
        up6 = setupPlayer("/res/enemy/chai_up_5");

        down1 = setupPlayer("/res/enemy/chai_down_0");
        down2 = setupPlayer("/res/enemy/chai_down_1");
        down3 = setupPlayer("/res/enemy/chai_down_2");
        down4 = setupPlayer("/res/enemy/chai_down_3");
        down5 = setupPlayer("/res/enemy/chai_down_4");
        down6 = setupPlayer("/res/enemy/chai_down_5");

        left1 = setupPlayer("/res/enemy/chai_left_0");
        left2 = setupPlayer("/res/enemy/chai_left_1");
        left3 = setupPlayer("/res/enemy/chai_left_2");
        left4 = setupPlayer("/res/enemy/chai_left_3");
        left5 = setupPlayer("/res/enemy/chai_left_4");
        left6 = setupPlayer("/res/enemy/chai_left_5");

        right1 = setupPlayer("/res/enemy/chai_right_0");
        right2 = setupPlayer("/res/enemy/chai_right_1");
        right3 = setupPlayer("/res/enemy/chai_right_2");
        right4 = setupPlayer("/res/enemy/chai_right_3");
        right5 = setupPlayer("/res/enemy/chai_right_4");
        right6 = setupPlayer("/res/enemy/chai_right_5");
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

    public void speak(int dialogueCounter) {
        
        super.speak(dialogueCounter);
    }
}
