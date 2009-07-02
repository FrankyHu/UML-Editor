package view;

import javax.swing.*;

public class MenuBar extends JMenuBar {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuBar() {
		this.add(new MoreMenu());
	}
	
}

