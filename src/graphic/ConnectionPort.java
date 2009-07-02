package graphic;

import java.awt.*;
import java.awt.event.*;


public class ConnectionPort extends Graphic {
	public int x;
	public int y;
	int width = 10;
	int height = 10;
	public Graphic connectedGraphic;
	public ConnectionPort(Graphic graphic) {
		connectedGraphic = graphic;
	}

	public void draw(Graphics g) {
		this.draw(g,Color.cyan);
	}

	public void draw(Graphics g,Color color) {
		g.setColor(color);
		g.fillRect(x, y, width,height);
		g.setColor(Color.black);
		g.drawRect(x, y, width,height);
	}

	public boolean isSelected(MouseEvent e,int objectWidth, int objectHeight) {
		int currentX = e.getX();
		int currentY = e.getY();
		
		int widthUpperBound = x + width;
		int widthLowerBound = x;
		int heightUpperBound = y + height;
		int heightLowerBound = y;
		
		if ((currentX <= widthUpperBound) && (currentX >= widthLowerBound) && (currentY <= heightUpperBound) && (currentY >= heightLowerBound)){
			return true;
		}
		else if (((currentX < widthLowerBound) && (currentY <= heightUpperBound)) || ((currentY < heightLowerBound) && (currentX <= widthUpperBound))) {
			if ((currentX + objectWidth >= widthLowerBound) && (currentY+ objectHeight >= heightLowerBound)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
}
