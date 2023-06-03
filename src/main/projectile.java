package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import Entity.Ladder;

public class projectile {

	GamePanel gp;
	public static boolean ground[] = new boolean[26];
	public static boolean ladder[] = new boolean[26];
	public static ArrayList<Integer> PX = new ArrayList<>();
	public static ArrayList<Integer> PY = new ArrayList<>();
	BufferedImage A;
	int AS = 35;
	int SA = 205;
	static int barrelonladder = 0;
	public static int stair1Y = 725;
	public static int stair2Y = 595;
	public static int stair3Y = 465;
	public static int stair4Y = 335;
	public static int stair5Y = 205;

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

			A = ImageIO.read(getClass().getResourceAsStream("/Donkey_Kong/donkey kong right.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	int count = 0;
	int arrcount = 1;

	public void update() {
		for (int i = 0; i < 1; i++) {

			Ladder L = new Ladder();

			for (int k = 0; k < 26; k++) {

				L.onGround(k);
				L.onLadder(k);

			}

			if (count < 10) {
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
							PY.set(t, PY.get(t) + 8);
							System.out.println(Arrays.toString(ground) + Arrays.toString(ladder));
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
									PX.set(t, 62);
									PY.set(t, 205);
								}
							}
						} else {

							PY.set(t, PY.get(t) + 2);
						}
					}
				}
				count++;
			} else {
				count = 0;
			}
		}
		// System.out.println(PX.get(0) + ", " + PY.get(0));
		// System.out.println(barrelonladder);
	}

	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		BufferedImage Image = null;
		Image = A;

		// g2.setColor(Color.PINK);
		// g2.fillRect(PX.get(i) + 16, PY.get(i) + 16, 50, 10);

		if (PX.get(arrcount - 1) == 314 && PY.get(arrcount - 1) == 205) {
			for (int j = arrcount; j < 26; j++) {
				PX.set(j, 35);
				PY.set(j, 205);
			}
			arrcount++;
		}
		g2.drawImage(Image, PX.get(0) + 16, PY.get(0) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(1) + 16, PY.get(1) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(2) + 16, PY.get(2) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(3) + 16, PY.get(3) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(4) + 16, PY.get(4) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(5) + 16, PY.get(5) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(6) + 16, PY.get(6) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(7) + 16, PY.get(7) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(8) + 16, PY.get(8) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(9) + 16, PY.get(9) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(10) + 16, PY.get(10) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(11) + 16, PY.get(11) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(12) + 16, PY.get(12) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(13) + 16, PY.get(13) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(14) + 16, PY.get(14) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(15) + 16, PY.get(15) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(16) + 16, PY.get(16) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(17) + 16, PY.get(17) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(18) + 16, PY.get(18) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(19) + 16, PY.get(19) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(20) + 16, PY.get(20) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(21) + 16, PY.get(21) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(22) + 16, PY.get(22) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(23) + 16, PY.get(23) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(24) + 16, PY.get(24) + 16, 32, 32, null);
		g2.drawImage(Image, PX.get(25) + 16, PY.get(25) + 16, 32, 32, null);
	}
}
