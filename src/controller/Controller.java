package controller;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import mode.*;
import graphic.*;

public class Controller {
	public Vector graphicArray = new Vector();
	public int IDcount = 0;
	
	private static Controller _instance = null;
	
	public static MainFrame mainFrame;
	public static MenuBar menu;
	public static ToolBar toolBar;
	public static Canvas canvas;

	public static Mode currentMode;
	public static SelectMode selectMode;
	public static ClassMode classMode;
	public static UseCaseMode caseMode;
	public static AssociationLineMode associationLineMode;
	public static CompositionLineMode compositionLineMode;
	public static GeneralizationLineMode generalizationLineMode;

	private Controller() {
		mainFrame = new MainFrame();
	    toolBar = new ToolBar();
	    canvas = new Canvas();
	    menu = new MenuBar();
	    selectMode = new SelectMode();
	    classMode = new ClassMode();
	    caseMode = new UseCaseMode();
	    associationLineMode = new AssociationLineMode();
	    compositionLineMode = new CompositionLineMode();
	    generalizationLineMode = new GeneralizationLineMode();
	    
	    toolBar.selectButton.actionPerformed(null); // Make select mode as default
	    
	    Container content = mainFrame.getContentPane();
	    
	    content.setBackground(Color.white);
	    content.add(toolBar,BorderLayout.WEST);
	    content.add(canvas,BorderLayout.EAST);
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
	    Controller.getInstance().graphicArray.add(graphic);
	}

	public static Graphic getDeepestGraphic(MouseEvent e, int width, int height) {
		// To obtain the deepest object in graphic
		Graphic deepestGraphic = null;
	    int tempDepth = 0;
	    for (int i = 0; i < Controller.getInstance().graphicArray.size(); i++){
	    	if (((Graphic) Controller.getInstance().graphicArray.get(i)).isSelected(e, width, height)) {
	    		if (tempDepth <= ((Graphic) Controller.getInstance().graphicArray.get(i)).depth) {
	    			tempDepth = ((Graphic) Controller.getInstance().graphicArray.get(i)).depth;
		    		deepestGraphic = ((Graphic) Controller.getInstance().graphicArray.get(i));
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
