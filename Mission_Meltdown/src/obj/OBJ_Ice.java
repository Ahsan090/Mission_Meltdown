package obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Ice extends SuperObject {

    public OBJ_Ice() {
        name = "Ice";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/ice block.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        solidArea.x = 0;
        solidArea.y = 12;
        solidArea.width = 60;
        solidArea.height = 60;
        solidAreaDefaultX = 0;
        solidAreaDefaultY = 12;
        collision = true;
    }
    
}
