package graphic;

import java.awt.*;
import java.awt.event.*;

abstract public class Graphic {
	int PortNum = 4; //Set port number
	public boolean isHighlighted = false;
	public int depth = 1;
	public int graphicID;
	public Point graphicPoint;
	public String graphicName;
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

}
