package obj;

import java.awt.Rectangle;

import entity.Entity;
import game.GamePanel;


public class OBJ_Key extends Entity {

    public OBJ_Key(GamePanel gp) {
        super(gp);
        name = "Key";
        down1 = setup("/res/objects/keyy", gp.tileSize, gp.tileSize);

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 60;
        solidArea.height = 72;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        isObject = true;
    }
}
