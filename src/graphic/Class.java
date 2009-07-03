package graphic;

import java.awt.*;
import java.awt.event.*;

public class Class extends BasicObject{

	public Class(int gID, MouseEvent e) {
		// Set class width and height
		width = 80;
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
			draw(g, Color.lightGray);
			for (int i = 1; i <= PortNum; i++) {
				portArray[i].draw(g);
			}
		}
		else {
			draw(g, Color.white);
		}
	}

	public void draw(Graphics g, Color color){
		g.setColor(color);
	    g.fillRect(graphicPoint.x, graphicPoint.y, width, height);
	    g.setColor(Color.black);
	    g.drawRect(graphicPoint.x, graphicPoint.y, width, height);
	    g.drawString(graphicName, graphicPoint.x + width / 10, graphicPoint.y + height / 5);
	    g.drawLine(graphicPoint.x, graphicPoint.y + height / 4, graphicPoint.x + width, graphicPoint.y + height / 4);
	    g.drawLine(graphicPoint.x, graphicPoint.y + (height / 4) * 2, graphicPoint.x + width, graphicPoint.y + (height / 4) * 2);
	    g.drawLine(graphicPoint.x, graphicPoint.y + (height / 4) * 3, graphicPoint.x + width, graphicPoint.y + (height / 4) * 3);
	}

}
