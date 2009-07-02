package mode;

import java.awt.event.*;

import controller.*;
import graphic.Class;

public class ClassMode extends Mode {
	public ClassMode() {
		
	}

	public void mouseClicked(MouseEvent e){
		EditorController.getInstance().lineCounter++;
		EditorController.getInstance().classCounter++;
		EditorController.getInstance().addGraphic(new Class(EditorController.getInstance().classCounter, e), e);
		EditorController.mainFrame.repaint();
		// System.out.println("size = "+ EditorController.getInstance().graphicArray.size());
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
