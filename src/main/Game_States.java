package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entity.Player;

import java.awt.Graphics;

public class Game_States {
	BufferedImage e = null;

	public void gameStart(Graphics g2) {
		try {
			e = ImageIO.read(getClass().getResourceAsStream("/others/a.jpg"));
		} catch (IOException el) {
			el.printStackTrace();
		}
		g2.drawImage(e, 0, 0, 1500, 800, null);
	}

	public void gameEnd(Graphics g2) {
		try {
			e = ImageIO.read(getClass().getResourceAsStream("/others/e.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		g2.drawImage(e, 0, 0, 1500, 800, null);
		Player.x = 1400;
		Player.y = 725;
		for (int i = 0; i < 26; i++) {
			projectile.PX.set(i, 35);
			projectile.PY.set(i, 205);
		}
		projectile.barrelonladder = 0;
	}

	public void isLost(Graphics g2) {
		try {
			e = ImageIO.read(getClass().getResourceAsStream("/others/k.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		g2.drawImage(e, 0, 0, 1500, 800, null);
		Player.x = 1400;
		Player.y = 725;
		for (int i = 0; i < 26; i++) {
			projectile.PX.set(i, 35);
			projectile.PY.set(i, 205);
		}
		projectile.barrelonladder = 0;
	}
	public void countDown(Graphics g2) {
		
	}
}
