package obj;

import java.awt.Rectangle;

import entity.Entity;
import game.GamePanel;

public class OBJ_Lamppost extends Entity{

    public OBJ_Lamppost(GamePanel gp) {
        super(gp);
        name = "Sign1";
        down1 = setup("/res/objects/LampPost_3", gp.tileSize, gp.tileSize);

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 60;
        solidArea.height = 60;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        collision = true;
        isObject = true;
        objectWidth = 72;
        objectHeight = 124;
        objectOffSetX = -5;
        objectOffSetY = -80;
    }
}
