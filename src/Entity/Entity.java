package Entity;

import java.awt.image.BufferedImage;

public class Entity {
	public int x, y, playerSpeed_Left, playerSpeed_Right, playerSpeed_Up;

	public BufferedImage mariostand, marioRight_1, marioRight_2, marioLeft_1, marioLeft_2, marioclimb_1, marioclimb_2,
			marioJump_1, marioJump_2, DonkeyLeft, DonkeyMid, DonkeyRight;
	public String direction;

	
	public int SprintNum = 1;
	public int SprintCount = 0;

}
