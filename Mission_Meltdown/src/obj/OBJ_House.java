package obj;

import java.awt.Rectangle;

import entity.Entity;
import game.GamePanel;

public class OBJ_House extends Entity {

    public OBJ_House(GamePanel gp) {
        super(gp);
        name = "House";
        down1 = setup("/res/objects/House_Hay_1", gp.tileSize, gp.tileSize);

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 89;
        solidArea.height = 91;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        collision = true;
        isObject = true;
        objectWidth = 89;
        objectHeight = 91;
        objectOffSetX = 0;
        objectOffSetY = 0;
    }
}
