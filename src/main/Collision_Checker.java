package main;

import Entity.Entity;

public class Collision_Checker {

	
	GamePanel gp;

	public Collision_Checker(GamePanel gp) {
		this.gp=gp;
	}
	
	public void CheckTile(Entity Entity) {
		
		int entityLeftWorldX = Entity.x + Entity.marioSolid.x;
		int entityRightWorldX = Entity.x + Entity.marioSolid.x + Entity.marioSolid.width;
		int entityTopWorldY = Entity.y + Entity.marioSolid.y;
		int entityBottomWorldY = Entity.y + Entity.marioSolid.y + Entity.marioSolid.height;
	
		int entityLeftCol = entityLeftWorldX/gp.TileSize;
		int entityRightCol = entityRightWorldX/gp.TileSize;
		int entityTopCol = entityTopWorldY/gp.TileSize;
		int entityBottomCol = entityBottomWorldY/gp.TileSize;
		
		
		int tileNum1, tileNum2;
		
		switch(Entity.direction) {
		
		case("down"):
			
			break;

		case("left"):
	
			break;

		case("right"):
	
			break;

		}
	}
}
