package mode;

import java.awt.event.*;

import graphic.*;

public class BaseLineMode extends Mode{
	MouseEvent starte;
	MouseEvent ende;
	Graphic startfigure = null;
	Graphic endfigure = null;
	ConnectionPort startpoint = null;
	ConnectionPort endpoint = null;
	Line templine = null;
	public BaseLineMode() {

	}

	public void mouseClicked(MouseEvent e) {
		System.out.print("Line mode, mouse Clicked!\n");
	}
	
	public void mousePressed(MouseEvent e){
	    starte = e;
	    startfigure = getTargetGraphic(starte);
	    startpoint=null;
	    if (startfigure != null) {
	    	startpoint = startfigure.getPort(starte);
	    }
	    System.out.print("Line mode, mouse Pressed!\n");
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

}

