package button;

import java.awt.event.*;
import javax.swing.*;
import controller.*;

public class GeneralizationButton extends JButton implements ActionListener{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GeneralizationButton() {
	    this.addActionListener(this);
	    this.setRequestFocusEnabled(true);
	    this.setVerifyInputWhenFocusTarget(true);
	    this.setBorderPainted(false);
	}

	public void actionPerformed(ActionEvent e) {
	    Controller.currentMode = Controller.createGeneralizationLineMode;
	    Controller.toolBar.initializeIcon();
	    this.setIcon(new ImageIcon("./image/generalization_down.jpg"));
	}
	  
}
