package controller;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import graphic.*;

public class MoreMenu extends JMenu implements ActionListener{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuItem group = new JMenuItem();
	JMenuItem ungroup = new JMenuItem();
	JMenuItem rename = new JMenuItem();
	JMenuItem delete = new JMenuItem();

	public MoreMenu() {
		this.setText("More");
		this.add(rename).setText("Rename");
		this.add(group).setText("Group");
	    this.add(ungroup).setText("Ungroup");
	    this.add(delete).setText("Delete");
	    
	    rename.addActionListener(this);
	    group.addActionListener(this);
	    ungroup.addActionListener(this);
	    delete.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == group) {
		      group();
		}
	    else if (e.getSource() == ungroup) {
		      ungroup();
	    }
	    else if (e.getSource() == rename) {
		      rename();
	    }
	    else if (e.getSource() == delete) {
		      delete();
	    }
	  }

	void group() {
	    boolean flag = false;
	    CompositeObject group = null;
	    for (int i = 0; i < Controller.graphicArray.size(); i++) {
	      if (((Graphic) Controller.graphicArray.get(i)).isSelected == true) { //if graphic select = 1
	    	  if (flag == false) {
	    		  group = new CompositeObject();
	        }
	        flag = true;
	        group.AddBaseObject(((Graphic) Controller.graphicArray.get(i)));
	        System.out.println("figure " +( (Graphic) Controller.graphicArray.get(i)).graphicID +"Has been removed");
	        Controller.graphicArray.remove((Graphic) Controller.graphicArray.get(i));
	        i--;
	      }
	    }
	    if (group != null) {
	    	group.DisHighlight();
	    	Controller.graphicArray.add(group); //把新的group加到figure的vector
	    }
	    System.out.println("flag == " + flag);
	    Controller.mainFrame.repaint();
	}

	public void ungroup() {
		Vector ungrouplist = new Vector();//用來計算要被ungroup的個數及暫存物件
		for (int i = 0; i < Controller.graphicArray.size(); i++) {
			if ((Controller.graphicArray.get(i).getClass().getName() == "graphic.Group") && (((CompositeObject)Controller.graphicArray.get(i)).isSelected == true)) {
				ungrouplist.add(Controller.graphicArray.get(i));
			}
		}
		System.out.println("Srating ungroup");
		if (ungrouplist.size() == 1){//唯一一個物件被選取
			for (int j = 0; j < ((CompositeObject) ungrouplist.get(0)).groupArray.size(); j++) {
				System.out.print("元件編號 : " + j);
				System.out.println(" 型別 = " + ((Graphic) ((CompositeObject) ungrouplist.get(0)).groupArray.get(j)).getClass().getName());
				((Graphic) ((CompositeObject) ungrouplist.get(0)).groupArray.get(j)).isSelected = false;
				Controller.graphicArray.add( ( (CompositeObject) ungrouplist.get(0)).groupArray.get(j));
			}
			Controller.graphicArray.remove( ( (CompositeObject) ungrouplist.get(0)));
			DeleteOrphanLine( ( (CompositeObject) ungrouplist.get(0)));
		}
		Controller.mainFrame.repaint();
	}


	void rename() {
		for (int i = 0; i < Controller.graphicArray.size(); i++) {
			if ( ( (Graphic) Controller.graphicArray.get(i)).isSelected == true) {
				String name = JOptionPane.showInputDialog("請輸入名稱");
				if (name != null) {
			          ((Graphic) Controller.graphicArray.get(i)).graphicName = name;
				}
			}
	    }
	    Controller.mainFrame.repaint();
	}

	public void delete (){  //事件的傾聽者(處理者)必須提供的method
		Graphic tempfigure = null;
		for (int i = 0; i < Controller.graphicArray.size(); i++) {
			tempfigure = ( (Graphic) Controller.graphicArray.get(i));
			if (tempfigure.isSelected == true) {
				removeFigure(tempfigure);
				i--;
			}
			Controller.mainFrame.repaint();
		}
	}

	public void removeFigure(Graphic figure){
		if (figure.getClass().getName() == "graphic.Group") {
			for (int j = 0;j < ((CompositeObject)figure).groupArray.size() ;j++){
				if(((CompositeObject)figure).groupArray.get(j).getClass().getName() == "graphic.Group") { //如果group中還有group
					removeFigure((Graphic)((CompositeObject)figure).groupArray.get(j));
				}
				removeFigure((Graphic)((CompositeObject)figure).groupArray.get(j));
			}
	  }
	  Controller.graphicArray.remove(figure);
	  DeleteOrphanLine(figure);
	  Controller.mainFrame.repaint();
	}

	public void DeleteOrphanLine(Graphic f){
		for (int i = 0; i < Controller.graphicArray.size(); i++) {
			if ( (Controller.graphicArray.get(i).getClass().getSuperclass().getName() == "graphic.Line") && ((((Line) Controller.graphicArray.get(i)).startpoint.port_fig == f) || (((Line) Controller.graphicArray.get(i)).endpoint.port_fig == f))){
				Controller.graphicArray.remove(Controller.graphicArray.get(i));
				i--;
				Controller.mainFrame.repaint();
			}
		}
	}

}
