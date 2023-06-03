package Entity;

import java.awt.image.BufferedImage;

public class Entity {
	public static int x;

	public static int y;

	public int playerSpeed_Left;

	public int playerSpeed_Right;

	public int playerSpeed_Up;

	public BufferedImage mariostand, marioRight_1, marioRight_2, marioLeft_1, marioLeft_2, marioclimb_1, marioclimb_2,
			marioJump_1, marioJump_2, marioClimb_1, marioClimb_2;
	public String direction;

	public int SprintNum = 1;
	public int SprintCount = 0;

	public int ClimbNum = 1;
	public int ClimbCount = 0;
}
