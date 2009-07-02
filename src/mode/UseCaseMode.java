package mode;

import java.awt.event.*;

import controller.*;
import graphic.*;

public class UseCaseMode extends Mode {
	public UseCaseMode() {
		
	}

	public void mouseClicked(MouseEvent e) {
		EditorController.getInstance().lineCounter++;
		EditorController.getInstance().useCaseCounter++;
		EditorController.getInstance().addGraphic(new UseCase(EditorController.getInstance().useCaseCounter, e), e);
		EditorController.mainFrame.repaint();
	}
	
	// Unused method
	public void mousePressed(MouseEvent e) {

	}
	
	public void mouseReleased(MouseEvent e) {

	}
	
	public void mouseEntered(MouseEvent e) {

	}
	
	public void mouseExited(MouseEvent e) {

	}
	
	public void mouseMoved(MouseEvent e) {

	}
	
	public void mouseDragged(MouseEvent e) {

	}

}

