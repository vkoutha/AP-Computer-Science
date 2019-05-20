package game;

public class GameData {
	
	public interface FrameData{
		String FRAME_NAME = "Wompus";
		int FRAME_WIDTH = 800;
		int FRAME_HEIGHT = 800;
		int UPDATE_SPEED_MS = 20;
	}
	
	public interface TileData{
		int TILE_AMOUNT = 10;
		int TILE_WIDTH = (FrameData.FRAME_WIDTH/TILE_AMOUNT);
		int TILE_HEIGHT = (FrameData.FRAME_HEIGHT/TILE_AMOUNT);
	}
	
	public interface Sprites{
		
	}

}
