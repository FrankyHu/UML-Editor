package graphic;

import java.awt.*;
import java.awt.event.*;

abstract public class Graphic {
	int PortNum = 4; //Set port number
	public boolean isHighlighted = false;
	public int depth = 1;
	public int graphicID;
	public Point graphicPoint = null;
	public String graphicName = null;
	public ConnectionPort portList[] = new ConnectionPort [5];
	public int width;
	public int height;

	public Graphic() {
	
	}

	public boolean isSelected(MouseEvent e, int objectWidth, int objectHeight) {
		return false;
	}

	public ConnectionPort getPort(MouseEvent e) {
		return null;
	}

	public void highlight() {
		isHighlighted = true;
	}
	
	public void disableHighlight() {
		isHighlighted = false;
	}
	
	public void draw(Graphics g) {
		
	}
	
	public void attachPort() {
		portList[1].x = graphicPoint.x + (width / 2) - (portList[1].width / 2);
		portList[1].y = graphicPoint.y - (portList[1].height / 2);
		
		portList[2].x = graphicPoint.x + width - (portList[2].width / 2);
		portList[2].y = graphicPoint.y + (height / 2) - (portList[2].height / 2);
		
		portList[3].x = graphicPoint.x + (width / 2) - (portList[3].width / 2);
		portList[3].y = graphicPoint.y + height - (portList[3].height / 2);
		
		portList[4].x = graphicPoint.x - (portList[4].width / 2);
		portList[4].y = graphicPoint.y + (height / 2) - (portList[4].height / 2);
	}

	public void setPosition(int distx, int disty) {
		graphicPoint.x = graphicPoint.x + distx;
		graphicPoint.y = graphicPoint.y + disty;
		attachPort();
	}
}
