package graphic;

import java.awt.*;

public class Region extends BaseObject{


	public Region(int x, int y) {
		this.position = new Point();
		this.position.x = x;
		this.position.y = y;
		this.width = 0;
		this.height = 0;
		this.isSelected = false;
	}

	public void draw(Graphics g) {
		if ((width != 0) || (height != 0)) {
			g.setColor(Color.orange);
			g.drawRect(position.x, position.y, width, height);
			g.drawString("Select Region", position.x, position.y);
		}
	}
  
}
