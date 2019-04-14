import java.awt.Color;
import java.awt.Graphics;

public class Line{
	
	private Color color;
	private boolean isBlack = false;
	private int val;
	public Line(int r, int g, int b, int val) {
		color = new Color(r, g, b);
		this.val = val;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getVal() {
		return val;
	}
	
	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}
	
	public boolean isBlack() {
		return isBlack;
	}
	
	public void render(Graphics g) {
		if(isBlack)
			g.setColor(Color.BLACK);
		else
			g.setColor(color);
		g.fillRect(Main.getIndex(this)*(Main.FRAME_WIDTH/Main.colors.size()), 0, Main.FRAME_WIDTH/Main.colors.size(), Main.FRAME_HEIGHT);
	}

}
