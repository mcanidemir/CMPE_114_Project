package main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {

	GamePanel gp;
	int BX = 1600;
	int direction;

	public BufferedImage B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18;

	public Background(GamePanel gp) {
		this.gp = gp;

		getbackImage();
	}

	public void getbackImage() {
		try {
			B1 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan1.png"));
			B2 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan2.png"));
			B3 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan3.png"));
			B4 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan4.png"));
			B5 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan5.png"));
			B6 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan6.png"));
			B7 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan7.png"));
			B8 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan8.png"));
			B9 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan9.png"));
			B10 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan10.png"));
			B11 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan11.png"));
			B12 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan12.png"));
			B13 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan13.png"));
			B14 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan14.png"));
			B15 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan15.png"));
			B16 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan16.png"));
			B17 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan17.png"));
			B18 = ImageIO.read(getClass().getResourceAsStream("/back/Şamdan18.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {

		BX += 1;
		if (BX < 1630 && BX >= 1600) {
			direction = 0;
		} else if (BX <= 1660 && BX >= 1630) {
			direction = 1;
		} else if (BX <= 1690 && BX >= 1660) {
			direction = 2;
		} else if (BX <= 1720 && BX >= 1690) {
			direction = 3;
		} else if (BX <= 1750 && BX >= 1720) {
			direction = 4;
		} else if (BX <= 1780 && BX >= 1750) {
			direction = 5;
		} else if (BX <= 1810 && BX >= 1780) {
			direction = 6;
		} else if (BX <= 1840 && BX >= 1810) {
			direction = 7;
		} else if (BX <= 1870 && BX >= 1840) {
			direction = 8;
		} else if (BX <= 1900 && BX >= 1870) {
			direction = 9;
		} else if (BX <= 1930 && BX >= 1900) {
			direction = 10;
		} else if (BX <= 1960 && BX >= 1930) {
			direction = 11;
		} else if (BX <= 1990 && BX >= 1960) {
			direction = 12;
		} else if (BX <= 2020 && BX >= 1990) {
			direction = 13;
		} else if (BX <= 2050 && BX >= 2020) {
			direction = 14;
		} else if (BX <= 2080 && BX >= 2050) {
			direction = 15;
		} else if (BX <= 2110 && BX >= 2080) {
			direction = 16;
		} else if (BX <= 2140 && BX >= 2110) {
			direction = 17;
		} else {
			BX = 1600;
		}

	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		image = B1;

		switch (direction) {
		case 0:
			image = B1;
			break;
		case 1:
			image = B2;
			break;
		case 2:
			image = B3;
			break;
		case 3:
			image = B4;
			break;
		case 4:
			image = B5;
			break;
		case 5:
			image = B6;
			break;
		case 6:
			image = B7;
			break;
		case 7:
			image = B8;
			break;
		case 8:
			image = B9;
			break;
		case 9:
			image = B10;
			break;
		case 10:
			image = B11;
			break;
		case 11:
			image = B12;
			break;
		case 12:
			image = B13;
			break;
		case 13:
			image = B14;
			break;
		case 14:
			image = B15;
			break;
		case 15:
			image = B16;
			break;
		case 16:
			image = B17;
			break;
		case 17:
			image = B18;
			break;
		}

		g2.drawImage(image, 0, 0, 1500, 800, null);
	}

}
