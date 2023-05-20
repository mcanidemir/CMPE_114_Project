import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

		public boolean W_pressed, A_pressed, D_pressed;
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int input = e.getKeyCode();
		if(input==KeyEvent.VK_W) {
			W_pressed=true;
			}
		
		if(input==KeyEvent.VK_D) {
			D_pressed=true;
			}
		
		if(input==KeyEvent.VK_A) {
			A_pressed=true;
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int input = e.getKeyCode();
		if(input==KeyEvent.VK_W) {
			W_pressed=false;
			}
		
		if(input==KeyEvent.VK_D) {
			D_pressed=false;
			}
		
		if(input==KeyEvent.VK_A) {
			A_pressed=false;
			}
	
	}

}
