package Entity;

import main.projectile;

public class Ladder {
	
	public static void onLadder(int i) {

		if ((projectile.PX.get(i) == 1235 && projectile.PY.get(i) == projectile.stair3Y) || (projectile.PX.get(i) == 1040 && projectile.PY.get(i) == projectile.stair5Y)
				|| (projectile.PX.get(i) == 203 && projectile.PY.get(i) == projectile.stair2Y) || (projectile.PX.get(i) == 392 && projectile.PY.get(i) == projectile.stair4Y)) {
			projectile.ladder[i] = true;
		} else {
			projectile.ladder[i] = false;
		}
	}
public static void onGround(int i) {
	if (projectile.PY.get(i) == projectile.stair1Y || (projectile.PY.get(i) == projectile.stair2Y && projectile.PX.get(i) >= 110 && projectile.PX.get(i) <= 1500)
			|| (projectile.PY.get(i) == projectile.stair3Y && projectile.PX.get(i) >= 0 && projectile.PX.get(i) <= 1350)
			|| (projectile.PY.get(i) == projectile.stair4Y && projectile.PX.get(i) >= 110 && projectile.PX.get(i) <= 1500)
			|| (projectile.PY.get(i) == projectile.stair5Y && projectile.PX.get(i) >= 0 && projectile.PX.get(i) <= 1350)) {
		projectile.ground[i] = true;
	} else {
		projectile.ground[i] = false;
	}
}
}
