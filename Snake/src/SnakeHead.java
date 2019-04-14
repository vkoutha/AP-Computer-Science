
public class SnakeHead extends Snake{
		
	private boolean movementComplete;
	public SnakeHead(int rows, int columns){
		super(rows, columns);
		Game.movementDone = true;
	}
	
	public void move(GameData.Directions direction){
		Game.movementDone = false;
		this.direction = direction;
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
		Game.movementDone = true;
	}
	
	public boolean isMovementComplete() {
		return movementComplete;
	}
	
	public SnakeHead getHead(){
		return this;
	}

}
