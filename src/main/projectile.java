package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

public class projectile {

	GamePanel gp;
	boolean ground = false;
	boolean ladder = false;
	ArrayList<Integer> PX = new ArrayList<>();
	ArrayList<Integer> PY = new ArrayList<>();
	BufferedImage A;
	int AS = 35;
	int SA = 205;
	int barrelonladder = 0;
	int stair1Y = 725;
	int stair2Y = 595;
	int stair3Y = 465;
	int stair4Y = 335;
	int stair5Y = 205;

	public projectile(GamePanel gp) {
		this.gp = gp;
		setDefaultValue();
		getPlayerImage();
	}

	public void setDefaultValue() {
		for (int i = 0; i < 10; i++) {
			PX.add(AS);
			// AS += 50;
		}

		for (int i = 0; i < 10; i++) {
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
	int arrcount = 0;

	public void update() {
		if (arrcount <= 9) {
			if (PX.get(arrcount) == 535) {
				PX.set(arrcount, PX.get(arrcount) + 50);
				arrcount++;
			}
		}
		for (int i = 0; i < 1; i++) {

			if (PY.get(i) == stair1Y || (PY.get(i) == stair2Y && PX.get(i) >= 110 && PX.get(i) <= 1500)
					|| (PY.get(i) == stair3Y && PX.get(i) >= 0 && PX.get(i) <= 1350)
					|| (PY.get(i) == stair4Y && PX.get(i) >= 110 && PX.get(i) <= 1500)
					|| (PY.get(i) == stair5Y && PX.get(i) >= 0 && PX.get(i) <= 1350)) {
				ground = true;
			} else {
				ground = false;
			}

			if ((PX.get(i) == 1235 && PY.get(i) == stair3Y) || (PX.get(i) == 1035 && PY.get(i) == stair5Y)
					|| (PX.get(i) == 235 && PY.get(i) == stair2Y) || (PX.get(i) == 435 && PY.get(i) == stair4Y)) {
				ladder = true;
			} else {
				ladder = false;
			}

			for (int j = 0; j < 1; j++) {

				if (count < 10) {

					if (ladder) {
						barrelonladder++;
						//System.out.println(barrelonladder);

						if (PY.get(j) == 725 || PY.get(j) == 465 || PY.get(j) == 205) {
							PX.set(count, PX.get(count) + 50);

						}

						else if (PY.get(j) == 595 || PY.get(j) == stair4Y) {
							PX.set(count, PX.get(count) - 50);

						}
						if (barrelonladder == 30) {
							PY.set(count, PY.get(count) + 26);
							barrelonladder = 0;
						}
					} else {

						if (ground) {

							if (PY.get(j) == 725 || PY.get(j) == 465 || PY.get(j) == 205) {

								PX.set(count, PX.get(count) + 50);

							}

							else if (PY.get(j) == 595 || PY.get(j) == 335) {

								PX.set(count, PX.get(count) - 50);
							}

							if (PX.get(j) > 1500) {
								PX.set(count, 35);
								PY.set(count, 205);
							}
						} else {

							PY.set(count, PY.get(count) + 26);
						}
					}
					count++;
				} else {
					count = 0;
				}

			}
		}
		// System.out.println(PX.get(0));
	}

	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		BufferedImage Image = null;
		 Image = A;
		for (int i = 0; i < 10; i++) {
			//g2.setColor(Color.PINK);
			//g2.fillRect(PX.get(i) + 16, PY.get(i) + 16, 50, 10);
			 g2.drawImage(Image, PX.get(i) + 16, PY.get(i) + 16, 32, 32, null);

		}
	}

}
