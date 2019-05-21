package game;

import java.awt.Color;
import java.awt.Graphics;

public class Tile {
	
	private int row;
	private int column;
	
	public Tile(int row, int column) {
		this.row = row;
		this.column = column;	
	} 
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawImage(GameData.grassSprite, (row*GameData.TILE_WIDTH), (column*GameData.TILE_HEIGHT), GameData.TILE_WIDTH+1, GameData.TILE_HEIGHT+3, null);
	}

}
