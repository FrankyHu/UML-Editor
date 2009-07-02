package button;

import java.awt.event.*;
import javax.swing.*;
import controller.*;

public class ClassButton extends JButton implements ActionListener{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClassButton() {
	    this.addActionListener(this);
	    this.setRequestFocusEnabled(true);
	    this.setVerifyInputWhenFocusTarget(true);
	    this.setBorderPainted(false);
	}

	public void actionPerformed(ActionEvent e){
	    System.out.println("ClassButton Pressed");
	    Controller.currentMode = Controller.createClassMode;
	    Controller.toolBar.initializeIcon();
	    this.setIcon(new ImageIcon("./image/class_down.jpg"));
	}
	  
}
