import java.awt.Color;
import java.awt.Graphics;

public abstract class Snake {
	
	protected int row, column; 
	private GameData.Directions direction;
	
	public Snake(int row, int column){
	//	rows = new int[]{(GameData.GRID_ROWS/2)-1, (GameData.GRID_ROWS/2)};
	//	columns = new int[]{(GameData.GRID_COLUMNS/2)-1, (GameData.GRID_COLUMNS/2)};
		this.row = row;
		this.column = column;
		row = GameData.GRID_ROWS/2;
		column = GameData.GRID_COLUMNS/2;
	}
	
	public abstract void move(GameData.Directions direction);

//	public void increaseLength(){
//		if(direction == GameData.Directions.UP || direction == GameData.Directions.DOWN){
//			int[] temp = new int[rows.length+1];
//			for(int c = 0; c < rows.length; c++)
//				temp[c] = rows[c];
//			temp[temp.length-1] = rows[rows.length-1]-1;
//			rows = temp;
//			if(direction == GameData.Directions.UP)
//				rows[rows.length-1] = rows[rows.length-2]+1;
//			else
//				rows[rows.length-1] = rows[rows.length-2]-1;
//		}else{
//			int[] temp = new int[columns.length+1];
//			for(int c = 0; c < columns.length; c++)
//				temp[c] = columns[c];
//			temp[temp.length-1] = columns[columns.length-1]-1;
//			columns = temp;
//			if(direction == GameData.Directions.LEFT)
//				columns[columns.length-1] = columns[columns.length-2]-1;
//			else
//				columns[columns.length-1] = columns[columns.length-2]+1;
//		}
//	}
	
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
