package Entity;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler KeyH; 
    boolean OnGround=true;
    boolean neree=true;

    public Player(GamePanel gp,KeyHandler KeyH) {
        this.gp=gp;
        this.KeyH=KeyH;

        setDefaultValue();
        getPlayerImage();
    }

    public void setDefaultValue() {

        x = 1400;
        y = 725;
        playerSpeed_Up = 60;
        playerSpeed_Left = 5;
        playerSpeed_Right = 5;
        direction="down";

    }

    public void getPlayerImage() {
        try {
        mariostand= ImageIO.read(getClass().getResourceAsStream("/Mario/marioStand.png"));
        marioclimb_1= ImageIO.read(getClass().getResourceAsStream("/Mario/Mario_backward_1.png"));
        marioclimb_2= ImageIO.read(getClass().getResourceAsStream("/Mario/Mario_backward_2.png"));
        marioRight_1= ImageIO.read(getClass().getResourceAsStream("/Mario/Mario_right.png"));
        marioRight_2= ImageIO.read(getClass().getResourceAsStream("/Mario/Mario_right_run.png"));
        marioLeft_1= ImageIO.read(getClass().getResourceAsStream("/Mario/Mario_left.png"));
        marioLeft_2= ImageIO.read(getClass().getResourceAsStream("/Mario/Mario_left_run.png"));
        marioJump_1= ImageIO.read(getClass().getResourceAsStream("/Mario/Mario_jumping_1.png"));
        marioJump_2= ImageIO.read(getClass().getResourceAsStream("/Mario/Mario_jumping_2.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
    	
    	if(KeyH.A_pressed==true || KeyH.D_pressed==true || KeyH.W_pressed==true) {
    	
        if(KeyH.A_pressed==true && x > 0) {
            direction = "left";
            x -= playerSpeed_Left;
            
            neree=true;
        }

        if(KeyH.D_pressed==true && x < 1450) {
            direction = "right";
            x += playerSpeed_Right;
            neree=false;
        }

        if(KeyH.W_pressed==true && OnGround) {
        	if((x >= 200 && x <= 270 && y == 725)||
        			(x >= 1200 && x <= 1270 && y == 595)||
        			(x >= 380 && x <= 450 && y == 465)||
        			(x >= 1000 && x <= 1070 && y == 335)||
        	  		(x >= 330 && x <= 400 && y == 205)) {
        		for (int i = 0; i < 130; i++) {

        			playerSpeed_Up=1;					
        			y -= playerSpeed_Up;
        			
				}

    		}
    		else {
    			try {
                    for (int i = 0; i< 60 ; i++) {
 
                        playerSpeed_Up = 1;
                        y -= playerSpeed_Up;
                        Thread.sleep(1/10);
                    }
                }catch(Exception e) {

                }
    		}
        	
            direction = "up";
            OnGround=false;
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
    	for (int i = 0; i < 3; i++) {
			
    		if(y == 725 || (y == 595 && x >= 110 && x <= 1500) ||
    				(y == 465 && x >= 0 && x <= 1350) ||
    				(y == 335 && x >= 110 && x <= 1500) ||
    				(y == 205 && x >= 0 && x <= 1350) ||
    				(y == 75 && x >= 180&& x <= 570)) {
    			y += 0; 
    			OnGround=true;
    		}
    		else {
    			y+=1;
    			
    		}
		}
    	
    	
    }

    public void draw(Graphics2D g2) {

            BufferedImage image = null;
            image=marioLeft_1;

            switch(direction) {
            case "up":
            	if(neree) {
            		image=marioJump_2;
            		
            	}
            	else {
            		image=marioJump_1;
            		
            	}
                break;
            case "left":
            	if(y == 725 || (y == 595 ) ||(y == 465) ||(y == 335) ||(y == 205) ||(y == 75)) {
                if(SprintNum==1) {
                    image=marioLeft_1;
                }
                if(SprintNum==2) {
                    image=marioLeft_2;
                }
            	}
            	else {
            		image=marioJump_2;
            	}
                break;
            case "right":
            	if(y == 725 || (y == 595 ) ||(y == 465) ||(y == 335) ||(y == 205) ||(y == 75)) {
            	if(SprintNum==1) {
                    image=marioRight_1;
                }
                if(SprintNum==2) {
                    image=marioRight_2;
            	}
            	}
            	else {
            		image=marioJump_1;
            	}
                break;

            }

                g2.drawImage(image, x, y, gp.TileSize, gp.TileSize, null);
    }
}