import java.awt.Color;
import java.awt.Graphics;

public class Bar extends SortingType{
	
	private int val;
	public Bar(int val) {
		this.val = val;
	}

	@Override
	public int getVal() {
		// TODO Auto-generated method stub
		return val;
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.drawRect((int) (Main.getIndex(this)*1.5*(Main.FRAME_WIDTH/Main.objs.size())), 
				(int)Main.FRAME_HEIGHT-val-55, 1, val);
	}

}
