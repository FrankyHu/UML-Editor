package mode;

import java.awt.event.*;

import controller.*;
import graphic.*;

public class SelectMode extends Mode {
	Region region;
	Graphic targetFigure = null;
	int targetPortNum = 0;
	MouseEvent startSelect = null;
	MouseEvent endSelect = null;
	int distX=0;
	int distY=0;

	public SelectMode() {
		
	}

	public void mouseClicked(MouseEvent e) {
		targetFigure = getTargetFigure(e);
	    selectOne(); //把選到的select
	    Controller.mainFrame.repaint();
	}

	public void mousePressed(MouseEvent e) {
	    targetFigure = getTargetFigure(e);
	    startSelect = e;
	    if (targetFigure == null) { //如果是null就畫出select region
	    	region = new Region(e.getX(), e.getY());
	    	selectOne(); //移除所有被select的物件
	    }
	    else if(targetFigure.isSelected == true) { //如果是選到已被select的figure的port
	    	targetPortNum = whichPortInside(targetFigure, startSelect);
	    }
	    Controller.mainFrame.repaint();
	}

	public void mouseReleased(MouseEvent e) {
	    if (targetFigure == null) { //如果是null表已畫出region
	    	endSelect = e;
	    	selectRegion();
	    	Controller.getInstance().graphicArray.remove(region);
	    }
	    Controller.mainFrame.repaint();
	    System.out.print("Select mode, mouse Released!\n");
	}

	public void mouseEntered(MouseEvent e) {
		System.out.print("Select mode, mouse Entered!\n");
	}
	
	public void mouseExited(MouseEvent e) {
	    System.out.print("Select mode, mouse Exited!\n");
	}
	
	public void mouseMoved(MouseEvent e) {
		System.out.print("Select mode, mouse Moved!\n");
	}
	
	public void mouseDragged(MouseEvent e) {
		endSelect = e;
	    if (targetFigure != null) {//表示有選到物件
	    	if (targetPortNum == 0) {//0表沒有按到任何的port
	    		distX =  endSelect.getX() - startSelect.getX();
	    		distY =  endSelect.getY() - startSelect.getY();
	    		startSelect = endSelect;
	    		((BaseObject)targetFigure).setPosition(distX,distY);
	    	}
	    	// graphic.Group
	    	else if (targetFigure.getClass().getName() != "UMLeditor.Group") {
	    		modifySize (((BaseObject)targetFigure),targetPortNum,endSelect);
	    	}
	    }
	    else if (targetFigure == null) { //沒有按到物件，繪出select region
	    	region.position.x = Math.min(endSelect.getX(),startSelect.getX());
	    	region.position.y = Math.min(endSelect.getY(),startSelect.getY());
	    	region.width = Math.abs(endSelect.getX() - startSelect.getX()) ;
	    	region.height = Math.abs(endSelect.getY() - startSelect.getY());
	    	Controller.getInstance().graphicArray.remove(region);//不管有沒有region先移掉
	    	Controller.getInstance().graphicArray.add(region);//把region加到figurearray中，在mouserelease時須移除
	    }
	    Controller.mainFrame.repaint();
	    System.out.print("Select mode, mouse Dragged!\n");
	}

	public void selectOne() {
		for (int i = 0; i < Controller.getInstance().graphicArray.size(); i++) {//把其他的dishighlight
			if (((Graphic) Controller.getInstance().graphicArray.get(i)) != targetFigure) {
				((Graphic) Controller.getInstance().graphicArray.get(i)).DisHighlight();
			}
	    }
	    if (targetFigure != null) {
	    	if (targetFigure.isSelected == true) {
	    		targetFigure.DisHighlight();
	    	}
	    	else {
	    		targetFigure.Highlight();
	    	}
	    }
	}

	public void selectRegion() {
		Graphic tempfigure = null;
		for (int i = 0; i < Controller.getInstance().graphicArray.size(); i++) {
			if (Controller.getInstance().graphicArray.get(i).getClass().getSuperclass().getName() == "graphic.BaseObject"){
				tempfigure = ( (BaseObject) Controller.getInstance().graphicArray.get(i));
				//判斷figure是否在region內
				if ((region.position.x <= tempfigure.position.x) && (region.position.y <= tempfigure.position.y) &&
	             ((tempfigure.position.x + tempfigure.width) <= (region.position.x + region.width)) &&
	             ((tempfigure.position.y + tempfigure.height) <= (region.position.y + region.height))) {
					if (tempfigure.isSelected == true) {
						tempfigure.DisHighlight();
					}
					else {
			            tempfigure.Highlight();
					}
				}
			}
		}
	}

	public int whichPortInside(Graphic f,MouseEvent e){
		for (int i = 1; i <= 4; i++) {
			if (f.portList[i].isSelected(e, 0, 0)) {
				return i;
			}
		}
	    return 0;
	}

	public void modifySize (BaseObject baseobject,int targetportNum,MouseEvent e) {
		int limit = 30;
	    switch(targetportNum) {
	    	case 1 : 
	    		if (e.getY() <= baseobject.position.y + baseobject.height - limit) {
	    			baseobject.height = (baseobject.position.y + baseobject.height) - e.getY();
	    			baseobject.position.y = e.getY();
	    		}
	    		break;
	    	  
	    	case 4 : 
	    		if (e.getX() <= baseobject.position.x + baseobject.width - limit) {
	    			baseobject.width = (baseobject.position.x+baseobject.width) - e.getX();
	    			baseobject.position.x = e.getX();
	    		}
	    		break;
	    	case 2 : 
	    		if (e.getX() >= baseobject.position.x + limit) {
	    			baseobject.width = e.getX() - (baseobject.position.x);
	    		}
	    	break;
	    	case 3 : 
	    		if (e.getY() >= baseobject.position.y + limit) {
	    			baseobject.height = e.getY() - (baseobject.position.y);
	    		}
	    	break;
	    }
	    baseobject.attachPort();
	}
	
}
