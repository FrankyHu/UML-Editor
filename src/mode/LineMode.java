package mode;

import java.awt.event.*;

import graphic.*;

public class LineMode extends Mode{
	MouseEvent starte;
	MouseEvent ende;
	Graphic startfigure = null;
	Graphic endfigure = null;
	ConnectionPort startpoint = null;
	ConnectionPort endpoint = null;
	Line templine = null;
	public LineMode() {

	}
	
	public void mousePressed(MouseEvent e){
	    starte = e;
	    startfigure = getTargetGraphic(starte);
	    startpoint=null;
	    if (startfigure != null) {
	    	startpoint = startfigure.getPort(starte);
	    }
	}
	
	// Unused method
	public void mouseReleased(MouseEvent e){

	}
	
	public void mouseEntered(MouseEvent e){

	}
	
	public void mouseExited(MouseEvent e){

	}
	
	public void mouseMoved(MouseEvent e){

	}
	
	public void mouseDragged(MouseEvent e){

	}

	public void mouseClicked(MouseEvent e) {
		
	}
}

