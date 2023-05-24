package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	GamePanel gp;
	Tile tile[];
	
	public TileManager(GamePanel gp) {
		tile = new Tile [10];
		this.gp=gp;
		
		getTileImage();
		
	}
	
	public void getTileImage() {
		
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Sprite-0003.jpg"));
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Sprite-0004.jpg"));
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Barrels.jpg"));
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Ladder.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		    	g2.drawImage(tile[0].image, 0, 775, 1500, 20, null);
		    	g2.drawImage(tile[0].image, 150, 645, 1350, 20, null);
		    	g2.drawImage(tile[0].image, 150, 385, 1350, 20, null);
		    	g2.drawImage(tile[1].image, 220, 125, 350, 20, null);
		    	g2.drawImage(tile[0].image, 0, 515, 1350, 20, null);
		    	g2.drawImage(tile[0].image, 0, 255, 1350, 20, null);
		    	g2.drawImage(tile[2].image, 0, 145, 80, 110, null);
		    	g2.drawImage(tile[3].image, 220, 665, 80, 110, null);
		    	g2.drawImage(tile[3].image, 1220, 535, 80, 110, null);
		    	g2.drawImage(tile[3].image, 400, 405, 80, 110, null);
		    	g2.drawImage(tile[3].image, 1020, 275, 80, 110, null);
		    	g2.drawImage(tile[3].image, 350, 145, 80, 110, null);

		    	
	}
}
