package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.GameData.MovementDirections;

public class Player {
	
	private int row, column;
	private MovementDirections movementDirection;
	private BufferedImage spriteToUse;
	
	public Player() {
		spriteToUse = GameData.characterBackwardsStillSprite;
		movementDirection = null;
	}
	
	public void move(MovementDirections direction) {
		if(direction == MovementDirections.UP && row > 0) {
			spriteToUse = GameData.characterFowardsStillSprite;
			if(movementDirection == direction) {
				spriteToUse = GameData.characterForwardsRunningSprite;
				row--;
			}
		}else if (direction == MovementDirections.DOWN && row < GameData.TILE_AMOUNT-1) {
			spriteToUse = GameData.characterBackwardsStillSprite;
			if(movementDirection == direction) {
				spriteToUse = GameData.characterBackwardsRunningSprite;
				row++;
			}
		}else if (direction == MovementDirections.LEFT && column > 0) {
			spriteToUse = GameData.characterLeftStillSprite;
			if(movementDirection == direction) {
				spriteToUse = GameData.characterLeftRunningSprite;
				column--;
			}
		}else if (direction == MovementDirections.RIGHT && column < GameData.TILE_AMOUNT-1) {
			spriteToUse = GameData.characterRightStillSprite;
			if(movementDirection == direction) {
				spriteToUse = GameData.characterRightRunningSprite;
				column++;
			}
		}
		Game.game.getTiles()[row][column].setDiscovered(true);
		movementDirection = direction;
	}
	
	public void render(Graphics g) {
		g.drawImage(spriteToUse, column * GameData.TILE_WIDTH, row * GameData.TILE_HEIGHT, GameData.TILE_WIDTH, GameData.TILE_HEIGHT, null);
	}

}
