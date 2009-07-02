package controller;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JOptionPane;

import view.Canvas;
import view.MainFrame;
import view.MenuBar;
import view.ToolBar;

import mode.*;
import graphic.*;

public class EditorController {
	public Vector graphicArray = new Vector();

	public int classCounter = 0;
	public int useCaseCounter = 0;
	public int compositeCounter = 0;
	public int lineCounter = 0;
	
	private static EditorController _instance = null;
	
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

	private EditorController() {
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
	
	public static EditorController getInstance() {
        if (_instance == null)
            _instance = new EditorController();

        return _instance;
    }

	public void addGraphic(Graphic graphic, MouseEvent e) {
		Graphic haveGraphic = EditorController.getInstance().getDeepestGraphic(e, graphic.width, graphic.height);
		if (haveGraphic != null){
			graphic.depth = haveGraphic.depth + 1;
		}
	    EditorController.getInstance().graphicArray.add(graphic);
	}

	public Graphic getDeepestGraphic(MouseEvent e, int width, int height) {
		// To obtain the deepest object in graphic
		// If width = 0 and height = 0, then we have a point. Else, we have a rectangle
		Graphic deepestGraphic = null;
	    int depth = 0;
	    for (int i = 0; i < EditorController.getInstance().graphicArray.size(); i++) {
	    	Graphic temp = ((Graphic) EditorController.getInstance().graphicArray.get(i));
	    	if (temp.isSelected(e, width, height)) {
	    		if (depth <= temp.depth) {
	    			depth = temp.depth;
		    		deepestGraphic = temp;
	    		}
	    	}
	    }
	    
	    if (depth == 0) {
	    	return null;
	    }
	    else {
	    	return deepestGraphic;
	    }
	}
	
	public void rename() {
		for (int i = 0; i < EditorController.getInstance().graphicArray.size(); i++) {
			Graphic temp = ((Graphic) EditorController.getInstance().graphicArray.get(i));
			if (temp.isHighlighted == true) {
				String name = JOptionPane.showInputDialog("Please input name:");
				if (name != null) {
					temp.graphicName = name;
				}
			}
	    }
	    EditorController.mainFrame.repaint();
	}

	public void group() {
	    boolean flag = false;
	    CompositeObject group = null;
	    for (int i = 0; i < EditorController.getInstance().graphicArray.size(); i++) {
	    	Graphic temp = ((Graphic) EditorController.getInstance().graphicArray.get(i));
	    	if (temp.isHighlighted == true) { // If graphic select = 1
	    		if (flag == false) {
	    			group = new CompositeObject();
	    		}
	    		flag = true;
	    		group.addBasicObject(temp);
	    		// System.out.println("graphic " +( (Graphic) Controller.getInstance().graphicArray.get(i)).graphicID +"Has been removed");
	    		EditorController.getInstance().graphicArray.remove(temp);
	    		i--;
	    	}
	    }
	    if (group != null) {
	    	group.disableHighlight();
	    	EditorController.getInstance().graphicArray.add(group);
	    }
	    // System.out.println("flag == " + flag);
	    EditorController.mainFrame.repaint();
	}
	
	public void ungroup() {
		Vector ungroupArray = new Vector();
		for (int i = 0; i < EditorController.getInstance().graphicArray.size(); i++) {
			if ((EditorController.getInstance().graphicArray.get(i).getClass().getName() == "graphic.CompositeObject") && (((CompositeObject) EditorController.getInstance().graphicArray.get(i)).isHighlighted == true)) {
				ungroupArray.add(EditorController.getInstance().graphicArray.get(i));
			}
		}

		if (ungroupArray.size() == 1) { 
			for (int j = 0; j < ((CompositeObject) ungroupArray.get(0)).groupArray.size(); j++) {
				// System.out.print("元件編號 : " + j);
				// System.out.println(" 型別 = " + ((Graphic) ((CompositeObject) ungrouplist.get(0)).groupArray.get(j)).getClass().getName());
				((Graphic) ((CompositeObject) ungroupArray.get(0)).groupArray.get(j)).isHighlighted = false;
				EditorController.getInstance().graphicArray.add(((CompositeObject) ungroupArray.get(0)).groupArray.get(j));
			}
			EditorController.getInstance().graphicArray.remove(((CompositeObject) ungroupArray.get(0)));
		}
		EditorController.mainFrame.repaint();
	}

	public static void main(String[] args){
//		Controller control = new Controller();
		EditorController.getInstance();
	}

}
