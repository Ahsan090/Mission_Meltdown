package obj;

import java.awt.Rectangle;

import entity.Entity;
import game.GamePanel;

public class OBJ_Fireplace extends Entity{

    public OBJ_Fireplace(GamePanel gp) {
        super(gp);
        name = "FirePlace";
        down1 = setup("/res/objects/Fireplace_1", gp.tileSize, gp.tileSize);

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 60;
        solidArea.height = 60;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        collision = true;
        isObject = true;
        objectWidth = 60;
        objectHeight = 52;
        objectOffSetX = 0;
        objectOffSetY = 0;
    }
}
