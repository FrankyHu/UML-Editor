package graphic;

import java.awt.*;
import java.awt.event.*;

abstract public class Graphic {

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

	public boolean isSelected(MouseEvent e, int O_width, int O_height) {
		return false;
	}

	public ConnectionPort GetPort(MouseEvent e) {
		ConnectionPort temp = null;
		return temp;
	}

	public void Highlight(){
		isSelected = true;
	}
	
	public void DisHighlight(){
		isSelected = false;
	}
	
	public void draw(Graphics g) {
		
	}
}
