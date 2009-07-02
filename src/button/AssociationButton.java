package button;

import java.awt.event.*;
import javax.swing.*;
import controller.*;

public class AssociationButton extends JButton implements ActionListener{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AssociationButton() {
	    this.addActionListener(this);
	    this.setRequestFocusEnabled(true);
	    this.setVerifyInputWhenFocusTarget(true);
	    this.setBorderPainted(false);
	}

	public void actionPerformed(ActionEvent e){
	    System.out.println("AssociationButton Pressed");
	    Controller.currentMode = Controller.createALineMode;
	    Controller.toolBar.initializeIcon();
	    this.setIcon(new ImageIcon("./image/association_b.gif"));
	}
	  
}
