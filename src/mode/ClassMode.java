package mode;

import java.awt.event.*;

import controller.*;
import graphic.Class;


public class ClassMode extends BaseObjectMode {
	public ClassMode() {
		
	}

	public void mouseClicked(MouseEvent e){
		Controller.IDcount++;
		Controller.addGraphic(new Class(Controller.IDcount,e), e);
		Controller.mainFrame.repaint();
		System.out.println("size = "+Controller.graphicArray.size());
		System.out.print("create class mode, mouse Clicked!\n");
	}

}
