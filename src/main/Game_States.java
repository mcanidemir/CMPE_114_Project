package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entity.Player;

import java.awt.Graphics;

public class Game_States {
	BufferedImage image = null;
	BufferedImage e1, e2, e3, e4;
	int direction;

	public void gameStart(Graphics g2) {
		try {
			e1 = ImageIO.read(getClass().getResourceAsStream("/others/Acılıs Ekranı1.png"));
			e2 = ImageIO.read(getClass().getResourceAsStream("/others/Acılıs Ekranı2.png"));
			e3 = ImageIO.read(getClass().getResourceAsStream("/others/Acılıs Ekranı3.png"));
			e4 = ImageIO.read(getClass().getResourceAsStream("/others/Acılıs Ekranı4.png"));
		} catch (IOException el) {
			el.printStackTrace();
		}
		image = e1;
		switch (direction) {
		case 0:
			image = e1;
			break;
		case 1:
			image = e2;
			break;
		case 2:
			image = e3;
			break;
		case 3:
			image = e4;
			break;
		}
		g2.drawImage(image, 0, 0, 1500, 800, null);
	}

	public void gameEnd(Graphics g2) {
		try {
			e1 = ImageIO.read(getClass().getResourceAsStream("/others/You_Win.png"));
			e2 = ImageIO.read(getClass().getResourceAsStream("/others/You_Win.png"));
			e3 = ImageIO.read(getClass().getResourceAsStream("/others/You_Win.png"));
			e4 = ImageIO.read(getClass().getResourceAsStream("/others/You_Win.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		image = e1;
		switch (direction) {
		case 0:
			image = e1;
			break;
		case 1:
			image = e2;
			break;
		case 2:
			image = e3;
			break;
		case 3:
			image = e4;
			break;
		}
		g2.drawImage(image, 0, 0, 1500, 800, null);
		Player.x = 1400;
		Player.y = 725;
		for (int i = 0; i < 26; i++) {
			projectile.PX.set(i, 35);
			projectile.PY.set(i, 205);
		}
		projectile.barrelonladder = 0;
	}

	int G = 0;
	public void update() {
		if (G < 25 && G >= 0) {
			direction = 0;
		} else if (G <= 50 && G >= 25) {
			direction = 1;
		} else if (G <= 75 && G >= 50) {
			direction = 2;
		} else if (G <= 100 && G >= 75) {
			direction = 3;
		} else {
			G = 0;
		}
		G++;
		System.out.println(G);
	}

	public void isLost(Graphics g2) {
		try {
			e1 = ImageIO.read(getClass().getResourceAsStream("/others/You-Lose1.png"));
			e2 = ImageIO.read(getClass().getResourceAsStream("/others/You-Lose2.png"));
			e3 = ImageIO.read(getClass().getResourceAsStream("/others/You-Lose3.png"));
			e4 = ImageIO.read(getClass().getResourceAsStream("/others/You-Lose4.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		image = e1;
		switch (direction) {
		case 0:
			image = e1;
			break;
		case 1:
			image = e2;
			break;
		case 2:
			image = e3;
			break;
		case 3:
			image = e4;
			break;
		}
		g2.drawImage(image, 0, 0, 1500, 800, null);
		Player.x = 1400;
		Player.y = 725;
		for (int i = 0; i < 26; i++) {
			projectile.PX.set(i, 35);
			projectile.PY.set(i, 205);
		}
		projectile.barrelonladder = 0;
	}
}
