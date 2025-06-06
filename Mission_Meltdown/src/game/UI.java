package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.IOException;
// import java.awt.image.BufferedImage;
import java.io.InputStream;

// import obj.OBJ_Key;

public class UI {
    
    GamePanel gp;
    Graphics2D g2;
    Font maruMonica;
    // BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    public int messageCounter = 0;
    public int commandNum = 0;
    public String currentDialogue = "";

    public UI(GamePanel gp) {
        this.gp = gp;

        InputStream is = getClass().getResourceAsStream("/res/font/x12y16pxMaruMonica.ttf");
        try {
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // OBJ_Key key = new OBJ_Key();
        // keyImage = key.image;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        
        this.g2 = g2;
        g2.setFont(maruMonica);
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
        
        if(gp.gameState == gp.titleState) {
            drawTitleScreen();
        } else if(gp.gameState == gp.playState) {
            drawPlayScreen();
        } else if(gp.gameState == gp.pauseState) {
            drawPauseScreen();
        } else if(gp.gameState == gp.dialogueState) {
            drawDialogueScreen();
        }
    }

    public void drawTitleScreen() {
        String text = "Mission Meltdown";
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
        int x = getCenteredTextX(text);
        int y = gp.tileSize * 3;
        
        // Mission Meltdown Text Shadow
        g2.setColor(Color.gray);
        g2.drawString(text, x + 2, y + 2);

        // Mission Meltdown Text
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        // Player Image
        x = gp.screenWidth/2;
        y += gp.tileSize * 2;
        g2.drawImage(gp.player.down2, x - gp.tileSize * 6, y - gp.tileSize, gp.characterWidth*4, gp.characterHeight*4, null);

        // Menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));

        text = "START";
        x = getCenteredTextX(text) + gp.tileSize * 2;
        y += gp.tileSize * 2;
        g2.drawString(text, x, y);
        if(commandNum == 0) {
            g2.drawString(">", x - gp.tileSize, y);
        }

        text = "SETTINGS";
        x = getCenteredTextX(text) + gp.tileSize * 2;
        y += gp.tileSize * 1;
        g2.drawString(text, x, y);
        if(commandNum == 1) {
            g2.drawString(">", x - gp.tileSize, y);
        }

        text = "QUIT";
        x = getCenteredTextX(text) + gp.tileSize * 2;
        y += gp.tileSize * 1;
        g2.drawString(text, x, y);
        if(commandNum == 2) {
            g2.drawString(">", x - gp.tileSize, y);
        }
    }
    
    public void drawPlayScreen() {
        g2.setColor(Color.black);
        g2.drawString("Player Col: " + gp.player.worldX/60.0 + " Player Row: " + gp.player.worldY/60.0, 50, 60);
    }

    public void drawPauseScreen() {
        String text = "PAUSE";
        int x = getCenteredTextX(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }

    public void drawDialogueScreen() {
        // Dialogue Box
        int x = gp.tileSize * 3;
        int y = gp.tileSize * 8;
        int width = gp.screenWidth - (gp.tileSize * 6);
        int height = gp.tileSize * 2 + gp.tileSize/2;

        drawDialogueBox(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 28));
        x += gp.tileSize/2;
        y += gp.tileSize - 10;

        for(String line: currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }
    }

    public void drawDialogueBox(int x, int y, int width, int height) {
        Color c = new Color(0, 0, 0, 210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public int getCenteredTextX(String text) {

        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
