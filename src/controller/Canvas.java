package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
	    this.setPreferredSize(new Dimension(700, 600));
	}

	public void mouseClicked(MouseEvent e) {
		Controller.currentMode.mouseClicked(e);
	}
	
	public void mousePressed(MouseEvent e) {
	    Controller.currentMode.mousePressed(e);
	}
	
	public void mouseReleased(MouseEvent e) {
	    Controller.currentMode.mouseReleased(e);
	}
	
	public void mouseEntered(MouseEvent e) {
	    Controller.currentMode.mouseEntered(e);
	}
	
	public void mouseExited(MouseEvent e) {
		Controller.currentMode.mouseExited(e);
	}
	
	public void mouseMoved(MouseEvent e) {
	    Controller.currentMode.mouseMoved(e);
	}
	
	public void mouseDragged(MouseEvent e) {
	    Controller.currentMode.mouseDragged(e);
	}

	public void paint(Graphics g) {
		for (int i = 0; i < Controller.getInstance().graphicArray.size(); i++) {
			((Graphic) Controller.getInstance().graphicArray.get(i)).draw(g);
	    }
	}
}
