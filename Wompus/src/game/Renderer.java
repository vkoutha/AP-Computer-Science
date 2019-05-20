package game;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import game.GameData.FrameData;

public class Renderer extends JPanel{
	
	protected void paintComponent(Graphics g) {
		Game.game.render(g);
	}

}
