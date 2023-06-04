package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;

import Entity.Ladder;

public class projectile {

	GamePanel gp;
	public static boolean ground[] = new boolean[26];
	public static boolean ladder[] = new boolean[26];
	public static ArrayList<Integer> PX = new ArrayList<>();
	public static ArrayList<Integer> PY = new ArrayList<>();
	BufferedImage barrel1, barrel2, barrel3, barrel4;
	int AS = 32;
	int SA = 205;
	static int barrelonladder = 0;
	public static int stair1Y = 725;
	public static int stair2Y = 595;
	public static int stair3Y = 465;
	public static int stair4Y = 335;
	public static int stair5Y = 205;
	int BarrelCount=0;
	int BarrelNum=1;

	public projectile(GamePanel gp) {
		this.gp = gp;
		setDefaultValue();
		getPlayerImage();
	}

	public void setDefaultValue() {
		for (int i = 0; i < 100; i++) {
			PX.add(AS);
			// AS += 50;
		}

		for (int i = 0; i < 100; i++) {
			PY.add(SA);
			// SA += 50;
		}
	}

	public void getPlayerImage() {
		try {

			barrel3 = ImageIO.read(getClass().getResourceAsStream("/barrels/barrel_3.png"));
			barrel4 = ImageIO.read(getClass().getResourceAsStream("/barrels/barrel_4.png"));
			barrel1 = ImageIO.read(getClass().getResourceAsStream("/barrels/barrel_5.png"));
			barrel2 = ImageIO.read(getClass().getResourceAsStream("/barrels/barrel_6.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static int arrcount = 1;

	public void update() {

		Ladder L = new Ladder();

		for (int k = 0; k < 26; k++) {
			L.onGround(k);
			L.onLadder(k);

		}


			for (int t = 0; t < 26; t++) {

				if (ladder[t]) {
					barrelonladder++;
					// System.out.println(barrelonladder);

					if (PY.get(t) == 725 || PY.get(t) == 465 || PY.get(t) == 205) {
						PX.set(t, PX.get(t) + 3);

					}

					else if (PY.get(t) == 595 || PY.get(t) == stair4Y) {
						PX.set(t, PX.get(t) - 3);

					}
					if (barrelonladder == 17) {
						PY.set(t, PY.get(t) + 2);
						// System.out.println(Arrays.toString(ground) + Arrays.toString(ladder));
						barrelonladder = 0;
					}

				} else {

					if (ground[t]) {

						if (PY.get(t) == 725 || PY.get(t) == 465 || PY.get(t) == 205) {

							PX.set(t, PX.get(t) + 3);

						}

						else if (PY.get(t) == 595 || PY.get(t) == 335) {

							PX.set(t, PX.get(t) - 3);
						}
						for (int j = 0; j < 26; j++) {

							if (PX.get(j) > 1500) {
								PX.set(t, 35);
								PY.set(t, 205);
							}
						}
					} else {

						PY.set(t, PY.get(t) + 2);
					}
				}
			}
			BarrelCount++;
			//System.out.println(BarrelCount);
			if (BarrelCount > 10) {

				if (BarrelNum == 1) {
					BarrelNum = 2;
				} else if (BarrelNum == 2) {
					BarrelNum = 1;
				}
				BarrelCount = 0;
			}

		// System.out.println(PX.get(0) + ", " + PY.get(0));
		// System.out.println(barrelonladder);
	}

	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		BufferedImage Image = null;
		Image = barrel1;
		switch (BarrelNum) {
		case 1:
			Image=barrel1;
			break;
		case 2:
			Image=barrel2;
			break;
		}
		if (PX.get(arrcount - 1) == 323 && PY.get(arrcount - 1) == 205) {
			for (int j = arrcount; j < 26; j++) {
				PX.set(j, 35);
				PY.set(j, 205);
			}
			arrcount++;
		}
		g2.drawImage(Image, PX.get(0) + 16, PY.get(0) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(1) + 16, PY.get(1) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(2) + 16, PY.get(2) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(3) + 16, PY.get(3) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(4) + 16, PY.get(4) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(5) + 16, PY.get(5) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(6) + 16, PY.get(6) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(7) + 16, PY.get(7) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(8) + 16, PY.get(8) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(9) + 16, PY.get(9) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(10) + 16, PY.get(10) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(11) + 16, PY.get(11) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(12) + 16, PY.get(12) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(13) + 16, PY.get(13) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(14) + 16, PY.get(14) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(15) + 16, PY.get(15) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(16) + 16, PY.get(16) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(17) + 16, PY.get(17) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(18) + 16, PY.get(18) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(19) + 16, PY.get(19) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(20) + 16, PY.get(20) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(21) + 16, PY.get(21) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(22) + 16, PY.get(22) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(23) + 16, PY.get(23) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(24) + 16, PY.get(24) + 16, 48, 48, null);
		g2.drawImage(Image, PX.get(25) + 16, PY.get(25) + 16, 48, 48, null);
	}
}
