import java.awt.Color;
import java.awt.Graphics;

public class Points extends SortingType{
	
	private int val, radius = 1;
	public Points(int val) {
		this.val = val;
	}
	
	public int getVal() {
		return val;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawOval((int) (Main.getIndex(this)*1.47*(Main.FRAME_WIDTH/Main.objs.size())), 
				(int)(Main.FRAME_HEIGHT-55)-val-1-(int)(Main.FRAME_HEIGHT/Main.FRAME_WIDTH), radius, radius);
	}

}
