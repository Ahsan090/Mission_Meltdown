package game;

import entity.NPC;
import obj.OBJ_Ice;
import obj.OBJ_Key;

// import obj.OBJ_Ice;
// import obj.OBJ_Key;

public class AssetsManager {

    GamePanel gp;

    public AssetsManager(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        
        gp.obj[0] = new OBJ_Key(gp);
        gp.obj[0].worldX = 22 * gp.tileSize;
        gp.obj[0].worldY = 74 * gp.tileSize;

        gp.obj[1] = new OBJ_Ice(gp);
        gp.obj[1].worldX = 24 * gp.tileSize;
        gp.obj[1].worldY = 74 * gp.tileSize;
        gp.iceBlocks.add(gp.obj[1]);

        gp.obj[2] = new OBJ_Ice(gp);
        gp.obj[2].worldX = 24 * gp.tileSize;
        gp.obj[2].worldY = 78 * gp.tileSize;
        gp.iceBlocks.add(gp.obj[2]);
    }

    public void setNPC() {

        gp.npc[0] = new NPC(gp);
        gp.npc[0].worldX = gp.tileSize * 18;
        gp.npc[0].worldY = gp.tileSize * 72;
    }
}
