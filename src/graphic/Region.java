package graphic;

import java.awt.*;

public class Region extends BasicObject{


	public Region(int x, int y) {
		this.graphicPoint = new Point();
		this.graphicPoint.x = x;
		this.graphicPoint.y = y;
		this.width = 0;
		this.height = 0;
		this.isHighlighted = false;
	}

	public void draw(Graphics g) {
		if ((width != 0) || (height != 0)) {
			g.setColor(Color.orange);
			g.drawRect(graphicPoint.x, graphicPoint.y, width, height);
			g.drawString("Select Region", graphicPoint.x, graphicPoint.y);
		}
	}
  
}
