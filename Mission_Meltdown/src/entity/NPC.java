package entity;

import java.awt.Rectangle;
//import java.util.Random;

import game.GamePanel;

public class NPC extends Entity{

    public int npcType;

    public NPC(GamePanel gp, int npcType) {
        super(gp);

        speed = 2;
        direction = "down";
        solidArea = new Rectangle(0, 0, 60, 60);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        this.npcType = npcType;
        
        getNPCImage();
        setDialogue();
    }

    public void getNPCImage() { // loaded all the sprites (these files are currently for testing purpose only, will change)
        if(npcType == 1) {
            up1 = setupPlayer("/res/npc/npc_green_up");
            down1 = setupPlayer("/res/npc/npc_green_down");
            left1 = setupPlayer("/res/npc/npc_green_left");
            right1 = setupPlayer("/res/npc/npc_green_right");
        } else if(npcType == 2) {
            up1 = setupPlayer("/res/npc/npc_yellow_up");
            down1 = setupPlayer("/res/npc/npc_yellow_down");
            left1 = setupPlayer("/res/npc/npc_yellow_left");
            right1 = setupPlayer("/res/npc/npc_yellow_right");
        }

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
