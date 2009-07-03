package mode;

import java.awt.event.*;

import controller.*;
import graphic.*;

public class CompositionLineMode extends LineMode{

	public CompositionLineMode() {
		  
	}

	public void mouseReleased(MouseEvent e) {
		EditorController.getInstance().graphicArray.remove(tempLine);
	    endPoint = e;
	    endGraphic = EditorController.getInstance().getDeepestGraphic(endPoint, 0, 0);
	    if ((endGraphic != null) && (startPort != null) && (endGraphic != startGrapic)) {
	    	endPort = endGraphic.getPort(endPoint);
	    	EditorController.getInstance().addGraphic(new CompositionLine(startPort, endPort),e);
	    }
	    EditorController.mainFrame.repaint();
	}

	public void mouseDragged(MouseEvent e) {
		endPoint = e;
	    if (startPort != null){
	    	endPort = new ConnectionPort(startGrapic);
	    	endPort.x = endPoint.getX();
	    	endPort.y = endPoint.getY();
	    	EditorController.getInstance().graphicArray.remove(tempLine);
	    	tempLine = new CompositionLine(startPort, endPort);
	    	EditorController.getInstance().addGraphic(tempLine, e);
	    	EditorController.mainFrame.repaint();
	    }
	}
	
}
