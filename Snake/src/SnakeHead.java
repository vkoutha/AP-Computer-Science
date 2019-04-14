
public class SnakeHead extends Snake{
<<<<<<< HEAD
		
	private boolean movementComplete;
=======
	
	private GameData.Directions direction;
	private int[] turningPoint;
	
>>>>>>> branch 'master' of https://github.com/vkoutha/AP-Computer-Science.git
	public SnakeHead(int rows, int columns){
		super(rows, columns);
<<<<<<< HEAD
		Game.movementDone = true;
=======
		turningPoint = new int[]{row, column};
>>>>>>> branch 'master' of https://github.com/vkoutha/AP-Computer-Science.git
	}
	
	public void move(GameData.Directions direction){
<<<<<<< HEAD
		Game.movementDone = false;
=======
>>>>>>> branch 'master' of https://github.com/vkoutha/AP-Computer-Science.git
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
	
<<<<<<< HEAD
	public boolean isMovementComplete() {
		return movementComplete;
=======
	public int[] getTurningPoint(){
		if (Game.prevDirection != Game.movementDirection){
			Game.prevDirection = Game.movementDirection;
			turningPoint = new int[]{row, column};
			System.out.println("NEW TURNING POINTTT");
		}
		return turningPoint;
	}
	
	public GameData.Directions getDirection(){
		return direction;
>>>>>>> branch 'master' of https://github.com/vkoutha/AP-Computer-Science.git
	}
	
	public SnakeHead getHead(){
		return this;
	}

}
