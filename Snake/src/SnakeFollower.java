
public class SnakeFollower extends Snake {
		
	public SnakeFollower(int rows, int columns){
		super(rows, columns);
	}
	
	public void move(GameData.Directions direction){
		if(getHead().getTurningPoint() != null){
			if(row == getHead().getRow() && column == getHead().getColumn()){
				direction = getHead().getDirection();
			}else{
				
			}
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
		}
	}
	
	public SnakeHead getHead() {
		// TODO Auto-generated method stub
		return (SnakeHead) Game.snake.get(0);
	}

}
