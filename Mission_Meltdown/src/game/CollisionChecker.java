package game;

import entity.Entity;

public class CollisionChecker {

    GamePanel gp;

    int tileNum1, tileNum2;
    Entity objNum1, objNum2;

    int entityLeftWorldX;
    int entityRightWorldX;
    int entityTopWorldY;
    int entityBottomWorldY;

    int entityLeftCol;
    int entityRightCol;
    int entityTopRow;
    int entityBottomRow;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void getPlayerPosition(Entity entity) {
        entityLeftWorldX = entity.worldX + entity.solidArea.x;
        entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        entityTopWorldY = entity.worldY + entity.solidArea.y;
        entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        entityLeftCol = entityLeftWorldX/gp.tileSize;
        entityRightCol = entityRightWorldX/gp.tileSize;
        entityTopRow = entityTopWorldY/gp.tileSize;
        entityBottomRow = entityBottomWorldY/gp.tileSize;
    }

    public void checkTile(Entity entity) {

        getPlayerPosition(entity);

        switch(entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];

                if(gp.tileM.tile[tileNum1].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];

                if(gp.tileM.tile[tileNum1].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];

                if(gp.tileM.tile[tileNum1].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];

                if(gp.tileM.tile[tileNum1].collision == true) {
                    entity.collisionOn = true;
                }
                break;
        }
    }

    public int checkObject(Entity entity, boolean player) {
        int index = 999;
        
        getPlayerPosition(entity);

        switch(entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                if(gp.obj[entityLeftCol][entityTopRow] != null) {
                    if(gp.obj[entityLeftCol][entityTopRow].collision == true) {
                        entity.collisionOn = true;
                    }
                }
                // objWorldRow--;
                // gp.obj[objWorldCol][objWorldRow].solidArea.y = gp.obj[objWorldCol][objWorldRow].worldY + gp.obj[objWorldCol][objWorldRow].solidArea.y;
                // if(gp.obj[objWorldCol][objWorldRow] != null && gp.obj[objWorldCol][objWorldRow].collision == true) {
                //     entity.collisionOn = true;
                //     break;
                // }
                break;
            case "down":  
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                if(gp.obj[entityLeftCol][entityBottomRow] != null) {
                    if(gp.obj[entityLeftCol][entityBottomRow].collision == true) {
                        entity.collisionOn = true;
                    }
                }
                // tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                // tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                // if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                //     entity.collisionOn = true;
                // }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;

                if(gp.obj[entityLeftCol][entityTopRow] != null) {
                    if(gp.obj[entityLeftCol][entityTopRow].collision == true) {
                        entity.collisionOn = true;
                    }
                }
                // tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                // tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];

                // if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                //     entity.collisionOn = true;
                // }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;

                if(gp.obj[entityRightCol][entityTopRow] != null) {
                    if(gp.obj[entityRightCol][entityTopRow].collision == true) {
                        entity.collisionOn = true;
                    }
                }
                // tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                // tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                // if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                //     entity.collisionOn = true;
                // }
                break;
        }
        // for(int i = 0; i < gp.obj.length; i++) {
        //     for(int j = 0; j < gp.obj[i].length; j++) {
        //         if(gp.obj[i][j] != null) {

        //             // Get Entity's Solid Area
        //             entity.solidArea.x = entity.worldX + entity.solidArea.x;
        //             entity.solidArea.y = entity.worldY + entity.solidArea.y;

        //             // Get Object Solid Area
        //             gp.obj[i][j].solidArea.x = gp.obj[i][j].worldX + gp.obj[i][j].solidArea.x;
        //             gp.obj[i][j].solidArea.y = gp.obj[i][j].worldY + gp.obj[i][j].solidArea.y;

        //             switch (entity.direction) {
        //                 case "up":
        //                     entity.solidArea.y -= entity.speed;
        //                     if(entity.solidArea.intersects(gp.obj[i][j].solidArea)){
        //                         if(gp.obj[i][j].collision == true) {
        //                             entity.collisionOn = true;
        //                         }
        //                         if(player == true) {
        //                             index = i;
        //                         }
        //                     }
        //                     break;
        //                 case "down":
        //                     entity.solidArea.y += entity.speed;
        //                     if(entity.solidArea.intersects(gp.obj[i][j].solidArea)){
        //                         if(gp.obj[i][j].collision == true) {
        //                             entity.collisionOn = true;
        //                         }
        //                         if(player == true) {
        //                             index = i;
        //                         }
        //                     }
        //                     break;
        //                 case "left":
        //                     entity.solidArea.x -= entity.speed;
        //                     if(entity.solidArea.intersects(gp.obj[i][j].solidArea)){
        //                         if(gp.obj[i][j].collision == true) {
        //                             entity.collisionOn = true;
        //                         }
        //                         if(player == true) {
        //                             index = i;
        //                         }
        //                     }
        //                     break;
        //                 case "right":
        //                     entity.solidArea.x += entity.speed;
        //                     if(entity.solidArea.intersects(gp.obj[i][j].solidArea)){
        //                         if(gp.obj[i][j].collision == true) {
        //                             entity.collisionOn = true;
        //                         }
        //                         if(player == true) {
        //                             index = i;
        //                         }
        //                     }
        //                     break;
        //             }

        //             entity.solidArea.x = entity.solidAreaDefaultX;
        //             entity.solidArea.y = entity.solidAreaDefaultY;
        //             gp.obj[i][j].solidArea.x = gp.obj[i][j].solidAreaDefaultX;
        //             gp.obj[i][j].solidArea.y = gp.obj[i][j].solidAreaDefaultY;
        //         }
        //     }
        // }
        
        return index;
    }

    public int checkEntity(Entity entity, Entity[] target) {
        int index = 999;

        for(int i = 0; i < target.length; i++) {
            if(target[i] != null) {

                // Get Entity's Solid Area
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                // Get Object Solid Area
                target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
                target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)){
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)){
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)){
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)){
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                }

                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
        }
        
        return index;
    }

    public void checkPlayer(Entity entity) {

        // Get Entity's Solid Area
        entity.solidArea.x = entity.worldX + entity.solidArea.x;
        entity.solidArea.y = entity.worldY + entity.solidArea.y;

        // Get Player Solid Area
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;

        switch (entity.direction) {
            case "up":
                entity.solidArea.y -= entity.speed;
                if(entity.solidArea.intersects(gp.player.solidArea)){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entity.solidArea.y += entity.speed;
                if(entity.solidArea.intersects(gp.player.solidArea)){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entity.solidArea.x -= entity.speed;
                if(entity.solidArea.intersects(gp.player.solidArea)){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entity.solidArea.x += entity.speed;
                if(entity.solidArea.intersects(gp.player.solidArea)){
                    entity.collisionOn = true;
                }
                break;
        }

        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
    }
}
