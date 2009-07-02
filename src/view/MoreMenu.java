package view;

import java.awt.event.*;
import javax.swing.*;

import controller.*;

public class MoreMenu extends JMenu implements ActionListener{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JMenuItem rename = new JMenuItem();
	JMenuItem group = new JMenuItem();
	JMenuItem ungroup = new JMenuItem();

	public MoreMenu() {
		this.setText("More");
		this.add(rename).setText("Rename");
		this.add(group).setText("Group");
	    this.add(ungroup).setText("Ungroup");
	    
	    rename.addActionListener(this);
	    group.addActionListener(this);
	    ungroup.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rename) {
	    	EditorController.getInstance().rename();
		}
	    else if (e.getSource() == group) {
	    	EditorController.getInstance().group();
	    }
	    else if (e.getSource() == ungroup) {
	    	EditorController.getInstance().ungroup();
	    }
	  }

}
