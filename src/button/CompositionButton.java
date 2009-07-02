package button;

import java.awt.event.*;
import javax.swing.*;
import controller.*;

public class CompositionButton extends JButton implements ActionListener{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompositionButton() {
	    this.addActionListener(this);
	    this.setRequestFocusEnabled(true);
	    this.setVerifyInputWhenFocusTarget(true);
	    this.setBorderPainted(false);
	}

	public void actionPerformed(ActionEvent e){
	    System.out.println("CompositionButton Pressed");
	    Controller.currentMode = Controller.createCompositionLineMode;
	    Controller.toolBar.initializeIcon();
	    this.setIcon(new ImageIcon("./image/composition_down.jpg"));
	}
	  
}
