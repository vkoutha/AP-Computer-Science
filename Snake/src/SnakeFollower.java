import java.awt.Color;
import java.awt.Graphics;

public class SnakeFollower extends Snake {
	
	private int row, column; 
	
	public SnakeFollower(int rows, int columns){
		super(rows, columns);
	}
	
	
	public void move(GameData.Directions direction){
		if(getHead().getTurningPoint() != null){
			if(row == getHead().getRow() && column == getHead().getColumn()){
				direction = getHead().getDirection();
			}
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
		}
	}
	
	public SnakeHead getHead() {
		// TODO Auto-generated method stub
		return (SnakeHead) Game.snake.get(0);
	}

}
