
public class SnakeFollower extends Snake {
		
	public SnakeFollower(int row, int column){
		super(row, column);
		direction = getHead().getDirection();
	}
	
	public void move(GameData.Directions direction){
		Game.movementDone = false;
		row = Game.snake.get(Game.snake.indexOf(this)-1).getRow();
		column = Game.snake.get(Game.snake.indexOf(this)-1).getColumn();
		Game.movementDone = true;
	}
	
	public SnakeHead getHead() {
		// TODO Auto-generated method stub
		return (SnakeHead) Game.snake.get(0);
	}

}
