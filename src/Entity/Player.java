package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.Sounds;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler KeyH;
	boolean Alive = true;
	boolean OnGround = true;
	boolean neree = true;
	boolean climb = false;
	boolean ayaksesi = true;
	boolean zıplamasesi = true;
	Sounds sound = new Sounds();

	public Player(GamePanel gp, KeyHandler KeyH) {
		this.gp = gp;
		this.KeyH = KeyH;

		setDefaultValue();
		getPlayerImage();
		
		marioSolid = new Rectangle(x, y, 47, 47);
	}

	public void setDefaultValue() {

		x = 1400;
		y = 725;
		playerSpeed_Up = 60;
		playerSpeed_Left = 5; // normal 5
		playerSpeed_Right = 5; // normal 5
		direction = "down";

	}

	public void getPlayerImage() {
		try {
			mariostand = ImageIO.read(getClass().getResourceAsStream("/Mario/marioStand.png"));
			marioclimb_1 = ImageIO.read(getClass().getResourceAsStream("/Mario/Mario_backward_1.png"));
			marioclimb_2 = ImageIO.read(getClass().getResourceAsStream("/Mario/Mario_backward_2.png"));
			marioRight_1 = ImageIO.read(getClass().getResourceAsStream("/Mario/Mario_right.png"));
			marioRight_2 = ImageIO.read(getClass().getResourceAsStream("/Mario/Mario_right_run.png"));
			marioLeft_1 = ImageIO.read(getClass().getResourceAsStream("/Mario/Mario_left.png"));
			marioLeft_2 = ImageIO.read(getClass().getResourceAsStream("/Mario/Mario_left_run.png"));
			marioJump_1 = ImageIO.read(getClass().getResourceAsStream("/Mario/Mario_jumping_1.png"));
			marioJump_2 = ImageIO.read(getClass().getResourceAsStream("/Mario/Mario_jumping_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {

		collision= false;
		gp.c_checker.CheckTile(this);

		if (KeyH.A_pressed == true || KeyH.D_pressed == true || KeyH.W_pressed == true || KeyH.S_pressed == true) {

			if (KeyH.A_pressed == true && x > 0) {
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					public void run() {
						// playSE(1);
					}
				}, 1000);
				ayaksesi = true;
				direction = "left";
				x -= playerSpeed_Left;

				neree = true;
			}

			if (KeyH.D_pressed == true && x < 1450) {
				playSE(1);

				direction = "right";
				x += playerSpeed_Right;
				neree = false;
			}

			// 620

			if (KeyH.S_pressed == true && ((x >= 200 && x <= 270 && y < 725 && y > 595)
					|| (x >= 1200 && x <= 1270 && y < 595 && y > 465) || (x >= 380 && x <= 450 && y < 465 && y > 335)
					|| (x >= 1000 && x <= 1070 && y < 335 && y > 205) || (x >= 330 && x <= 400 && y < 205 && y > 85))) {
				for (int i = 0; i < 3; i++) {

					if ((y < 724 && y > 595) || (y < 594 && y > 465) || (y < 464 && y > 335) || (y < 334 && y > 205)
							|| (y < 204 && y > 85) || (y < 84 && y > 0)) {
						Timer timer = new Timer();
						timer.schedule(new TimerTask() {
							public void run() {
								if (y == 725 || y == 595 || y == 465 || y == 335 || y == 205 || y == 85) {
									y -= 0;
								} else {
									y = y + 1;
								}
							}
						}, 1);

					}

				}

			}

			if (KeyH.W_pressed == true && OnGround) {
				OnGround = false;
				// System.out.println("?");

				if (!((x >= 200 && x <= 270 && y <= 725 && y >= 595) || (x >= 1200 && x <= 1270 && y <= 595 && y >= 465)
						|| (x >= 380 && x <= 450 && y <= 465 && y >= 335)
						|| (x >= 1000 && x <= 1070 && y <= 335 && y >= 205)
						|| (x >= 330 && x <= 400 && y <= 205 && y >= 85))) {
					if (zıplamasesi) {
						playSE(0);
						 System.out.println(y);
					}
				}
				Timer timer = new Timer();
				if ((x >= 200 && x <= 270 && y <= 725 && y >= 595) || (x >= 1200 && x <= 1270 && y <= 595 && y >= 465)
						|| (x >= 380 && x <= 450 && y <= 465 && y >= 335)
						|| (x >= 1000 && x <= 1070 && y <= 335 && y >= 205)
						|| (x >= 330 && x <= 400 && y <= 205 && y >= 85)) {
					timer.schedule(new TimerTask() {
						public void run() {

							y -= 3;

							// System.out.println(y);
						}
					}, 100);

				} else {
					timer.schedule(new TimerTask() {
						public void run() {
							y = y - 30;
						}
					}, 0);
				}

				direction = "up";

			}
				//
			SprintCount++;
			if (SprintCount > 10) {

				if (SprintNum == 1) {
					SprintNum = 2;
				} else if (SprintNum == 2) {
					SprintNum = 1;
				}
				SprintCount = 0;
			}
		}

		for (int i = 0; i < 3; i++) {
			// this values describes the coordinates of our platforms
			if (y == 726 || (y == 595 && x >= 110 && x <= 1500) || (y == 465 && x >= 0 && x <= 1350)
					|| (y == 335 && x >= 110 && x <= 1500) || (y == 205 && x >= 0 && x <= 1350)
					|| (y == 75 && x >= 180 && x <= 570) || (x >= 200 && x <= 270 && y <= 725 && y >= 595)
					|| (x >= 1200 && x <= 1270 && y <= 595 && y >= 465)
					|| (x >= 380 && x <= 450 && y <= 465 && y >= 335)
					|| (x >= 1000 && x <= 1070 && y <= 335 && y >= 205)
					|| (x >= 330 && x <= 400 && y <= 205 && y >= 85)) {
				y += 0;
				//System.out.println("a");
				OnGround = true;
			} else {
				y += 0;
				zıplamasesi = false;

			}
		}

	}

	public void draw(Graphics2D g2) {

		BufferedImage image = null;
		image = marioLeft_1;

		switch (direction) {
		case "up":
			if (neree) {
				image = marioJump_2;

			} else {
				image = marioJump_1;

			}
			break;
		case "left":
			if (y == 725 || (y == 595) || (y == 465) || (y == 335) || (y == 205) || (y == 75)) {
				if (SprintNum == 1) {
					image = marioLeft_1;
				}
				if (SprintNum == 2) {
					image = marioLeft_2;
				}
			} else {
				image = marioJump_2;
			}
			break;
		case "right":
			if (y == 725 || (y == 595) || (y == 465) || (y == 335) || (y == 205) || (y == 75)) {
				if (SprintNum == 1) {
					image = marioRight_1;
				}
				if (SprintNum == 2) {
					image = marioRight_2;
				}
			} else {
				image = marioJump_1;
			}
			break;

		}

		g2.drawImage(image, x, y, gp.TileSize, gp.TileSize, null);
	}

	public void playMusic(int i) {
		sound.setFile(i);
		sound.play();
		sound.loop();
	}

	public void stopMusic() {
		sound.stop();
	}

	public void playSE(int i) {
		sound.setFile(i);
		sound.play();
	}
}