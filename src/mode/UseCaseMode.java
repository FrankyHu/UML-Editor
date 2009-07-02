package mode;

import java.awt.event.*;

import controller.*;
import graphic.*;

public class UseCaseMode extends BaseObjectMode {
	public UseCaseMode() {
		
	}

	public void mouseClicked(MouseEvent e) {
		Controller.getInstance().IDcount++;
		Controller.addGraphic(new UseCase(Controller.getInstance().IDcount,e), e);
		Controller.mainFrame.repaint();
		System.out.print("create class mode, mouse Clicked!\n");
	}

}
