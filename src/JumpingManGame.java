package b;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JumpingManGame extends JPanel implements KeyListener {

  private static final long serialVersionUID = 1L;
  private static final int WIDTH = 600;
  private static final int HEIGHT = 400;
  private static final int GROUND_HEIGHT = 350;
  private static final int MAN_WIDTH = 40;
  private static final int MAN_HEIGHT = 40;
  private static final int JUMP_HEIGHT = 50;
  private static final int GRAVITY = 5;

  private boolean jumping = false;
  private int jumpCount = 0;
  private int manX = 50;
  private int manY = GROUND_HEIGHT - MAN_HEIGHT;

  public JumpingManGame() {
    JFrame frame = new JFrame("Jumping Man Game");
    frame.addKeyListener(this);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1550, 1200);
    frame.add(this);
    frame.setVisible(true);
  }

  public void paint(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, 1550, 1200);;

    g.setColor(Color.PINK);
    g.fillRect(200, 440, 1350, 25);
    
    g.setColor(Color.PINK);
    g.fillRect(0, 550, 1350, 25);
    
    g.setColor(Color.PINK);
    g.fillRect(0, 770, 1550, 25);
    
    g.setColor(Color.PINK);
    g.fillRect(200, 660, 1350, 25);
    
    g.setColor(Color.PINK);
    g.fillRect(0, 330, WIDTH, 25);
    
    g.setColor(Color.PINK);
    g.fillRect(0, 220, WIDTH, 25);

    g.setColor(Color.WHITE);
    g.fillRect(manX, manY, MAN_WIDTH, MAN_HEIGHT);
  }

  public void update() {
    if (jumping) {
      jumpCount++;
      manY -= GRAVITY;
      if (jumpCount == JUMP_HEIGHT / GRAVITY) {
        jumping = false;
        jumpCount = 0;
      }
    } else if (manY < GROUND_HEIGHT - MAN_HEIGHT) {
      manY += GRAVITY;
    }
    repaint();
  }

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_SPACE && !jumping) {
      jumping = true;
    }
    
  }

  public void keyReleased(KeyEvent e) {}

  public void keyTyped(KeyEvent e) {}

  public static void main(String[] args) throws InterruptedException {
    JumpingManGame game = new JumpingManGame();
    while (true) {
      game.update();
      Thread.sleep(16);
    }
  }
}