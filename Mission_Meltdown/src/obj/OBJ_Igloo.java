package obj;

import java.awt.Rectangle;

import entity.Entity;
import game.GamePanel;

public class OBJ_Igloo extends Entity{

    public OBJ_Igloo(GamePanel gp) {
        super(gp);
        name = "Igloo";
        down1 = setup("/res/objects/igloo", gp.tileSize, gp.tileSize);

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 300;
        solidArea.height = 300;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        collision = true;
        isObject = true;
        objectWidth = 300;
        objectHeight = 300;
        objectOffSetX = 0;
        objectOffSetY = 0;
    }
}
