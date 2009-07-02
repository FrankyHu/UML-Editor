package mode;

import java.awt.event.*;

import controller.*;
import graphic.*;


public class AssociationLineMode extends BaseLineMode{

	public AssociationLineMode() {
		
	}

	public void mouseReleased(MouseEvent e) {
		Controller.graphicArray.remove(templine); // Remove templine
	    ende = e;
	    endfigure = getTargetFigure(ende);
	    if ((endfigure != null) && (startpoint != null)) {
	    	endpoint = endfigure.GetPort(ende);
	    	Controller.IDcount++;
	    	Controller.addGraphic(new AssociationLine(Controller.IDcount, startpoint,endpoint), ende);
	    }
	    Controller.mainFrame.repaint();
	    System.out.print("create ALine mode下，mouse Released!\n");
	}

	public void mouseDragged(MouseEvent e){
		ende = e;
	    if (startpoint != null){
	    	endpoint = new ConnectionPort(startfigure);//用來給templine使用的暫時endport
	    	endpoint.x = ende.getX();
	    	endpoint.y = ende.getY();
	    	Controller.graphicArray.remove(templine);//移除前一次dragged加入的templine
	    	templine = new AssociationLine(Controller.IDcount, startpoint,endpoint);
	    	Controller.addGraphic(templine,e);//加入templine使拉線的過程中可以看見，在mouserelease時移除
	    	Controller.mainFrame.repaint();
	    }
	    System.out.print("create ALine mode下，mouse Dragged!\n");
	}
}
