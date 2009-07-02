package mode;

import java.awt.event.*;

import controller.*;
import graphic.Class;


public class ClassMode extends ObjectMode {
	public ClassMode() {
		
	}

	public void mouseClicked(MouseEvent e){
		Controller.getInstance().IDcount++;
		Controller.addGraphic(new Class(Controller.getInstance().IDcount,e), e);
		Controller.mainFrame.repaint();
		System.out.println("size = "+Controller.getInstance().graphicArray.size());
	}

}
