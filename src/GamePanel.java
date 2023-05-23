import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable{

		final int originalTileSize = 16;
		final int scale = 3;
		
		final int TileSize = originalTileSize * scale;
		final int MaxScreenCol = 16;
		final int MaxScreenRow = 12;		
		final int ScreenWidth = 1500;
		final int ScreenHeight = 800;
		

		
		
		int FPS=60;
		
		KeyHandler KeyH= new KeyHandler();
		Thread gameThread;
		
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
			if(KeyH.A_pressed==true && playerX > 10) {
				playerX -= playerSpeed_Left;
			}
		
			if(KeyH.D_pressed==true && playerX < 1445) {
				playerX += playerSpeed_Right;
			}
			
			if(KeyH.W_pressed==true) {
				playerY -= playerSpeed_Up;
			}
		
			if(playerY == 725 || (playerY == 595 && playerX >= 110 && playerX <= 1500) ||
			         (playerY == 465 && playerX >= 0 && playerX <= 1350) ||
			         (playerY == 335 && playerX >= 110 && playerX <= 1500) ||
			         (playerY == 205 && playerX >= 0 && playerX <= 1350) ||
			         (playerY == 75 && playerX >= 180&& playerX <= 570)) {
				 playerY += 0;

			 }
			else {
				playerY+=5;
			}
			
	}
		
		public void paintComponent(Graphics g) {
		    
			super.paintComponent(g);
			
			Graphics2D g2 = (Graphics2D)g;
	
		    //player x1400 y700
		    g2.setColor(Color.red);		    
		    g2.fillRect(0, 255, 1350, 20);		 		    
		    g2.fillRect(0, 775, 1500, 20);		        
		    g2.fillRect(0, 515, 1350, 20);		    	    
		    g2.fillRect(150, 645, 1350, 20);		    	    
		    g2.fillRect(150, 385, 1350, 20);		    	    
		    g2.fillRect(220, 125, 350, 20);
		    
		    g2.setColor(Color.blue);		    
		    g2.fillRect(220, 665, 80, 110);
		    g2.fillRect(1220, 535, 80, 110);
		    g2.fillRect(400, 405, 80, 110);
		    g2.fillRect(1020, 275, 80, 110);
		    g2.fillRect(350, 145, 80, 110);		    
		    
		    g2.setColor(Color.MAGENTA);		    
		    g2.fillRect(520, 55, 50, 70);
		    g2.fillRect(80, 145, 110, 110);
		    
		    g2.setColor(Color.GREEN);
		    g2.fillRect(0, 145, 80, 110);
		    
		    g2.setColor(Color.white);		    
		    g2.fillRect(playerX, playerY, TileSize, TileSize);
		    
		    g2.dispose();		  
	}
		
	
		
}
