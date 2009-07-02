package controller;

import java.awt.*;
import javax.swing.*;
import button.*;

public class ToolBar extends JPanel{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	SelectButton selectButton = new SelectButton();
	AssociationButton associationButton = new AssociationButton();
	GeneralizationButton generalizationButton = new GeneralizationButton();
	CompositionButton compositionButton = new CompositionButton();
	ClassButton classButton = new ClassButton();
	UseCaseButton useCaseButton = new UseCaseButton();

	public ToolBar() {
		this.setBackground(Color.darkGray);
		this.setMinimumSize(new Dimension(10, 10));
		this.setPreferredSize(new Dimension(100, 600));
		this.setVisible(true);
		this.setLayout(new GridLayout(6,1));
		this.add(selectButton);
		this.add(associationButton);
		this.add(generalizationButton);
		this.add(compositionButton);
		this.add(classButton);
		this.add(useCaseButton);
		initializeIcon();
	}

	public void initializeIcon() {
		this.selectButton.setIcon(new ImageIcon("./image/select.gif"));
		this.associationButton.setIcon(new ImageIcon("./image/association.gif"));
		this.generalizationButton.setIcon(new ImageIcon("./image/generalization.gif"));
		this.compositionButton.setIcon(new ImageIcon("./image/composition.gif"));
		this.classButton.setIcon(new ImageIcon("./image/Class.gif"));
		this.useCaseButton.setIcon(new ImageIcon("./image/UseCase.gif"));
	}
}
