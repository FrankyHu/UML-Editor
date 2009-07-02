package graphic;

import java.awt.*;
import java.awt.event.*;

public class UseCase extends BaseObject {
	public UseCase() {
		
	}
	
	public UseCase(int gID, MouseEvent e) {
		// Set UseCase width and height
		width = 100;
	    height = 70;
	    
	    graphicID = gID;
	    graphicName = "Use Case " + gID;
	    position = new Point();
	    position.x = e.getX();
	    position.y = e.getY();

	    attachPort();
	  }

	public void draw(Graphics g) {
		if (isSelected == true) {
			this.draw(g, Color.yellow);
			for (int i = 1; i <= PortNum; i++) {
				this.portList[i].draw(g);
			}
		}
		else {
			this.draw(g, Color.white);
		}
	}

	public void draw(Graphics g, Color color) {
		g.setColor(color);
	    g.fillOval(position.x, position.y, width, height);
	    g.setColor(Color.black);
	    g.drawOval(position.x, position.y, width, height);
	    g.drawString(graphicName, position.x + width / 20, position.y + height / 2);
	}

}