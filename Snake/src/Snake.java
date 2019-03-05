import java.awt.Color;
import java.awt.Graphics;

public abstract class Snake {
	
	private int[] rows, columns; 
	private GameData.Directions direction;
	
	public Snake(int[] rows, int[] columns){
	//	rows = new int[]{(GameData.GRID_ROWS/2)-1, (GameData.GRID_ROWS/2)};
	//	columns = new int[]{(GameData.GRID_COLUMNS/2)-1, (GameData.GRID_COLUMNS/2)};
		this.rows = rows;
		this.columns = columns;
		rows = new int[]{(GameData.GRID_ROWS/2)};
		columns = new int[]{(GameData.GRID_COLUMNS/2)};
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
	
	public void setColumns(int[] col){columns = col;};
	public void setRows(int[] row){rows = row;};
	
	public int[] getColumns(){return columns;};
	public int[] getRows(){return rows;};
	
	public GameData.Directions getDirection(){return direction;}
	
	public abstract SnakeHead getHead();
	
	public abstract boolean outOfBounds();
	
	public void render(Graphics g){
		g.setColor(Color.GREEN);
		for(int row = 0; row < rows.length; row++){
			for(int col = 0; col < columns.length; col++){
				g.fillRect(columns[col]*GameData.GRID_WIDTH, rows[row]*GameData.GRID_HEIGHT, GameData.GRID_WIDTH-1, GameData.GRID_HEIGHT-1);
			}
		}
	}

}
