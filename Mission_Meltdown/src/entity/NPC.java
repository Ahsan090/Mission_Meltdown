package entity;

import java.awt.Rectangle;
//import java.util.Random;

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

    public void setDialogue() {

        dialogue[0] = "Wazz uppp";
        dialogue[1] = "Soo.. What brought you here?";
        dialogue[2] = "Nvm, I don't care enough";
        dialogue[3] = "You know what? I'ma keep talking you can do nothin \nabout it hahahahaha  hehehifaada  huadhau a ahhadahdha dh dwhadn n";
    }

    public void speak() {
        
        super.speak();
    }
}
