package mode;

import java.awt.event.*;

import controller.*;
import graphic.*;

abstract public class Mode implements MouseListener, MouseMotionListener {
	public Mode() {
		
	}

	abstract public void mouseClicked(MouseEvent e);
	abstract public void mousePressed(MouseEvent e);
	abstract public void mouseReleased(MouseEvent e);
	abstract public void mouseEntered(MouseEvent e);
	abstract public void mouseExited(MouseEvent e);
	abstract public void mouseMoved(MouseEvent e);
	abstract public void mouseDragged(MouseEvent e);

	public Graphic getTargetGraphic(MouseEvent e){
		return Controller.getDeepestGraphic(e, 0, 0);
	}

}
