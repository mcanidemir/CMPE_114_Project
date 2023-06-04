package main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entity.Player;

public class Donkey {

	GamePanel gp;
	int DX = 1600;
	int direction;

	public BufferedImage DonkeyLeft, DonkeyMid, DonkeyRight, DonkeyMidAngry;

	public Donkey(GamePanel gp) {
		this.gp = gp;

		getDonkeyImage();
	}

	public void getDonkeyImage() {
		try {
			DonkeyLeft = ImageIO.read(getClass().getResourceAsStream("/Donkey_Kong/prenses_7.png"));
			DonkeyMid = ImageIO.read(getClass().getResourceAsStream("/Donkey_Kong/prenses_12.png"));
			DonkeyMidAngry = ImageIO.read(getClass().getResourceAsStream("/Donkey_Kong/prenses_9.png"));
			DonkeyRight = ImageIO.read(getClass().getResourceAsStream("/Donkey_Kong/prenses_8.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {

		DX += 1;
		if (DX < 30 && DX >= 0) {
			direction = 2;
		} else if (DX <= 55 && DX >= 30) {
			direction = 0;
		} else if (DX <= 75 && DX >= 55) {
			direction = 1;
		} else if (DX <= 95 && DX >= 75) {
			direction = 0;
		} else {
			DX = 0;
		}
		// 19*5 6 5 4 4
	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		image = DonkeyLeft;

		switch (direction) {
		case 0:
			if (Player.y <= 465) {
				System.out.println(Player.y);
				image = DonkeyMidAngry;
			} else {
				image = DonkeyMid;
			}
			break;
		case 1:
			image = DonkeyLeft;
			break;
		case 2:
			image = DonkeyRight;
			break;
		}

		g2.drawImage(image, 40, 183, 70, 70, null);
	}

}
