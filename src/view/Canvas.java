package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controller.EditorController;
import graphic.*;


public class Canvas extends JPanel implements MouseListener, MouseMotionListener {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Canvas() {
	    this.setBackground(Color.white);
	    this.setBorder(BorderFactory.createTitledBorder("Canvas"));
	    this.setVisible(true);
	    this.addMouseListener(this);
	    this.addMouseMotionListener(this);
	    this.setBackground(Color.white);
	    this.setPreferredSize(new Dimension(924, 660));
	}

	public void mouseClicked(MouseEvent e) {
		EditorController.currentMode.mouseClicked(e);
	}
	
	public void mousePressed(MouseEvent e) {
	    EditorController.currentMode.mousePressed(e);
	}
	
	public void mouseReleased(MouseEvent e) {
	    EditorController.currentMode.mouseReleased(e);
	}
	
	public void mouseEntered(MouseEvent e) {
	    EditorController.currentMode.mouseEntered(e);
	}
	
	public void mouseExited(MouseEvent e) {
		EditorController.currentMode.mouseExited(e);
	}
	
	public void mouseMoved(MouseEvent e) {
	    EditorController.currentMode.mouseMoved(e);
	}
	
	public void mouseDragged(MouseEvent e) {
	    EditorController.currentMode.mouseDragged(e);
	}

	public void paint(Graphics g) {
		for (int i = 0; i < EditorController.getInstance().graphicArray.size(); i++) {
			((Graphic) EditorController.getInstance().graphicArray.get(i)).draw(g);
	    }
	}
}
