package main;
//asdk
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	JLabel label;

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("DONKEY KONG");

		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);

		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);

		gamePanel.StartGameThread();

	}
}
