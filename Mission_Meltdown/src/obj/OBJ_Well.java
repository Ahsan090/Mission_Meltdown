package obj;

import java.awt.Rectangle;

import entity.Entity;
import game.GamePanel;

public class OBJ_Well extends Entity{

    public OBJ_Well(GamePanel gp) {
        super(gp);
        name = "Well";
        down1 = setup("/res/objects/Well_Hay_1", gp.tileSize, gp.tileSize);

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 60;
        solidArea.height = 60;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        collision = true;
        isObject = true;
        objectWidth = 80;
        objectHeight = 110;
        objectOffSetX = -10;
        objectOffSetY = -60;
    }
}
