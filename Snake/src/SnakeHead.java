import java.awt.Color;
import java.awt.Graphics;

public class SnakeHead extends Snake{
	
	private GameData.Directions direction;
	private int[] turningPoint;
	
	public SnakeHead(int rows, int columns){
		super(rows, columns);
	}
	
	public void move(GameData.Directions direction){
		this.direction = direction;
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
			turningPoint = new int[]{row, column};
		}
		return turningPoint;
	}
	
	public GameData.Directions getDirection(){
		return direction;
	}
	
	public SnakeHead getHead(){
		return this;
	}

}
