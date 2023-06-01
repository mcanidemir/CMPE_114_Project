package main;

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

	public void update() {

		for (int i = 0; i < 1; i++) {

			if (PY.get(i) == 725 || (PY.get(i) == 595 && PX.get(i) >= 110 && PX.get(i) <= 1500)
					|| (PY.get(i) == 465 && PX.get(i) >= 0 && PX.get(i) <= 1350)
					|| (PY.get(i) == 335 && PX.get(i) >= 110 && PX.get(i) <= 1500)
					|| (PY.get(i) == 205 && PX.get(i) >= 0 && PX.get(i) <= 1350)) {
				ground = true;
			} else {
				ground = false;
			}

			if ((PX.get(i) == 1235 && PY.get(i) == 465) || (PX.get(i) == 1035 && PY.get(i) == 205)
					|| (PX.get(i) == 235 && PY.get(i) == 595) || (PX.get(i) == 415 && PY.get(i) == 335)) {
				ladder = true;
			} else {
				ladder = false;
			}
		}

		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				for (int i = 0; i < 1; i++) {

					if (count < 10) {

						if (ladder) {
							barrelonladder++;
							System.out.println(barrelonladder);

							if (PY.get(i) == 725 || PY.get(i) == 465 || PY.get(i) == 205) {

								PX.set(count, PX.get(count) + 50);

							}

							else if (PY.get(i) == 595 || PY.get(i) == 335) {

								PX.set(count, PX.get(count) - 50);
								if (barrelonladder == 30) {
									PY.set(count, PY.get(count) + 26);
									barrelonladder = 0;

								}
							}
						} else {

							if (ground) {

								if (PY.get(i) == 725 || PY.get(i) == 465 || PY.get(i) == 205) {

									PX.set(count, PX.get(count) + 50);

								}

								else if (PY.get(i) == 595 || PY.get(i) == 335) {

									PX.set(count, PX.get(count) - 50);
								}

								if (PX.get(i) > 1500) {
									PX.set(count, 0);
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
		}, 100);
	}

	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		BufferedImage Image = null;
		Image = A;
		for (int i = 0; i < 1; i++) {
			g2.drawImage(Image, PX.get(i) + 16, PY.get(i) + 16, 32, 32, null);

		}
	}

}
