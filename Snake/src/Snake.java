import java.awt.Color;
import java.awt.Graphics;

public abstract class Snake {
	
	protected int row, column; 
	protected GameData.Directions direction;
	
	public Snake(int row, int column){
		this.row = row;
		this.column = column;
		row = GameData.GRID_ROWS/2;
		column = GameData.GRID_COLUMNS/2;
	}
	
	public abstract void move(GameData.Directions direction);
	
	public void setColumn(int col){column = col;};
	public void setRow(int row){this.row = row;};
	
	public int getColumn(){return column;};
	public int getRow(){return row;};
	
	public GameData.Directions getDirection(){return direction;}
	
	public abstract SnakeHead getHead();
	
	public boolean outOfBounds(){
		if(row > GameData.GRID_ROWS || row < 0
				|| column > GameData.GRID_COLUMNS || column < 0)
			return true;
		return false;
	}
	
	public void render(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(column*GameData.GRID_WIDTH, row*GameData.GRID_HEIGHT, GameData.GRID_WIDTH-1, GameData.GRID_HEIGHT-1);
	}

}
