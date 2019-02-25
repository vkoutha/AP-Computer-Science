import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Apple {
	
	int xPos, yPos;
	
	public Apple(){
		spawnNew();
	}
	
	public boolean isHit(){
		if(Game.snake.getColumn() == xPos && Game.snake.getColumn() + GameData.SNAKE_WIDTH == xPos + GameData.APPLE_WIDTH 
				&& Game.snake.getRow() == yPos && Game.snake.getRow() + GameData.SNAKE_HEIGHT == yPos + GameData.APPLE_HEIGHT)
					return true;
		return false;
	}
	
	public void spawnNew(){
		Random rand = new Random();
		xPos = rand.nextInt(Game.frame.getWidth()-(GameData.APPLE_WIDTH*2))+1;
		yPos = rand.nextInt(Game.frame.getHeight()-(GameData.APPLE_HEIGHT*2))+1;
	}
	
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(xPos, yPos, GameData.APPLE_WIDTH, GameData.APPLE_HEIGHT);
	}

}
