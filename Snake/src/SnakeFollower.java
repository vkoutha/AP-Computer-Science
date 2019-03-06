import java.awt.Color;
import java.awt.Graphics;

public class SnakeFollower extends Snake {
	
	private int row, column; 
	
	public SnakeFollower(int rows, int columns){
		super(rows, columns);
	}
	
	public void move(GameData.Directions direction){
		
	}
	
	public SnakeHead getHead() {
		// TODO Auto-generated method stub
		return (SnakeHead) Game.snake.get(0);
	}

}
