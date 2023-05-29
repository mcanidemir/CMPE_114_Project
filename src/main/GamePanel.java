package main;
import javax.swing.JPanel;

import Entity.Player;
import tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable{

		final int originalTileSize = 16;
		final int scale = 3;
		
		public final int TileSize = originalTileSize * scale;
		final int MaxScreenCol = 16;
		final int MaxScreenRow = 12;		
		final int ScreenWidth = 1500;
		final int ScreenHeight = 800;
		

		
		
		int FPS=60;
		
		TileManager TileM = new TileManager(this);
		KeyHandler KeyH= new KeyHandler();
		Thread gameThread;
		Player player = new Player(this, KeyH);
		Sounds sound= new Sounds();
		
		int playerX=1400;
		int playerY=700;
		int playerSpeed_Left=15;
		int playerSpeed_Right=15;
		int playerSpeed_Up=20;
		
		public GamePanel() {
			
			this.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight));
			this.setBackground(Color.black);
			this.setDoubleBuffered(true);
			this.addKeyListener(KeyH);
			this.setFocusable(true);
			
		}
		public void StartGameThread() {
			gameThread= new Thread(this);
			gameThread.start();
		}
		@Override
		public void run() {
			long Current_Time;
			double draw_Interval = 1000000000/FPS;
			double delta=0;
			long Last_Time=System.nanoTime();
			
		while(gameThread != null) {
			
			Current_Time=System.nanoTime();
			
			delta += (Current_Time - Last_Time) / draw_Interval;
			
			Last_Time = Current_Time; 
			
			if(delta>=1) {
				update();
				repaint();
				delta--;
			}
			
			
		}			
	}
		
		public void update() {
			
			
			player.update();
			
			
	}
		
		public void paintComponent(Graphics g) {
		    
			super.paintComponent(g);
			
			Graphics2D g2 = (Graphics2D)g;
			

	
		    //player x1400 y700
    
		    
		    g2.setColor(Color.MAGENTA);		    
		    g2.fillRect(520, 55, 50, 70);
		    g2.fillRect(80, 145, 110, 110);
		    


			TileM.draw(g2);
		    
		    player.draw(g2);
		   
		    
		    g2.dispose();		  
	}
		
		public void playMusic(int i) {
	        sound.setFile(i);
	        sound.play();
	        sound.loop();
	    }
	    public void stopMusic(){
	        sound.stop();
	    }
	    public void playSE(int i) {
	    sound.setFile(i);
	    sound.play();
	    }
		
}
