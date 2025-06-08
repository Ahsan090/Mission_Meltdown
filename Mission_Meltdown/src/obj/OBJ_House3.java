package obj;

import java.awt.Rectangle;

import entity.Entity;
import game.GamePanel;

public class OBJ_House3 extends Entity{

    public OBJ_House3(GamePanel gp) {
        super(gp);
        name = "House3";
        down1 = setup("/res/objects/House_Hay_2", gp.tileSize, gp.tileSize);

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = -gp.tileSize;
        solidArea.width = 60;
        solidArea.height = 60;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        collision = false;
        isObject = true;
        objectWidth = 300;
        objectHeight = 240;
        objectOffSetX = 0;
        objectOffSetY = -gp.tileSize - 30;
    }
}
