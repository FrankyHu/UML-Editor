package mode;

import java.awt.event.*;

import controller.*;
import graphic.*;

public class GeneralizationLineMode extends BaseLineMode{

	public GeneralizationLineMode() {
		
	}

	public void mouseReleased(MouseEvent e){
		Controller.getInstance().graphicArray.remove(templine);//把templine清除
	    ende = e;
	    endfigure = getTargetFigure(ende);
	    if ((endfigure != null) && (startpoint != null) && (endfigure != startfigure)) {
	    	endpoint = endfigure.GetPort(ende);
	    	Controller.getInstance().IDcount++;
	    	Controller.addGraphic(new GeneralizationLine(Controller.getInstance().IDcount, startpoint,endpoint), e);
	    }
	    Controller.mainFrame.repaint();
	    System.out.print("create GLine mode, mouse Released!\n");
	}

	public void mouseDragged(MouseEvent e){
	    ende = e;
	    if (startpoint != null){
	    	endpoint = new ConnectionPort(startfigure);//用來給templine使用的暫時endport
	    	endpoint.x = ende.getX();
	    	endpoint.y = ende.getY();
	    	Controller.getInstance().graphicArray.remove(templine);//移除前一次dragged加入的templine
	    	templine = new GeneralizationLine(Controller.getInstance().IDcount, startpoint,endpoint);
	    	Controller.addGraphic(templine,e);//加入templine使拉線的過程中可以看見，在mouserelease時移除
	    	Controller.mainFrame.repaint();
	    }
	    System.out.print("create GLine mode, mouse Dragged!\n");
	}

}
