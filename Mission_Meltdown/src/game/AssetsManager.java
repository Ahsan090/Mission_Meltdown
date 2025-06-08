package game;

import entity.NPC;
import obj.OBJ_Key;
import obj.OBJ_House;
import obj.OBJ_Ice;
import obj.OBJ_Igloo;

// import obj.OBJ_Ice;
// import obj.OBJ_Key;

public class AssetsManager {

    GamePanel gp;

    public AssetsManager(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        
        setAsset(15, 13, "key");
        setAsset(19, 12, "house");
        setAsset(22, 5, "igloo");

        setAsset(16, 12, "ice");
        setAsset(17, 12, "ice");
        
        setAsset(0, 5, "ice");
        setAsset(1, 5, "ice");
        setAsset(2, 5, "ice");
        setAsset(3, 5, "ice");
        setAsset(4, 5, "ice");
        setAsset(5, 5, "ice");
        setAsset(6, 5, "ice");
        setAsset(7, 5, "ice");
        setAsset(8, 5, "ice");
        setAsset(9, 5, "ice");
        setAsset(10, 5, "ice");
        setAsset(11, 5, "ice");
        setAsset(12, 5, "ice");
        setAsset(13, 5, "ice");
        setAsset(14, 5, "ice");
        setAsset(15, 5, "ice");
        setAsset(16, 5, "ice");
        setAsset(17, 5, "ice");
        setAsset(18, 5, "ice");
        setAsset(19, 5, "ice");
        setAsset(20, 5, "ice");
        setAsset(21, 4, "ice");
        setAsset(22, 4, "ice");
        setAsset(23, 4, "ice");
        setAsset(24, 4, "ice");
        setAsset(25, 4, "ice");
        setAsset(26, 4, "ice");
        setAsset(27, 4, "ice");
        setAsset(28, 5, "ice");
        setAsset(29, 5, "ice");
        setAsset(30, 5, "ice");
        setAsset(31, 5, "ice");
        setAsset(32, 5, "ice");
        setAsset(33, 5, "ice");
        setAsset(34, 5, "ice");
        setAsset(35, 5, "ice");

        setAsset(35, 6, "ice");

        setAsset(0, 7, "ice");
        setAsset(1, 7, "ice");
        setAsset(2, 7, "ice");
        setAsset(3, 7, "ice");
        setAsset(4, 7, "ice");
        setAsset(5, 7, "ice");
        setAsset(6, 7, "ice");
        setAsset(7, 7, "ice");
        setAsset(8, 7, "ice");
        setAsset(9, 7, "ice");
        setAsset(35, 7, "ice");

        setAsset(9, 8, "ice");
        setAsset(35, 8, "ice");

        setAsset(9, 9, "ice");
        setAsset(35, 9, "ice");

        setAsset(9, 10, "ice");
        setAsset(35, 10, "ice");

        setAsset(9, 11, "ice");
        setAsset(35, 11, "ice");

        setAsset(9, 12, "ice");
        setAsset(35, 12, "ice");

        setAsset(9, 13, "ice");
        setAsset(35, 13, "ice");

        setAsset(9, 14, "ice");
        setAsset(35, 14, "ice");

        setAsset(9, 15, "ice");
        setAsset(35, 15, "ice");

        setAsset(9, 16, "ice");
        setAsset(35, 16, "ice");

        setAsset(9, 17, "ice");
        setAsset(35, 17, "ice");

        setAsset(9, 18, "ice");
        setAsset(35, 18, "ice");

        setAsset(9, 19, "ice");
        setAsset(35, 19, "ice");

        setAsset(9, 20, "ice");
        setAsset(35, 20, "ice");

        setAsset(9, 21, "ice");
        setAsset(35, 21, "ice");

        setAsset(9, 22, "ice");
        setAsset(35, 22, "ice");

        setAsset(9, 23, "ice");
        setAsset(9, 23, "ice");
        setAsset(10, 23, "ice");
        setAsset(11, 23, "ice");
        setAsset(12, 23, "ice");
        setAsset(13, 23, "ice");
        setAsset(14, 23, "ice");
        setAsset(15, 23, "ice");
        setAsset(16, 23, "ice");
        setAsset(17, 23, "ice");
        setAsset(18, 23, "ice");
        setAsset(19, 23, "ice");
        setAsset(20, 23, "ice");
        setAsset(21, 23, "ice");
        setAsset(22, 23, "ice");
        setAsset(23, 23, "ice");
        setAsset(24, 23, "ice");
        setAsset(25, 23, "ice");
        setAsset(26, 23, "ice");
        setAsset(27, 23, "ice");
        setAsset(28, 23, "ice");
        setAsset(29, 23, "ice");
        setAsset(30, 23, "ice");
        setAsset(31, 23, "ice");
        setAsset(32, 23, "ice");
        setAsset(33, 23, "ice");
        setAsset(34, 23, "ice");
        setAsset(35, 23, "ice");

    }

    public void setAsset(int objCol, int objRow, String objName) {
        if(objName.equals("ice")) {
            gp.obj[objCol][objRow] = new OBJ_Ice(gp);
            gp.obj[objCol][objRow].worldX = objCol * gp.tileSize;
            gp.obj[objCol][objRow].worldY = objRow * gp.tileSize;
        } else if(objName.equals("key")) {
            gp.obj[objCol][objRow] = new OBJ_Key(gp);
            gp.obj[objCol][objRow].worldX = objCol * gp.tileSize;
            gp.obj[objCol][objRow].worldY = objRow * gp.tileSize;
        } else if(objName.equals("house")) {
            gp.obj[objCol][objRow] = new OBJ_House(gp);
            gp.obj[objCol][objRow].worldX = objCol * gp.tileSize;
            gp.obj[objCol][objRow].worldY = objRow * gp.tileSize;
        } else if(objName.equals("igloo")) {
            gp.obj[objCol][objRow] = new OBJ_Igloo(gp);
            gp.obj[objCol][objRow].worldX = objCol * gp.tileSize;
            gp.obj[objCol][objRow].worldY = objRow * gp.tileSize;
        }
    }

    public void setNPC() {

        gp.npc[0] = new NPC(gp);
        gp.npc[0].worldX = gp.tileSize * 15;
        gp.npc[0].worldY = gp.tileSize * 12;
    }
}
