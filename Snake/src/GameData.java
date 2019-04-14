
public class GameData {
	
	public static final int REFRESH_TIME_MS = 75;
	
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 800;

	public static final int SNAKE_WIDTH = 25;
	public static final int SNAKE_HEIGHT = 25;
	
	public static final int APPLE_WIDTH = 25;
	public static final int APPLE_HEIGHT = 25;
	
	public static final int SNAKE_MOVEMENT_SPEED = 1;
	
	public static final int GRID_ROWS = 45;
	public static final int GRID_COLUMNS = 45;
	
	public static final int GRID_WIDTH = GAME_WIDTH/GRID_COLUMNS;
	public static final int GRID_HEIGHT = GAME_WIDTH/GRID_ROWS;
	   
	public enum Directions{
		UP,
		DOWN,
		RIGHT,
		LEFT;
	}
	
}
