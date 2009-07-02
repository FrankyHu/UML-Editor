package graphic;

import java.awt.*;
import java.awt.event.*;

public class Class extends BasicObject{

	public Class(int gID, MouseEvent e) {
		// Set class width and height
		width = 100;
		height = 100;
		
		graphicID = gID;
		graphicName  = "Class " + gID;
		graphicPoint = new Point();
		graphicPoint.x = e.getX();
		graphicPoint.y = e.getY();

		attachPort();
	}

	public void draw(Graphics g){

		if (isHighlighted == true){
			this.draw(g,Color.yellow);
			for (int i = 1; i <= PortNum; i++) {
				this.portList[i].draw(g);
			}
		}
		else {
			this.draw(g, Color.white);
		}
	}

	public void draw(Graphics g, Color color){
		g.setColor(color);
	    g.fillRect(graphicPoint.x, graphicPoint.y, width, height);
	    g.setColor(Color.black);
	    g.drawRect(graphicPoint.x, graphicPoint.y, width, height);
	    g.drawString(graphicName, graphicPoint.x + width / 10, graphicPoint.y + height / 5);
	    g.drawLine(graphicPoint.x, graphicPoint.y + height / 3, graphicPoint.x + width, graphicPoint.y + height / 3);
	    g.drawLine(graphicPoint.x, graphicPoint.y + (height / 3) * 2, graphicPoint.x + width, graphicPoint.y + (height / 3) * 2);
	}

}
