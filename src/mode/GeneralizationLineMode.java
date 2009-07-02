package mode;

import java.awt.event.*;

import controller.*;
import graphic.*;

public class GeneralizationLineMode extends LineMode{

	public GeneralizationLineMode() {
		
	}

	public void mouseReleased(MouseEvent e) {
		Controller.getInstance().graphicArray.remove(tempLine);
	    endPoint = e;
	    endGraphic = getTargetGraphic(endPoint);
	    if ((endGraphic != null) && (startPort != null) && (endGraphic != startGrapic)) {
	    	endPort = endGraphic.getPort(endPoint);
	    	Controller.addGraphic(new GeneralizationLine(Controller.getInstance().IDcount, startPort, endPort), e);
	    }
	    Controller.mainFrame.repaint();
	}

	public void mouseDragged(MouseEvent e) {
	    endPoint = e;
	    if (startPort != null) {
	    	endPort = new ConnectionPort(startGrapic);
	    	endPort.x = endPoint.getX();
	    	endPort.y = endPoint.getY();
	    	Controller.getInstance().graphicArray.remove(tempLine);
	    	tempLine = new GeneralizationLine(Controller.getInstance().IDcount, startPort,endPort);
	    	Controller.addGraphic(tempLine,e);
	    	Controller.mainFrame.repaint();
	    }
	}

}
