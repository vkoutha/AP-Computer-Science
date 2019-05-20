package game;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import game.GameData.FrameData;
import game.GameData.TileData;

public class Game implements ActionListener, KeyListener{

	public static Game game;
	private JFrame frame;
	private Timer timer;
	private Renderer renderer;
	private Tile[][] tiles;
	
	public Game() {
		frame = new JFrame(FrameData.FRAME_NAME);
		timer = new Timer(FrameData.UPDATE_SPEED_MS, this);
		renderer = new Renderer();
		renderer.setPreferredSize(new Dimension(FrameData.FRAME_WIDTH, FrameData.FRAME_HEIGHT));
		frame.add(renderer);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		timer.start();
		initialize();
	}
	
	private void initialize() {
		tiles = new Tile[TileData.TILE_AMOUNT][TileData.TILE_AMOUNT];
		for(int r = 0; r < tiles.length; r++) {
			for(int c = 0; c < tiles[r].length; c++) {
				tiles[r][c] = new Tile(r, c);
			}
		}
	}
	
	public void render(Graphics g) {
		for(Tile[] tileArr : tiles)
			for(Tile tile : tileArr)
				tile.render(g);
	}
	
	private void update() {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
 		renderer.repaint();
 		update();
	}

	public static void main(String[] args) {
		game = new Game();
	}
	
}
