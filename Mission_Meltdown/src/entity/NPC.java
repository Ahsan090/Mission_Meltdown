package entity;

import java.awt.Rectangle;
//import java.util.Random;

import game.GamePanel;

public class NPC extends Entity{

    public NPC(GamePanel gp) {
        super(gp);

        speed = 2;
        direction = "down";
        solidArea = new Rectangle(0, 0, 60, 60);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        getNPCImage();
        setDialogue();
    }

    public void getNPCImage() { // loaded all the sprites (these files are currently for testing purpose only, will change)
        
        up1 = setupPlayer("/res/player/shaikh_up_0");
        down1 = setupPlayer("/res/player/shaikh_down_0");
        left1 = setupPlayer("/res/player/shaikh_left_0");
        right1 = setupPlayer("/res/player/shaikh_right_0");

    }

    public void setDialogue() {

        // dialogue[0] = "Wazz uppp";
        // dialogue[1] = "Soo.. What brought you here?";
        // dialogue[2] = "Nvm, I don't care enough";
        // dialogue[3] = "You know what? I'ma keep talking you can do nothin \nabout it hahahahaha  hehehifaada  huadhau a ahhadahdha dh dwhadn n";
    }

    public void speak(int dialogueCounter) {
        
        super.speak(dialogueCounter);
    }
}
