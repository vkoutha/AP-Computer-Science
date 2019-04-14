
public class SnakeFollower extends Snake {
		
<<<<<<< HEAD
	public SnakeFollower(int row, int column){
		super(row, column);
		direction = getHead().getDirection();
=======
	public SnakeFollower(int rows, int columns){
		super(rows, columns);
>>>>>>> branch 'master' of https://github.com/vkoutha/AP-Computer-Science.git
	}
	
	public void move(GameData.Directions direction){
<<<<<<< HEAD
		Game.movementDone = false;
		row = Game.snake.get(Game.snake.indexOf(this)-1).getRow();
		column = Game.snake.get(Game.snake.indexOf(this)-1).getColumn();
		Game.movementDone = true;
=======
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
>>>>>>> branch 'master' of https://github.com/vkoutha/AP-Computer-Science.git
	}
	
	public SnakeHead getHead() {
		// TODO Auto-generated method stub
		return (SnakeHead) Game.snake.get(0);
	}

}
