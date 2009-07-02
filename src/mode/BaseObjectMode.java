package mode;

import java.awt.event.*;


public class BaseObjectMode extends Mode{
	public BaseObjectMode() {

	}

	public void mouseClicked(MouseEvent e){
		System.out.print("create base object mode, mouse Clicked!\n");
	}
	
	public void mousePressed(MouseEvent e){
		System.out.print("create base object mode mode, mouse Pressed!\n");
	}
	
	public void mouseReleased(MouseEvent e){
		System.out.print("create base object mode, mouse Released!\n");
	}
	
	public void mouseEntered(MouseEvent e){
		System.out.print("create base object mode, mouse Entered!\n");
	}
	
	public void mouseExited(MouseEvent e){
	    System.out.print("create base object mode, mouse Exited!\n");
	}
	
	public void mouseMoved(MouseEvent e){
		System.out.print("create base object mode, mouse Moved!\n");
	}
	
	public void mouseDragged(MouseEvent e){
		System.out.print("create base object mode, mouse Dragged!\n");
	}

}
