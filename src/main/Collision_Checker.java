package main;

import Entity.Entity;
import Entity.Player;

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
		int entityTopRaw = entityTopWorldY/gp.TileSize;
		int entityBottomRaw = entityBottomWorldY/gp.TileSize;
		
		
		int tileNum1, tileNum2;
		
		switch(Entity.direction) {
		
		case("down"):
			entityBottomRaw = (entityBottomWorldY - Player.y)/gp.TileSize;
			tileNum1 = gp.TileM.mapTileNum[entityLeftCol][entityTopWorldY];
			tileNum2 = gp.TileM.mapTileNum[entityRightCol][entityTopWorldY];
			if (gp.TileM.tile[tileNum1].collision == true || gp.TileM.tile[tileNum2].collision == true) {
				
			}
			break;

		case("left"):
	
			break;

		case("right"):
	
			break;

		}
	}
}
