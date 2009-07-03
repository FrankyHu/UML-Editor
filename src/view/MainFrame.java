package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controller.EditorController;

public class MainFrame extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		
		this.addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						System.exit(0);
					}
				}
		);
		
		this.setName("UML Editor");
		this.setTitle("UML Editor");
		this.setSize(1024, 660);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		
		// Make sure frame size < screen size
		if (frameSize.height > screenSize.height){
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width){
			frameSize.width = screenSize.width;
		}

		this.setVisible(true);

	}
	
	public void paint(){
		EditorController.menu.repaint();
		EditorController.toolBar.repaint();
		EditorController.canvas.repaint();
	}

}
