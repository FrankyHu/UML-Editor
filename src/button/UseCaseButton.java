package button;

import java.awt.event.*;
import javax.swing.*;
import controller.*;

public class UseCaseButton extends JButton implements ActionListener{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UseCaseButton() {
	    this.addActionListener(this);
	    this.setRequestFocusEnabled(true);
	    this.setVerifyInputWhenFocusTarget(true);
	    this.setBorderPainted(false);
	}

	public void actionPerformed(ActionEvent e) {
	    Controller.currentMode = Controller.createUseCaseMode;
	    Controller.toolBar.initializeIcon();
	    this.setIcon(new ImageIcon("./image/usecase_down.jpg"));
	}

}
