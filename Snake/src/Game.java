import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Game implements KeyListener, ActionListener{
	
	public static Game game;
	static ArrayList<Snake> snake;
	static Apple apple;
	static Grid[][] grid;
	static JFrame frame;
	Renderer renderer;
	KeyEvent keyPressed;
	public static GameData.Directions prevDirection, movementDirection;
	boolean swapped = true;
	static boolean movementDone = false;
	
	public Game(){
		frame = new JFrame("Slither Boy");
		renderer = new Renderer();
		Timer timer = new Timer(GameData.REFRESH_TIME_MS, this);
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
		snake = new ArrayList<Snake>();
		snake.add(new SnakeHead(GameData.GRID_ROWS/2, GameData.GRID_COLUMNS/2));
		apple = new Apple();
		grid = new Grid[GameData.GRID_ROWS][GameData.GRID_COLUMNS];
		for(int row = 0; row < grid.length; row++)
			for(int column = 0; column < grid[row].length; column++){
				grid[row][column] = new Grid(row, column);
			}
		movementDirection = GameData.Directions.UP;
		prevDirection = GameData.Directions.UP;
	}
	
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
		apple.render(g);
		for(int i = 0; i < snake.size(); i++)
			snake.get(i).render(g);
	}
	
	public void update(){
		if(snake.get(0).outOfBounds())
			System.exit(0);
<<<<<<< HEAD
=======
		if(movementDirection != null){
			System.out.println(movementDirection);
			//snake.get(0).move(movementDirection);
			snake.forEach(s -> s.move(movementDirection));
		}
>>>>>>> branch 'master' of https://github.com/vkoutha/AP-Computer-Science.git
		if(apple.isHit()){
			apple.spawnNew();
			switch(snake.get(snake.size()-1).getDirection()){
			case LEFT:
				snake.add(new SnakeFollower(snake.get(snake.size()-1).getRow(), snake.get(snake.size()-1).getColumn()+1));
				break;
			case RIGHT:
				snake.add(new SnakeFollower(snake.get(snake.size()-1).getRow(), snake.get(snake.size()-1).getColumn()-1));
				break;
			case UP:
				snake.add(new SnakeFollower(snake.get(snake.size()-1).getRow()+1, snake.get(snake.size()-1).getColumn()));
				break;
			case DOWN:
				snake.add(new SnakeFollower(snake.get(snake.size()-1).getRow()-1, snake.get(snake.size()-1).getColumn()));
				break;
			}
		}
		
		if(movementDirection != null) {
			for(int i = snake.size()-1; i >= 0; i--) {
				snake.get(i).move(movementDirection);
			}
		}
		
		for(int i = 0; i < snake.size(); i++) {
			for(int j = 0; j < snake.size(); j++) {
				if(i != j && snake.get(i).getRow() == snake.get(j).getRow() && snake.get(i).getColumn() == snake.get(j).getColumn()) {
					System.exit(0);
				}
			}
		}
		
	}
	
	public static void main(String[] args){
		game = new Game();
	}

	@Override
	public void keyPressed(KeyEvent key) {
		// TODO Auto-generated method stub
		if(movementDone == false)
			return;
		switch(key.getKeyCode()){
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			if(movementDirection != GameData.Directions.DOWN) {
				movementDirection = GameData.Directions.UP;
				movementDone = false;
			}
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			if(movementDirection != GameData.Directions.UP) {
				movementDirection = GameData.Directions.DOWN;
				movementDone = false;
			}
			break;
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			if(movementDirection != GameData.Directions.RIGHT) {
				movementDirection = GameData.Directions.LEFT;
				movementDone = false;
			}
			break;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			if(movementDirection != GameData.Directions.LEFT) {
				movementDirection = GameData.Directions.RIGHT;
				movementDone = false;
			}
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
