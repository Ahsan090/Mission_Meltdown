package obj;

import java.awt.Rectangle;

import entity.Entity;
import game.GamePanel;

public class OBJ_Ice extends Entity {

    public OBJ_Ice(GamePanel gp) {
        super(gp);
        name = "Ice";
        down1 = setup("/res/objects/ice block", gp.blockWidth, gp.blockHeight);

        solidArea = new Rectangle();
        solidArea.x = 5;
        solidArea.y = 12;
        solidArea.width = 50;
        solidArea.height = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        collision = true;
        isObject = true;
        objectWidth = gp.blockWidth;
        objectHeight = gp.blockHeight;
        objectOffSetX = 0;
        objectOffSetY = -12;
    }
    
}
