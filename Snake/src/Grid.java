import java.awt.Color;
import java.awt.Graphics;

public class Grid {
	
	private int row, column; 
	
	public Grid(int row, int column){
		this.row = row;
		this.column = column;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getColumn(){
		return column;
	}
	
	public void render(Graphics g){
		g.setColor(Color.WHITE);
		if(row == 0)
			g.drawLine(0, column*(GameData.GAME_HEIGHT/GameData.GRID_COLUMNS), GameData.GAME_HEIGHT, column*(GameData.GAME_HEIGHT/GameData.GRID_COLUMNS));
		if(column == 0)
			g.drawLine(row*(GameData.GAME_WIDTH/GameData.GRID_ROWS), 0, row*(GameData.GAME_WIDTH/GameData.GRID_ROWS), GameData.GAME_WIDTH);
	}

}
