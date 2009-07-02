package controller;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import mode.*;
import graphic.*;

public class Controller {
	private static Controller _instance = null;
	
	public static MainFrame mainFrame;
	public static MenuBar menu;
	public static ToolBar toolBar;
	public static Canvas canvas;

	public static Mode currentMode;
	public static SelectMode selectMode;
	public static ClassMode createClassMode;
	public static UseCaseMode createUseCaseMode;
	public static AssociationLineMode createAssociationLineMode;
	public static CompositionLineMode createCompositionLineMode;
	public static GeneralizationLineMode createGeneralizationLineMode;
	public static Vector graphicArray = new Vector();
	public static int IDcount = 0;

	private Controller() {
		this.mainFrame = new MainFrame();
	    this.toolBar = new ToolBar();
	    this.canvas = new Canvas();
	    this.menu = new MenuBar();
	    this.selectMode = new SelectMode();
	    this.createClassMode = new ClassMode();
	    this.createUseCaseMode = new UseCaseMode();
	    this.createAssociationLineMode = new AssociationLineMode();
	    this.createCompositionLineMode = new CompositionLineMode();
	    this.createGeneralizationLineMode = new GeneralizationLineMode();
	    
	    toolBar.selectButton.actionPerformed(null); // Make select mode as default
	    
	    Container content = mainFrame.getContentPane();
	    
	    content.setBackground(Color.white);
	    content.add(toolBar,BorderLayout.WEST);
	    content.add(this.canvas,BorderLayout.EAST);
	    mainFrame.setJMenuBar(menu);
	    mainFrame.setVisible(true);
	}
	
	public static Controller getInstance() {
        if (_instance == null)
            _instance = new Controller();

        return _instance;
    }

	public static void addGraphic(Graphic graphic, MouseEvent e) {
		if (getDeepestGraphic(e, graphic.width, graphic.height) != null){
			graphic.depth = (getDeepestGraphic(e, graphic.width, graphic.height)).depth + 1;
		}
	    Controller.graphicArray.add(graphic);
	}

	public static Graphic getDeepestGraphic(MouseEvent e, int width, int height) {
		// To obtain the deepest object in graphic
		Graphic deepestGraphic = null;
	    int tempDepth = 0;
	    for (int i = 0; i < Controller.graphicArray.size(); i++){
	    	if (((Graphic) Controller.graphicArray.get(i)).isSelected(e, width, height)) {
	    		if (tempDepth <= ((Graphic) Controller.graphicArray.get(i)).depth) {
	    			tempDepth = ((Graphic) Controller.graphicArray.get(i)).depth;
		    		deepestGraphic = ((Graphic) Controller.graphicArray.get(i));
	    		}
	    	}
	    }
	    
	    System.out.println("Current depth : " + tempDepth + "+1\n");
	    if (tempDepth == 0) {
	    	return null;
	    }
	    else {
	    	return deepestGraphic;
	    }
	}


	public static void main(String[] args){
//		Controller control = new Controller();
		Controller.getInstance();
	}

}
