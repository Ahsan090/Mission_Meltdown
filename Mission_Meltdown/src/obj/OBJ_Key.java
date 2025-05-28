package obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Key extends SuperObject {

    public OBJ_Key() {
        name = "Key";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/keyy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 60;
        solidArea.height = 72;
        solidAreaDefaultX = 0;
        solidAreaDefaultY = 0;
    }
}
