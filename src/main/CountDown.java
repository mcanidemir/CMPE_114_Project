package main;
//asdk
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entity.Player;

public class CountDown {

	GamePanel gp;
	static int Count_Down = 0;
	int direction;
	int CountLoop=0;

	public BufferedImage five,four,three,two,one;

	public CountDown(GamePanel gp) {
		this.gp = gp;

		getDonkeyImage();
	}

	public void getDonkeyImage() {
		try {

			one = ImageIO.read(getClass().getResourceAsStream("/count/CD1.png"));
			two = ImageIO.read(getClass().getResourceAsStream("/count/CD2.png"));
			three = ImageIO.read(getClass().getResourceAsStream("/count/CD3.png"));
			four = ImageIO.read(getClass().getResourceAsStream("/count/CD4.png"));
			five = ImageIO.read(getClass().getResourceAsStream("/count/CD5.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void update() {

		if(CountLoop==0) {
		Count_Down += 1;
		if (Count_Down < 100 && Count_Down >= 0) {
			direction = 4;
		} else if (Count_Down <= 200 && Count_Down >= 100) {
			direction = 3;
		} else if (Count_Down <= 300 && Count_Down >= 200) {
			direction = 2;
		} else if (Count_Down <= 400 && Count_Down >= 300) {
			direction = 1;
		} else if (Count_Down <= 500 && Count_Down >= 400) {
			direction = 0;
		} else {
			Count_Down = 0;
			CountLoop++;
			GamePanel.game = 2;
		}
		}
	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		image = five;

		switch (direction) {
		case 0:
			image = five;
			break;
		case 1:
			image = four;
			break;
		case 2:
			image = three;
			break;
		case 3:
			image = two;
			break;
		case 4:
			image = one;
			break;
		}

		g2.drawImage(image, 0, 0, 1500, 800, null);
	}

}
