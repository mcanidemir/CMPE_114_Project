package main;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Entity.Player;
import tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements Runnable {

	final int originalTileSize = 16;
	final int scale = 3;
	public static int game = 0;
	int mc = 0;

	public final int TileSize = originalTileSize * scale;
	final int ScreenWidth = 1500;
	final int ScreenHeight = 800;

	int FPS = 60;

	Collusion Col = new Collusion();
	TileManager TileM = new TileManager(this);
	KeyHandler KeyH = new KeyHandler();
	Game_States GameState = new Game_States();
	Player player = new Player(this, KeyH);
	projectile projectile = new projectile(this);
	Donkey donkey = new Donkey(this);
	Background background = new Background(this);
	Sounds sound = new Sounds();

	Thread gameThread;
	JLabel label;

	public GamePanel() {

		this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
		this.setDoubleBuffered(true);
		this.addKeyListener(KeyH);
		this.setFocusable(true);

	}

	public void StartGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		long Current_Time;
		double draw_Interval = 1000000000 / FPS;
		double delta = 0;
		long Last_Time = System.nanoTime();

		while (gameThread != null) {

			Current_Time = System.nanoTime();

			delta += (Current_Time - Last_Time) / draw_Interval;

			Last_Time = Current_Time;

			if (delta >= 1) {
				update();
				repaint();
				delta--;
			}

		}
	}

	public void update() {
		// game = 0 oyun başı, game = 1 oyun kazanılınca, game = 2 oyun esnasında, game
		// = 3 oyun kaybedilince

		GameState.update();

		if (game == 2) {

			if (Player.x <= 250 && Player.x >= 220 && Player.y == 75) {

				game = 1;
				if (mc == 0) {
					playSE(2);
					mc++;
				}
			}

			else {
				background.update();
				donkey.update();
				player.update();
				projectile.update();
				Col.MonkeyTouched();

			}

		} else {
			MouseHandler m = new MouseHandler();
			label = new JLabel();
			label.setBounds(0, 0, 1500, 800);
			label.addMouseListener(m);
			this.add(label);
		}

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		// player x1400 y700
		background.draw(g2);
		TileM.draw(g2);
		donkey.draw(g2);
		player.draw(g2);
		projectile.draw(g2);

		if (game == 1) {

			GameState.gameEnd(g2);

		}

		if (game == 0) {

			GameState.gameStart(g2);

		}

		if (game == 3) {

			GameState.isLost(g2);
			if (mc == 0) {
				playSE(1);
				mc++;
			}
		}

		g2.dispose();
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
