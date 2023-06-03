package main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Donkey {

	GamePanel gp;
	int DX = 1600;
	int direction;

	public BufferedImage DonkeyLeft, DonkeyMid, DonkeyRight;

	public Donkey(GamePanel gp) {
		this.gp = gp;

		getDonkeyImage();
	}

	public void getDonkeyImage() {
		try {
			DonkeyLeft = ImageIO.read(getClass().getResourceAsStream("/Donkey_Kong/donkey kong left.png"));
			DonkeyMid = ImageIO.read(getClass().getResourceAsStream("/Donkey_Kong/donkey kong mid.png"));
			DonkeyRight = ImageIO.read(getClass().getResourceAsStream("/Donkey_Kong/donkey kong right.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {

		DX += 1;
		if (DX < 1615 && DX >= 1600) {
			direction = 0;
		} else if (DX <= 1640 && DX >= 1615) {
			direction = 1;
		} else if (DX <= 1655 && DX >= 1640) {
			direction = 0;
		} else if (DX <= 1680 && DX >= 1655) {
			direction = 2;
		} else {
			DX = 1600;
		}
		// System.out.println(DX);
	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		image = DonkeyMid;

		switch (direction) {
		case 0:
			image = DonkeyMid;
			break;
		case 1:
			image = DonkeyLeft;
			break;
		case 2:
			image = DonkeyRight;
			break;
		}

		g2.drawImage(image, 50, 205, gp.TileSize, gp.TileSize, null);
	}

}
