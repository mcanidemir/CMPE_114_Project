package Entity;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler KeyH; 



    public Player(GamePanel gp,KeyHandler KeyH) {
        this.gp=gp;
        this.KeyH=KeyH;

        setDefaultValue();
        getPlayerImage();
    }

    public void setDefaultValue() {

        x = 1400;
        y = 700;
        playerSpeed_Up = 20;
        playerSpeed_Left = 10;
        playerSpeed_Right = 10;
        direction="down";

    }

    public void getPlayerImage() {
        try {
        mariostand= ImageIO.read(getClass().getResourceAsStream("/Mario/marioStand.png"));
        marioRight_1= ImageIO.read(getClass().getResourceAsStream("/Mario/marioRight.png"));
        marioLeft_1= ImageIO.read(getClass().getResourceAsStream("/Mario/marioRun1.png"));
        marioLeft_2= ImageIO.read(getClass().getResourceAsStream("/Mario/marioRun2.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
    	
    	if(KeyH.A_pressed==true || KeyH.D_pressed==true || KeyH.W_pressed==true) {
    	
        if(KeyH.A_pressed==true && x > 0) {
            direction = "left";
            x -= playerSpeed_Left;
        }

        if(KeyH.D_pressed==true && x < 1450) {
            direction = "right";
            x += playerSpeed_Right;
        }

        if(KeyH.W_pressed==true) {
            direction = "up";
            y -= playerSpeed_Up;
        }

        SprintCount++;
        if(SprintCount > 10) {

            if(SprintNum==1) {
                SprintNum=2;
            }
        else if(SprintNum==2) {
            SprintNum=1;
        }
            SprintCount=0;
        }
    	}
    	if(y == 725 || (y == 595 && x >= 110 && x <= 1500) ||
    			(y == 465 && x >= 0 && x <= 1350) ||
    			(y == 335 && x >= 110 && x <= 1500) ||
    			(y == 205 && x >= 0 && x <= 1350) ||
    			(y == 75 && x >= 180&& x <= 570)) {
    		y += 0;
    	}
    	else {
    		y+=5;
    	}
    }

    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);
         //   g2.fillRect(x, y, gp.TileSize, gp.TileSize);

            BufferedImage image = null;
            image=mariostand;

            switch(direction) {
            case "up":
                image=mariostand;
                break;
            case "left":
                if(SprintNum==1) {
                    image=marioLeft_1;
                }
                if(SprintNum==2) {
                    image=marioLeft_2;
                }
                break;
            case "right":
                image=marioRight_1;
                break;
                default:
                    image=mariostand;
            }

                g2.drawImage(image, x, y, gp.TileSize, gp.TileSize, null);
    }
}