package mode;

import java.awt.event.*;

import controller.*;
import graphic.*;

public class UseCaseMode extends BaseObjectMode {
	public UseCaseMode() {
		
	}

	public void mouseClicked(MouseEvent e) {
		Controller.IDcount++;
		Controller.addGraphic(new UseCase(Controller.IDcount,e),e);
		Controller.mainFrame.repaint();
		System.out.print("create class mode，mouse Clicked!\n");
	}

}

