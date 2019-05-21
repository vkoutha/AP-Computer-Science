package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameData {
	
	public static final String FRAME_NAME = "Wumpus";
	public static int FRAME_WIDTH = 1000;
	public static int FRAME_HEIGHT = 1000;
	public static int FRAME_WIDTH_DIFFERENCE = 0;
	public static int FRAME_HEIGHT_DIFFERENCE = 0;
	public static final int UPDATE_SPEED_MS = -5;
	
	public static final int TILE_AMOUNT = 10;
	public static int TILE_WIDTH = (FRAME_WIDTH/TILE_AMOUNT);
	public static int TILE_HEIGHT = (FRAME_HEIGHT/TILE_AMOUNT);

	public static BufferedImage grassSprite = null;
	public static BufferedImage characterSprite = null, characterFowardsStillSprite = null, characterForwardsRunningSprite = null,
			characterBackwardsStillSprite = null, characterBackwardsRunningSprite = null, characterLeftStillSprite = null, characterLeftRunningSprite = null,
			characterRightStillSprite = null, characterRightRunningSprite = null;
	
	static {
		try {
			grassSprite = ImageIO.read(new File("grassTile.jpg"));
			grassSprite = grassSprite.getSubimage(50, 50, grassSprite.getWidth()-50, grassSprite.getHeight()-50);
			characterSprite = ImageIO.read(new File("character.png"));
			characterBackwardsRunningSprite = characterSprite.getSubimage(0, 0, 460, 590);
			characterBackwardsStillSprite = characterSprite.getSubimage(470, 0, 460, 560);
			characterForwardsRunningSprite = characterSprite.getSubimage(0, 1810, 460, 590); 
			characterFowardsStillSprite = characterSprite.getSubimage(470, 1810, 460, 590);
			characterRightRunningSprite = characterSprite.getSubimage(0, 600, 460, 590);
			characterRightStillSprite = characterSprite.getSubimage(470, 600, 470, 590);
			characterLeftRunningSprite = characterSprite.getSubimage(470, 1200, 460, 580);
			characterLeftStillSprite = characterSprite.getSubimage(0, 1200, 460, 580);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public enum MovementDirections{
		UP,
		DOWN,
		LEFT,
		RIGHT
	}

}
