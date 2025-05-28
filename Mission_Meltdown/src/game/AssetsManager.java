package game;

import obj.OBJ_Ice;
import obj.OBJ_Key;

public class AssetsManager {

    GamePanel gp;

    public AssetsManager(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 4 * gp.tileSize;
        gp.obj[0].worldY = 6 * gp.tileSize;

        gp.obj[1] = new OBJ_Ice();
        gp.obj[1].worldX = 7 * gp.tileSize;
        gp.obj[1].worldY = 6 * gp.tileSize;
    }
}
