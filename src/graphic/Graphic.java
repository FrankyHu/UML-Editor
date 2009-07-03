package graphic;

import java.awt.*;
import java.awt.event.*;

abstract public class Graphic {
	public int width = 0;
	public int height = 0;
	public int depth = 1;
	public int graphicID = 0;
	public Point graphicPoint;
	public String graphicName;
	
	public boolean isHighlighted = false;
	
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
