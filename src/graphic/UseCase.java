package graphic;

import java.awt.*;
import java.awt.event.*;

public class UseCase extends BaseObject {
	public UseCase() {
		
	}

	int PortNum = 4; //port的個數

	public UseCase(int F_ID, MouseEvent e) {
		width = 100; //設定UseCase的寬跟高
	    height = 70;
	    graphicID = F_ID;
	    graphicName = "Use Case " + F_ID;
	    position = new Point();
	    position.x = e.getX();
	    position.y = e.getY();
	    for (int i = 1; i <= PortNum; i++) { //new所有的port
	    	portList[i] = new ConnectionPort(this);
	    }
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