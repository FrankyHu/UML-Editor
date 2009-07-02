package graphic;

import java.awt.*;
import java.awt.event.*;

public class UseCase extends BasicObject {
	public UseCase() {
		
	}
	
	public UseCase(int gID, MouseEvent e) {
		// Set UseCase width and height
		width = 120;
	    height = 60;
	    
	    graphicID = gID;
	    graphicName = "Use Case " + gID;
	    graphicPoint = new Point();
	    graphicPoint.x = e.getX();
	    graphicPoint.y = e.getY();

	    attachPort();
	  }

	public void draw(Graphics g) {
		if (isHighlighted == true) {
			draw(g, Color.yellow);
			for (int i = 1; i <= PortNum; i++) {
				portList[i].draw(g);
			}
		}
		else {
			draw(g, Color.white);
		}
	}

	public void draw(Graphics g, Color color) {
		g.setColor(color);
	    g.fillOval(graphicPoint.x, graphicPoint.y, width, height);
	    g.setColor(Color.black);
	    g.drawOval(graphicPoint.x, graphicPoint.y, width, height);
	    g.drawString(graphicName, graphicPoint.x + width / 20, graphicPoint.y + height / 2);
	}

}