package game;

import entity.NPC;
import entity.NPC_Enemy;
import obj.OBJ_Key;
import obj.OBJ_Lamppost;
import obj.OBJ_Sign1;
import obj.OBJ_Sign2;
import obj.OBJ_Well;
import obj.OBJ_BoundaryBlock;
import obj.OBJ_Door;
import obj.OBJ_Fireplace;
import obj.OBJ_House;
import obj.OBJ_House2;
import obj.OBJ_House3;
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
        
        setAsset(12, 2, "boundary");
        setAsset(13, 2, "boundary");
        setAsset(14, 2, "boundary");
        setAsset(15, 2, "boundary");
        setAsset(16, 2, "boundary");
        setAsset(17, 2, "boundary");
        setAsset(18, 2, "boundary");
        setAsset(21, 2, "boundary");
        setAsset(22, 2, "boundary");
        setAsset(23, 2, "boundary");
        setAsset(24, 2, "boundary");
        setAsset(25, 2, "boundary");
        setAsset(26, 2, "boundary");
        setAsset(27, 2, "boundary");
        setAsset(30, 2, "boundary");
        setAsset(31, 2, "boundary");
        setAsset(32, 2, "boundary");
        setAsset(33, 2, "boundary");
        setAsset(34, 2, "boundary");
        setAsset(35, 2, "boundary");
        setAsset(36, 2, "boundary");

        setAsset(12, 3, "boundary");
        setAsset(15, 5, "igloo");
        setAsset(18, 3, "boundary");
        setAsset(21, 3, "boundary");
        setAsset(24, 5, "igloo");
        setAsset(27, 3, "boundary");
        setAsset(30, 3, "boundary");
        setAsset(33, 5, "igloo");
        setAsset(36, 3, "boundary");

        setAsset(12, 4, "boundary");
        setAsset(18, 4, "boundary");
        setAsset(21, 4, "boundary");
        setAsset(27, 4, "boundary");
        setAsset(30, 4, "boundary");
        setAsset(36, 4, "boundary");

        setAsset(0, 5, "boundary");
        setAsset(1, 5, "boundary");
        setAsset(2, 5, "boundary");
        setAsset(3, 5, "boundary");
        setAsset(4, 5, "boundary");
        setAsset(5, 5, "boundary");
        setAsset(6, 5, "boundary");
        setAsset(7, 5, "boundary");
        setAsset(8, 5, "boundary");
        setAsset(9, 5, "boundary");
        setAsset(10, 5, "boundary");
        setAsset(11, 5, "boundary");
        setAsset(12, 5, "boundary");
        setAsset(18, 5, "boundary");
        setAsset(19, 5, "boundary");
        setAsset(20, 5, "boundary");
        setAsset(21, 5, "boundary");
        setAsset(27, 5, "boundary");
        setAsset(28, 5, "boundary");
        setAsset(29, 5, "boundary");
        setAsset(30, 5, "boundary");
        setAsset(36, 5, "boundary");

        setAsset(36, 6, "boundary");

        setAsset(0, 7, "boundary");
        setAsset(1, 7, "boundary");
        setAsset(2, 7, "boundary");
        setAsset(3, 7, "boundary");
        setAsset(4, 7, "boundary");
        setAsset(5, 7, "boundary");
        setAsset(6, 7, "boundary");
        setAsset(7, 7, "boundary");
        setAsset(8, 7, "boundary");
        setAsset(9, 7, "boundary");
        setAsset(10, 7, "sign1");
        setAsset(35, 7, "boundary");
        setAsset(36, 7, "boundary");

        setAsset(9, 8, "boundary");
        setAsset(35, 8, "boundary");

        setAsset(9, 9, "boundary");
        setAsset(35, 9, "boundary");

        setAsset(9, 10, "boundary");
        setAsset(10, 10, "boundary");
        setAsset(11, 10, "boundary");
        setAsset(12, 10, "boundary");
        setAsset(13, 10, "boundary");
        setAsset(14, 10, "boundary");
        setAsset(15, 10, "boundary");
        setAsset(16, 10, "boundary");
        setAsset(17, 10, "boundary");
        setAsset(18, 10, "boundary");
        setAsset(19, 10, "boundary");
        setAsset(20, 10, "boundary");
        setAsset(21, 10, "boundary");
        setAsset(22, 10, "boundary");
        setAsset(23, 10, "boundary");
        setAsset(24, 10, "boundary");
        setAsset(25, 10, "boundary");
        setAsset(26, 10, "boundary");
        setAsset(27, 10, "boundary");
        setAsset(28, 10, "boundary");
        setAsset(29, 10, "boundary");
        setAsset(30, 10, "boundary");
        setAsset(31, 10, "boundary");
        setAsset(32, 10, "ice");
        setAsset(33, 10, "ice");
        setAsset(34, 10, "boundary");
        setAsset(35, 10, "boundary");

        setAsset(9, 11, "boundary");
        setAsset(21, 11, "ice");
        setAsset(22, 11, "ice");
        setAsset(23, 11, "ice");
        setAsset(24, 11, "ice");
        setAsset(25, 11, "ice");
        setAsset(26, 11, "ice");
        setAsset(27, 11, "ice");
        setAsset(28, 11, "ice");
        setAsset(29, 11, "ice");
        setAsset(30, 11, "ice");
        setAsset(31, 11, "ice");
        setAsset(35, 11, "boundary");

        setAsset(9, 12, "boundary");
        setAsset(11, 12, "boundary");
        setAsset(12, 12, "ice");
        setAsset(13, 12, "boundary");
        setAsset(15, 12, "boundary");
        setAsset(17, 12, "boundary");
        setAsset(18, 12, "ice");
        setAsset(19, 12, "boundary");
        setAsset(21, 12, "ice");
        setAsset(22, 12, "ice");
        setAsset(23, 12, "ice");
        setAsset(24, 12, "ice");
        setAsset(25, 12, "ice");
        setAsset(26, 14, "house");
        setAsset(31, 12, "ice");
        setAsset(35, 12, "boundary");

        setAsset(9, 13, "boundary");
        setAsset(17, 13, "ice");
        setAsset(11, 13, "ice");
        setAsset(21, 13, "ice");
        setAsset(22, 13, "ice");
        setAsset(23, 13, "ice");
        setAsset(24, 13, "ice");
        setAsset(25, 13, "ice");
        setAsset(31, 13, "ice");
        setAsset(35, 13, "boundary");

        setAsset(9, 14, "boundary");
        setAsset(10, 14, "boundary");
        setAsset(12, 14, "boundary");
        setAsset(14, 14, "boundary");
        setAsset(15, 14, "ice");
        setAsset(16, 14, "boundary");
        setAsset(18, 14, "boundary");
        setAsset(19, 14, "ice");
        setAsset(20, 14, "boundary");
        setAsset(21, 14, "ice");
        setAsset(22, 14, "ice");
        setAsset(23, 14, "ice");
        setAsset(24, 14, "ice");
        setAsset(25, 14, "ice");
        setAsset(30, 14, "ice");
        setAsset(31, 14, "ice");
        setAsset(32, 14, "ice");
        setAsset(33, 14, "ice");
        setAsset(34, 14, "ice");
        setAsset(35, 14, "boundary");

        setAsset(9, 15, "boundary");
        setAsset(15, 15, "ice");
        setAsset(18, 15, "ice");
        setAsset(22, 15, "ice");
        setAsset(34, 15, "ice");
        setAsset(35, 15, "boundary");

        setAsset(9, 16, "boundary");
        setAsset(11, 16, "boundary");
        setAsset(13, 16, "boundary");
        setAsset(14, 16, "ice");
        setAsset(15, 16, "boundary");
        setAsset(17, 16, "boundary");
        setAsset(19, 16, "boundary");
        setAsset(20, 16, "ice");
        setAsset(22, 16, "ice");
        setAsset(26, 16, "fireplace");
        setAsset(33, 16, "ice");
        setAsset(34, 16, "ice");
        setAsset(35, 16, "boundary");

        setAsset(9, 17, "boundary");
        setAsset(13, 17, "ice");
        setAsset(14, 17, "ice");
        setAsset(22, 17, "ice");
        setAsset(16, 17, "boundary");
        setAsset(18, 17, "ice");
        setAsset(22, 17, "ice");
        setAsset(32, 17, "ice");
        setAsset(33, 17, "ice");
        setAsset(34, 17, "ice");
        setAsset(35, 17, "boundary");

        setAsset(9, 18, "boundary");
        setAsset(10, 18, "boundary");
        setAsset(11, 18, "boundary");
        setAsset(12, 18, "door");
        setAsset(13, 18, "door");
        setAsset(14, 18, "boundary");
        setAsset(15, 18, "boundary");
        setAsset(16, 18, "boundary");
        setAsset(17, 18, "boundary");
        setAsset(18, 18, "boundary");
        setAsset(19, 18, "boundary");
        setAsset(20, 18, "boundary");
        setAsset(21, 18, "boundary");
        setAsset(22, 18, "boundary");
        setAsset(23, 18, "boundary");
        setAsset(24, 18, "boundary");
        setAsset(25, 18, "boundary");
        setAsset(26, 18, "boundary");
        setAsset(27, 18, "boundary");
        setAsset(28, 18, "boundary");
        setAsset(29, 18, "boundary");
        setAsset(30, 18, "boundary");
        setAsset(31, 18, "boundary");
        setAsset(32, 18, "boundary");
        setAsset(33, 18, "boundary");
        setAsset(34, 18, "boundary");
        setAsset(35, 18, "boundary");
        setAsset(38, 18, "boundary");
        setAsset(39, 18, "boundary");
        setAsset(40, 18, "boundary");
        setAsset(41, 18, "boundary");
        setAsset(42, 18, "boundary");
        setAsset(43, 18, "boundary");
        setAsset(44, 18, "boundary");

        setAsset(9, 19, "boundary");
        setAsset(15, 19, "sign2");
        setAsset(17, 19, "lamppost");
        setAsset(19, 19, "house");
        setAsset(24, 19, "house3");
        setAsset(30, 19, "well");
        setAsset(35, 19, "boundary");
        setAsset(38, 19, "boundary");
        setAsset(39, 19, "house2");
        setAsset(43, 20, "house3");

        setAsset(9, 20, "boundary");
        setAsset(35, 20, "boundary");
        setAsset(38, 20, "boundary");
        

        setAsset(9, 21, "boundary");
        setAsset(35, 21, "boundary");
        setAsset(36, 21, "boundary");
        setAsset(37, 21, "boundary");
        setAsset(38, 21, "boundary");

        setAsset(9, 22, "boundary");

        setAsset(9, 23, "boundary");
        setAsset(9, 23, "boundary");
        setAsset(10, 23, "boundary");
        setAsset(11, 23, "boundary");
        setAsset(12, 23, "boundary");
        setAsset(13, 23, "boundary");
        setAsset(14, 23, "boundary");
        setAsset(15, 23, "boundary");
        setAsset(16, 23, "boundary");
        setAsset(17, 23, "boundary");
        setAsset(18, 23, "boundary");
        setAsset(19, 23, "boundary");
        setAsset(20, 23, "boundary");
        setAsset(21, 23, "boundary");
        setAsset(22, 23, "boundary");
        setAsset(23, 23, "boundary");
        setAsset(24, 23, "boundary");
        setAsset(25, 23, "boundary");
        setAsset(26, 23, "boundary");
        setAsset(27, 23, "boundary");
        setAsset(28, 23, "boundary");
        setAsset(29, 23, "boundary");
        setAsset(30, 23, "boundary");
        setAsset(31, 23, "boundary");
        setAsset(32, 23, "boundary");
        setAsset(33, 23, "boundary");
        setAsset(34, 23, "boundary");
        setAsset(35, 23, "boundary");
        setAsset(36, 23, "boundary");
        setAsset(37, 23, "boundary");
        setAsset(38, 23, "boundary");
        setAsset(39, 23, "boundary");
        setAsset(40, 23, "boundary");
        setAsset(41, 23, "boundary");
        setAsset(42, 23, "boundary");
        setAsset(43, 23, "boundary");
        setAsset(44, 23, "boundary");

    }

    public void setAsset(int objCol, int objRow, String objName) {
        if(objName.equals("ice")) {
            gp.obj[objCol][objRow] = new OBJ_Ice(gp);
            gp.obj[objCol][objRow].worldX = objCol * gp.tileSize;
            gp.obj[objCol][objRow].worldY = objRow * gp.tileSize;
        } else if(objName.equals("boundary")) {
            gp.obj[objCol][objRow] = new OBJ_BoundaryBlock(gp);
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
        } else if(objName.equals("house2")) {
            gp.obj[objCol][objRow] = new OBJ_House2(gp);
            gp.obj[objCol][objRow].worldX = objCol * gp.tileSize;
            gp.obj[objCol][objRow].worldY = objRow * gp.tileSize;
        } else if(objName.equals("house3")) {
            gp.obj[objCol][objRow] = new OBJ_House3(gp);
            gp.obj[objCol][objRow].worldX = objCol * gp.tileSize;
            gp.obj[objCol][objRow].worldY = objRow * gp.tileSize;
        } else if(objName.equals("igloo")) {
            gp.obj[objCol][objRow] = new OBJ_Igloo(gp);
            gp.obj[objCol][objRow].worldX = objCol * gp.tileSize;
            gp.obj[objCol][objRow].worldY = objRow * gp.tileSize;
        } else if(objName.equals("door")) {
            gp.obj[objCol][objRow] = new OBJ_Door(gp);
            gp.obj[objCol][objRow].worldX = objCol * gp.tileSize;
            gp.obj[objCol][objRow].worldY = objRow * gp.tileSize;
        } else if(objName.equals("sign1")) {
            gp.obj[objCol][objRow] = new OBJ_Sign1(gp);
            gp.obj[objCol][objRow].worldX = objCol * gp.tileSize;
            gp.obj[objCol][objRow].worldY = objRow * gp.tileSize;
        } else if(objName.equals("sign2")) {
            gp.obj[objCol][objRow] = new OBJ_Sign2(gp);
            gp.obj[objCol][objRow].worldX = objCol * gp.tileSize;
            gp.obj[objCol][objRow].worldY = objRow * gp.tileSize;
        } else if(objName.equals("lamppost")) {
            gp.obj[objCol][objRow] = new OBJ_Lamppost(gp);
            gp.obj[objCol][objRow].worldX = objCol * gp.tileSize;
            gp.obj[objCol][objRow].worldY = objRow * gp.tileSize;
        } else if(objName.equals("fireplace")) {
            gp.obj[objCol][objRow] = new OBJ_Fireplace(gp);
            gp.obj[objCol][objRow].worldX = objCol * gp.tileSize;
            gp.obj[objCol][objRow].worldY = objRow * gp.tileSize;
        } else if(objName.equals("well")) {
            gp.obj[objCol][objRow] = new OBJ_Well(gp);
            gp.obj[objCol][objRow].worldX = objCol * gp.tileSize;
            gp.obj[objCol][objRow].worldY = objRow * gp.tileSize;
        }
    }

    public void setNPC() {

        gp.npc[0] = new NPC(gp);
        gp.npc[0].worldX = gp.tileSize * 13;
        gp.npc[0].worldY = gp.tileSize * 6;

        gp.npc[1] = new NPC(gp);
        gp.npc[1].worldX = gp.tileSize * 21;
        gp.npc[1].worldY = gp.tileSize * 6;
        gp.npc[1].direction = "right";

        gp.npc[2] = new NPC(gp);
        gp.npc[2].worldX = gp.tileSize * 22;
        gp.npc[2].worldY = gp.tileSize * 6;
        gp.npc[2].direction = "left";

        gp.npc[3] = new NPC(gp);
        gp.npc[3].worldX = gp.tileSize * 34;
        gp.npc[3].worldY = gp.tileSize * 8;
        gp.npc[3].direction = "left";

        gp.npc[4] = new NPC(gp);
        gp.npc[4].worldX = gp.tileSize * 33;
        gp.npc[4].worldY = gp.tileSize * 7;
        gp.npc[4].direction = "left";

        gp.npc[5] = new NPC(gp);
        gp.npc[5].worldX = gp.tileSize * 31;
        gp.npc[5].worldY = gp.tileSize * 7;
        gp.npc[5].direction = "right";

        gp.npc[6] = new NPC(gp);
        gp.npc[6].worldX = gp.tileSize * 32;
        gp.npc[6].worldY = gp.tileSize * 6;
        gp.npc[6].direction = "down";

        gp.npc_e[0] = new NPC_Enemy(gp);
        gp.npc_e[0].worldX = gp.tileSize * 15;
        gp.npc_e[0].worldY = gp.tileSize * 12;

        gp.npc_e[1] = new NPC_Enemy(gp);
        gp.npc_e[1].worldX = gp.tileSize * 31;
        gp.npc_e[1].worldY = gp.tileSize * 16;

    }
}
