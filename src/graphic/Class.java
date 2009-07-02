package graphic;

import java.awt.*;
import java.awt.event.*;

public class Class extends BaseObject{

	int PortNum = 4;    //Set port number

	public Class(int gID, MouseEvent e) {
		width = 100;      // Set box width and height
		height = 100;
		graphicID = gID;
		graphicName  = "Class " + gID;
		position = new Point();
		position.x = e.getX();
		position.y = e.getY();

		for (int i = 1; i <= PortNum; i++) { // new connection port
			portList[i] = new ConnectionPort(this);
		}

		attachPort();
	}

	public void draw(Graphics g){

		if (isSelected == true){
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
	    g.fillRect(position.x, position.y, width, height);
	    g.setColor(Color.black);
	    g.drawRect(position.x, position.y, width, height);
	    g.drawString(graphicName, position.x + width / 10, position.y + height / 5);
	    g.drawLine(position.x, position.y + height / 3, position.x + width, position.y + height / 3);
	    g.drawLine(position.x, position.y + (height / 3) * 2, position.x + width, position.y + (height / 3) * 2);
	}

}
