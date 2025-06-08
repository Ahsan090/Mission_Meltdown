package obj;

import java.awt.Rectangle;

import entity.Entity;
import game.GamePanel;

public class OBJ_Sign1 extends Entity{

    public OBJ_Sign1(GamePanel gp) {
        super(gp);
        name = "Sign1";
        down1 = setup("/res/objects/Sign_1", gp.tileSize, gp.tileSize);

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 60;
        solidArea.height = 60;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        collision = true;
        isObject = true;
        objectWidth = 48;
        objectHeight = 44;
        objectOffSetX = 5;
        objectOffSetY = -10;
    }
}
