package obj;

import java.awt.Rectangle;

import entity.Entity;
import game.GamePanel;

public class OBJ_Sign2 extends Entity{

    public OBJ_Sign2(GamePanel gp) {
        super(gp);
        name = "Sign2";
        down1 = setup("/res/objects/BulletinBoard_1", gp.tileSize, gp.tileSize);

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 60;
        solidArea.height = 60;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        collision = true;
        isObject = true;
        objectWidth = 88;
        objectHeight = 84;
        objectOffSetX = -13;
        objectOffSetY = -40;
    }
}
