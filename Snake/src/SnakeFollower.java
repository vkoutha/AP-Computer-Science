import java.awt.Color;
import java.awt.Graphics;

public class SnakeFollower extends Snake {
	
	private int[] rows, columns; 
	
	public SnakeFollower(int[] rows, int[] columns){
		super(rows, columns);
	}
	
	public void move(GameData.Directions direction){
		
	}
	
	public void setColumns(int[] col){columns = col;}
	
	public int[] getColumns(){return columns;}
	
	public void setRows(int[] row){rows = row;}

	public int[] getRows(){return rows;}
	
	public boolean outOfBounds(){
		if(rows[0] > GameData.GRID_ROWS || rows[0] < 0
				|| columns[0] > GameData.GRID_COLUMNS || columns[0] < 0)
			return true;
		return false;
	}
	
	public void render(Graphics g){
		g.setColor(Color.GREEN);
		for(int row = 0; row < rows.length; row++){
			for(int col = 0; col < columns.length; col++){
				g.fillRect(columns[col]*GameData.GRID_WIDTH, rows[row]*GameData.GRID_HEIGHT, GameData.GRID_WIDTH-1, GameData.GRID_HEIGHT-1);
			}
		}
	}

	public SnakeHead getHead() {
		// TODO Auto-generated method stub
		return (SnakeHead) Game.snake.get(0);
	}

}
