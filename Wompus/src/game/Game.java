package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Game extends Application implements ActionListener, KeyListener {

	public static Game game;
	private JFrame frame;
	private Timer timer;
	private Renderer renderer;
	private Tile[][] tiles;
	private Player player;
	private Media themeSong;
	private MediaPlayer musicPlayer;
	public JLabel explosionGIF;

	public Game() {
		frame = new JFrame(GameData.FRAME_NAME);
		explosionGIF = new JLabel();
		timer = new Timer(GameData.UPDATE_SPEED_MS, this);
		renderer = new Renderer();
		renderer.setPreferredSize(new Dimension(GameData.FRAME_WIDTH, GameData.FRAME_HEIGHT));
		frame.add(renderer);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
		startMusic();
		timer.start();
	}

	private void initialize() {
		tiles = new Tile[GameData.TILE_AMOUNT][GameData.TILE_AMOUNT];
		for (int r = 0; r < tiles.length; r++) {
			for (int c = 0; c < tiles[r].length; c++) {
				tiles[r][c] = new Tile(r, c);
			}
		}
		player = new Player();
		GameData.FRAME_WIDTH_DIFFERENCE = frame.getWidth() - GameData.FRAME_WIDTH;
		GameData.FRAME_HEIGHT_DIFFERENCE = frame.getHeight() - GameData.FRAME_HEIGHT;
	}

	private void startMusic() { 
		themeSong = new Media(getClass().getResource("/sound/theme.mp3").toExternalForm());
		musicPlayer = new MediaPlayer(themeSong);
		musicPlayer.play();
	}

	public void render(Graphics g) {
		for (Tile[] tileArr : tiles)
			for (Tile tile : tileArr)
				tile.render(g);
		player.render(g);	
	}

	private void update() {
		updateSize();
		if (musicPlayer != null && musicPlayer.getCurrentTime().greaterThanOrEqualTo(musicPlayer.getStopTime())) {
			startMusic();
		}
	}

	private void updateSize() {
		if (frame.getPreferredSize().getWidth() != GameData.FRAME_WIDTH
				|| frame.getPreferredSize().getHeight() != GameData.FRAME_HEIGHT) {
			renderer.setPreferredSize(new Dimension(frame.getWidth() - GameData.FRAME_WIDTH_DIFFERENCE,
					frame.getHeight() - GameData.FRAME_HEIGHT_DIFFERENCE));
			GameData.FRAME_WIDTH = (int) frame.getWidth() - GameData.FRAME_WIDTH_DIFFERENCE;
			GameData.FRAME_HEIGHT = (int) frame.getHeight() - GameData.FRAME_HEIGHT_DIFFERENCE;
			GameData.TILE_WIDTH = GameData.FRAME_WIDTH / GameData.TILE_AMOUNT;
			GameData.TILE_HEIGHT = GameData.FRAME_HEIGHT / GameData.TILE_AMOUNT;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			player.move(GameData.MovementDirections.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			player.move(GameData.MovementDirections.RIGHT);
			break;
		case KeyEvent.VK_UP:
			player.move(GameData.MovementDirections.UP);
			break;
		case KeyEvent.VK_DOWN:
			player.move(GameData.MovementDirections.DOWN);
			break;
		case KeyEvent.VK_SPACE:
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		renderer.repaint();
		update();
	}

	public JFrame getFrame() {
		return frame;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				game = new Game();
			}
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	}

}
