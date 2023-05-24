package Entity;
import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler KeyH; 

	
	
	public Player(GamePanel gp,KeyHandler KeyH) {
		this.gp=gp;
		this.KeyH=KeyH;
		
		setDefaultValue();
	}
	
	public void setDefaultValue() {
		
		x = 1400;
		y = 700;
		playerSpeed_Up = 20;
		playerSpeed_Left = 10;
		playerSpeed_Right = 10;
		
	}
	
	public void update() {
		if(KeyH.A_pressed==true && x > 10) {
			x -= playerSpeed_Left;
		}
	
		if(KeyH.D_pressed==true && x < 1445) {
			x += playerSpeed_Right;
		}
		
		if(KeyH.W_pressed==true) {
			y -= playerSpeed_Up;
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
		 g2.setColor(Color.white);		    
		    g2.fillRect(x, y, gp.TileSize, gp.TileSize);
	}
}
