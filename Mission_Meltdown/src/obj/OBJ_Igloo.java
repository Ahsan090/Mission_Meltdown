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
        solidArea.x = -gp.tileSize * 2;
        solidArea.y = -gp.tileSize * 2;
        solidArea.width = 60;
        solidArea.height = 60;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        collision = false;
        isObject = true;
        objectWidth = 300;
        objectHeight = 300;
        objectOffSetX = -gp.tileSize * 2;
        objectOffSetY = -gp.tileSize * 2;
    }
}
