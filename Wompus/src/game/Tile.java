package game;

import java.awt.Color;
import java.awt.Graphics;

import game.GameData.TileData;

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
		g.drawLine(800, 0, 800, 800);
		g.drawRect(row*TileData.TILE_WIDTH, column*TileData.TILE_HEIGHT, TileData.TILE_WIDTH, TileData.TILE_HEIGHT);
	}

}
