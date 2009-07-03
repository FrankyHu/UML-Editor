package button;

import java.awt.event.*;
import javax.swing.*;
import controller.*;

public class SelectButton extends JButton implements ActionListener{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SelectButton() {
	    this.addActionListener(this);
	    this.setRequestFocusEnabled(true);
	    this.setVerifyInputWhenFocusTarget(true);
	    this.setBorderPainted(false);
	}

	public void actionPerformed(ActionEvent e) {
		EditorController.currentMode = EditorController.selectMode;
	    EditorController.toolBar.initializeIcon();
	    this.setIcon(new ImageIcon("./image/select_down.jpg"));
	}
}