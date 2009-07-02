package mode;

import java.awt.event.*;

import controller.*;
import graphic.*;

public class AssociationLineMode extends LineMode{

	public AssociationLineMode() {
		
	}

	public void mouseReleased(MouseEvent e) {
		EditorController.getInstance().graphicArray.remove(tempLine); // Remove tempLine
	    endPoint = e;
	    endGraphic = getTargetGraphic(endPoint);
	    if ((endGraphic != null) && (startPort != null)) {
	    	endPort = endGraphic.getPort(endPoint);
	    	EditorController.getInstance().addGraphic(new AssociationLine(EditorController.getInstance().IDcount, startPort, endPort), endPoint);
	    }
	    EditorController.mainFrame.repaint();
	}

	public void mouseDragged(MouseEvent e) {
		endPoint = e;
	    if (startPort != null){
	    	endPort = new ConnectionPort(startGrapic); // For tempLine use only
	    	endPort.x = endPoint.getX();
	    	endPort.y = endPoint.getY();
	    	EditorController.getInstance().graphicArray.remove(tempLine);// Remove the line when last mouse drag create
	    	tempLine = new AssociationLine(EditorController.getInstance().IDcount, startPort,endPort);
	    	EditorController.getInstance().addGraphic(tempLine, e);// Only visible when mouse drag, will be remove when mouse release
	    	EditorController.mainFrame.repaint();
	    }
	}
}
