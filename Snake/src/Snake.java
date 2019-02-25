import java.awt.Color;
import java.awt.Graphics;

public class Snake {
	
	private int row, column, length;
	
	public Snake(){
		row = GameData.GRID_ROWS/2;
		column = GameData.GRID_COLUMNS/2;
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
	}
	
	public void increaseLength(){
		length++;
	}
	
	public int getColumn(){return column;}
	
	public int getRow(){return row;}
	
	public boolean outOfBounds(){
		return column < 0 || column + GameData.SNAKE_WIDTH > Game.frame.getWidth()
				|| row < 0 || row + GameData.SNAKE_HEIGHT > Game.frame.getHeight();
	}
	
	public void render(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(column, row, GameData.SNAKE_WIDTH, GameData.SNAKE_HEIGHT);
	}

}
