import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Apple {
	
	private int[] rows, columns;
	
	public Apple(){
		Random rand = new Random();
		rows = new int[] {rand.nextInt(GameData.GRID_ROWS-1)};
		columns = new int[] {rand.nextInt(GameData.GRID_COLUMNS-1)};
	}
	
	public boolean isHit(){
		for(int c = 0; c < columns.length; c++)
			if(columns[c] != Game.snake.get(0).getColumn())
				return false;
		for(int r = 0; r < columns.length; r++)
			if(rows[r] != Game.snake.get(0).getRow())
				return false;
		return true;
	}
	
	public void spawnNew(){
		Random rand = new Random();
		rows = new int[] {rand.nextInt(GameData.GRID_ROWS-2)};
		System.out.println(rows[0]);
		columns = new int[] {rand.nextInt(GameData.GRID_COLUMNS-2)};		
		System.out.println(columns[0]);
	}
	
	public void render(Graphics g){
		g.setColor(Color.RED);
		for(int row = 0; row < rows.length; row++){
			for(int col = 0; col < columns.length; col++){
				g.fillRect(columns[col]*GameData.GRID_WIDTH, rows[row]*GameData.GRID_HEIGHT, GameData.GRID_WIDTH, GameData.GRID_HEIGHT);
			}
		}
	}
}
