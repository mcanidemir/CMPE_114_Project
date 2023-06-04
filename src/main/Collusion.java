package main;

import Entity.Player;

public class Collusion {

	public void MonkeyTouched() {
		for (int i = 0; i < 26; i++) {
			if (Player.x <= projectile.PX.get(i) + 15 && Player.x >= projectile.PX.get(i) - 15
					&& Player.y <= projectile.PY.get(i) + 15 && Player.y >= projectile.PY.get(i) - 15) {
				GamePanel.game = 3;
			}
		}
	}
}
