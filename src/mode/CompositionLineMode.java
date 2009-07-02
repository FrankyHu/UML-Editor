package mode;

import java.awt.event.*;

import controller.*;
import graphic.*;

public class CompositionLineMode extends BaseLineMode{

	public CompositionLineMode() {
		  
	}

	public void mouseReleased(MouseEvent e){
		Controller.getInstance().graphicArray.remove(templine);//把templine清除
	    ende = e;
	    endfigure = getTargetGraphic(ende);
	    if ((endfigure != null) && (startpoint != null) && (endfigure != startfigure)) {
	    	endpoint = endfigure.getPort(ende);
	    	Controller.getInstance().IDcount++;
	    	Controller.addGraphic(new CompositionLine(Controller.getInstance().IDcount, startpoint, endpoint),e);
	    }
	    Controller.mainFrame.repaint();
	    System.out.print("create CLine mode, mouse Released!\n");
	}

	public void mouseDragged(MouseEvent e){
		ende = e;
	    if (startpoint != null){
	    	endpoint = new ConnectionPort(startfigure);//用來給templine使用的暫時endport
	    	endpoint.x = ende.getX();
	    	endpoint.y = ende.getY();
	    	Controller.getInstance().graphicArray.remove(templine);//移除前一次dragged加入的templine
	    	templine = new CompositionLine(Controller.getInstance().IDcount, startpoint, endpoint);
	    	Controller.addGraphic(templine, e);//加入templine使拉線的過程中可以看見，在mouserelease時移除
	    	Controller.mainFrame.repaint();
	    }
	    System.out.print("create CLine mode, mouse Dragged!\n");
	}
}
