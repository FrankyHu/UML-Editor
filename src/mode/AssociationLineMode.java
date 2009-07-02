package mode;

import java.awt.event.*;

import controller.*;
import graphic.*;


public class AssociationLineMode extends LineMode{

	public AssociationLineMode() {
		
	}

	public void mouseReleased(MouseEvent e) {
		Controller.getInstance().graphicArray.remove(templine); // Remove templine
	    ende = e;
	    endfigure = getTargetGraphic(ende);
	    if ((endfigure != null) && (startpoint != null)) {
	    	endpoint = endfigure.getPort(ende);
	    	Controller.getInstance().IDcount++;
	    	Controller.addGraphic(new AssociationLine(Controller.getInstance().IDcount, startpoint,endpoint), ende);
	    }
	    Controller.mainFrame.repaint();
	}

	public void mouseDragged(MouseEvent e){
		ende = e;
	    if (startpoint != null){
	    	endpoint = new ConnectionPort(startfigure);//用來給templine使用的暫時endport
	    	endpoint.x = ende.getX();
	    	endpoint.y = ende.getY();
	    	Controller.getInstance().graphicArray.remove(templine);//移除前一次dragged加入的templine
	    	templine = new AssociationLine(Controller.getInstance().IDcount, startpoint,endpoint);
	    	Controller.addGraphic(templine,e);//加入templine使拉線的過程中可以看見，在mouserelease時移除
	    	Controller.mainFrame.repaint();
	    }
	}
}
