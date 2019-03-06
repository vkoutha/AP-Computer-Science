import java.awt.Color;
import java.awt.Graphics;

public class SnakeHead extends Snake{
	
	private int row, column; 
	private GameData.Directions direction;
	
	public SnakeHead(int rows, int columns){
	//	rows = new int[]{(GameData.GRID_ROWS/2)-1, (GameData.GRID_ROWS/2)};
	//	columns = new int[]{(GameData.GRID_COLUMNS/2)-1, (GameData.GRID_COLUMNS/2)};
		super(rows, columns);
	}
	
	public void move(GameData.Directions direction){
		switch(direction){
		case UP:
			row-=GameData.SNAKE_MOVEMENT_SPEED;
			break;
		case DOWN:
			row+=GameData.SNAKE_MOVEMENT_SPEED;
			break;
		case RIGHT:
			column+=GameData.SNAKE_MOVEMENT_SPEED;
			break;
		case LEFT:
			column-=GameData.SNAKE_MOVEMENT_SPEED;
			break;
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int[] getTurningPoint(){
		if (Game.prevDirection != Game.movementDirection){
			Game.prevDirection = Game.movementDirection;
			return new int[]{row, column};
		}
		return null;
	}
	
	public SnakeHead getHead(){
		return this;
	}

}
