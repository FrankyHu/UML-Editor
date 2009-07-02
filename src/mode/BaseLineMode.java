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
	    startfigure = getTargetFigure(starte);
	    startpoint=null;
	    if (startfigure != null) {
	    	startpoint = startfigure.GetPort(starte);
	    }
	    System.out.print("Line mode, mouse Pressed!\n");
	}
	
	public void mouseReleased(MouseEvent e){
		System.out.print("Line mode, mouse Released!\n");
	}
	
	public void mouseEntered(MouseEvent e){
		System.out.print("Line mode, mouse Entered!\n");
	}
	
	public void mouseExited(MouseEvent e){
	    System.out.print("Line mode, mouse Exited!\n");
	}
	
	public void mouseMoved(MouseEvent e){
	    System.out.print("Line mode, mouse Moved!\n");
	}
	
	public void mouseDragged(MouseEvent e){
		System.out.print("Line mode, mouse Dragged!\n");
	}

}

