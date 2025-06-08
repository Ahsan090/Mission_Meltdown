package obj;

import java.awt.Rectangle;

import entity.Entity;
import game.GamePanel;

public class OBJ_BoundaryBlock extends Entity{

    public OBJ_BoundaryBlock(GamePanel gp) {
        super(gp);
        name = "Boundary Block";
        down1 = setup("/res/objects/boundary block", gp.blockWidth, gp.blockHeight);

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 60;
        solidArea.height = 60;
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
