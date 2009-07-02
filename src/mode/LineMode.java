package mode;

import java.awt.event.*;

import graphic.*;

public class LineMode extends Mode{
	MouseEvent startPoint;
	MouseEvent endPoint;
	Graphic startGrapic = null;
	Graphic endGraphic = null;
	ConnectionPort startPort = null;
	ConnectionPort endPort = null;
	Line tempLine = null;
	public LineMode() {

	}
	
	public void mousePressed(MouseEvent e) {
	    startPoint = e; // The point when mouse press
	    startGrapic = getTargetGraphic(startPoint); // Check if click in an object

	    if (startGrapic != null) {
	    	startPort = startGrapic.getPort(startPoint);
	    } 
	    else {
	    	startPort = null;
	    }
	}
	
	// Unused method
	public void mouseReleased(MouseEvent e) {

	}
	
	public void mouseEntered(MouseEvent e) {

	}
	
	public void mouseExited(MouseEvent e) {

	}
	
	public void mouseMoved(MouseEvent e) {

	}
	
	public void mouseDragged(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {
		
	}
}

