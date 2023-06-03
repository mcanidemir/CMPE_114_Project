package main;

import Entity.Player;

public class Collusion {

	public void MonkeyTouched() {
		for (int i = 0; i<26 ; i++) {
			if (Player.x <= projectile.PX.get(i)+10 && Player.x >= projectile.PX.get(i)-10 && Player.y == projectile.PY.get(i)) {
				GamePanel.game = 3;
			}
		}
	}
}
