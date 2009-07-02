package graphic;

import java.awt.*;
import java.awt.event.*;

abstract public class Graphic {
	int PortNum = 4;    //Set port number
	public boolean isSelected = false;
	public int depth = 1;
	public int graphicID;
	public Point position = null;
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

	public void highlight(){
		isSelected = true;
	}
	
	public void disableHighlight(){
		isSelected = false;
	}
	
	public void draw(Graphics g) {
		
	}
}
