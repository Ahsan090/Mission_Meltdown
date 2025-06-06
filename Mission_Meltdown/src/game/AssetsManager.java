package game;

import entity.NPC;
import obj.OBJ_Key;
import obj.OBJ_Ice;

// import obj.OBJ_Ice;
// import obj.OBJ_Key;

public class AssetsManager {

    GamePanel gp;

    public AssetsManager(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        
        gp.obj[22][74] = new OBJ_Key(gp);
        gp.obj[22][74].worldX = 22 * gp.tileSize;
        gp.obj[22][74].worldY = 74 * gp.tileSize;

        gp.obj[23][77] = new OBJ_Ice(gp);
        gp.obj[23][77].worldX = 23 * gp.tileSize;
        gp.obj[23][77].worldY = 77 * gp.tileSize;

        
    }

    public void setNPC() {

        gp.npc[0] = new NPC(gp);
        gp.npc[0].worldX = gp.tileSize * 18;
        gp.npc[0].worldY = gp.tileSize * 72;
    }
}
