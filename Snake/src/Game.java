import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Game implements KeyListener, ActionListener{
	
	public static Game game;
	static Snake snake;
	static Apple apple;
	static Grid[][] grid;
	static JFrame frame;
	Renderer renderer;
	KeyEvent keyPressed;
	GameData.Directions movementDirection;
	
	public Game(){
		
		frame = new JFrame("Slither Boy");
		snake = new Snake();
		renderer = new Renderer();
		Timer timer = new Timer(20, this);
	//	frame.setPreferredSize( Dimension(400, 400));
		frame.setSize(GameData.GAME_WIDTH, GameData.GAME_HEIGHT);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.add(renderer);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initialize();
		timer.start();
		
	}
	
	public void initialize(){
		snake = new Snake();
		apple = new Apple();
		grid = new Grid[GameData.GRID_ROWS][GameData.GRID_COLUMNS];
		for(int row = 0; row < grid.length; row++)
			for(int column = 0; column < grid[row].length; column++){
				grid[row][column] = new Grid(row, column);
			}
				
	}
	
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
		apple.render(g);
		snake.render(g);
		for(int row = 0; row < grid.length; row++)
			for(int column = 0; column < grid[row].length; column++)
				//grid[row][column].render(g);
				;
	}
	
	public void update(){
		int[] tempRow = snake.getRows();
		int[] tempCol = snake.getColumns();
//		if(movementDirection == GameData.Directions.UP || movementDirection == GameData.Directions.DOWN){
//			snake.setColumns(snake.getRows());
//			snake.setRows(tempCol);
//		}else{
//			snake.setRows(snake.getColumns());
//			snake.setColumns(tempRow);
//		}
		if(snake.outOfBounds())
			System.exit(0);
		if(movementDirection != null)
			snake.move(movementDirection);
		if(apple.isHit()){
			System.out.println("HIT!!!");
			apple.spawnNew();
			snake.increaseLength();
		}
	}
	
	public static void main(String[] args){
		game = new Game();
	}

	@Override
	public void keyPressed(KeyEvent key) {
		// TODO Auto-generated method stub
	//	System.out.println("something killed");
		switch(key.getKeyCode()){
		case KeyEvent.VK_UP:
			if(movementDirection != GameData.Directions.DOWN)
				movementDirection = GameData.Directions.UP;
			break;
		case KeyEvent.VK_DOWN:
			if(movementDirection != GameData.Directions.UP)
				movementDirection = GameData.Directions.DOWN;
			break;
		case KeyEvent.VK_LEFT:
			if(movementDirection != GameData.Directions.RIGHT)
				movementDirection = GameData.Directions.LEFT;
			break;
		case KeyEvent.VK_RIGHT:
			if(movementDirection != GameData.Directions.LEFT)
				movementDirection = GameData.Directions.RIGHT;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		renderer.repaint();
		update();
	}

}
