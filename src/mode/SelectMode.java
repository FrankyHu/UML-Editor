package mode;

import java.awt.event.*;

import controller.*;
import graphic.*;

public class SelectMode extends Mode {
	Region region;
	Graphic targetGraphic = null;
	int targetPortNum = 0;
	MouseEvent startSelect = null;
	MouseEvent endSelect = null;
	int distX=0;
	int distY=0;

	public SelectMode() {
		
	}

	public void mouseClicked(MouseEvent e) {
		targetGraphic = getTargetGraphic(e);
	    selectOne(); // Select target
	    Controller.mainFrame.repaint();
	}

	public void mousePressed(MouseEvent e) {
	    targetGraphic = getTargetGraphic(e);
	    startSelect = e;
	    if (targetGraphic == null) { // if null, then draw select region
	    	region = new Region(e.getX(), e.getY());
	    	selectOne(); // Remove all selected object
	    }
	    else if(targetGraphic.isSelected == true) { // If targetGraphic is selected, then find which port inside
	    	targetPortNum = whichPortInside(targetGraphic, startSelect);
	    }
	    Controller.mainFrame.repaint();
	}

	public void mouseReleased(MouseEvent e) {
	    if (targetGraphic == null) { // If null, then region is draw
	    	endSelect = e;
	    	selectRegion();
	    	Controller.getInstance().graphicArray.remove(region);
	    }
	    Controller.mainFrame.repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		endSelect = e;
	    if (targetGraphic != null) {// If not null, then object is selected
	    	if (targetPortNum == 0) {
	    		// Didn't press any port
	    		distX =  endSelect.getX() - startSelect.getX();
	    		distY =  endSelect.getY() - startSelect.getY();
	    		startSelect = endSelect;
	    		((BaseObject)targetGraphic).setPosition(distX, distY);
	    	}
	    	else if (targetGraphic.getClass().getName() != "graphic.CompositeObject") {
	    		modifySize (((BaseObject)targetGraphic), targetPortNum, endSelect);
	    	}
	    }
	    else if (targetGraphic == null) {
	    	// Didn't press any object, draw select region
	    	region.position.x = Math.min(endSelect.getX(), startSelect.getX());
	    	region.position.y = Math.min(endSelect.getY(), startSelect.getY());
	    	region.width = Math.abs(endSelect.getX() - startSelect.getX()) ;
	    	region.height = Math.abs(endSelect.getY() - startSelect.getY());
	    	Controller.getInstance().graphicArray.remove(region); // Remove region first
	    	Controller.getInstance().graphicArray.add(region); // Add region to graphicArray, and remove it when mouse release
	    }
	    Controller.mainFrame.repaint();
	}

	public void selectOne() {
		// Disable highlight for all graphics
		for (int i = 0; i < Controller.getInstance().graphicArray.size(); i++) {
			if (((Graphic) Controller.getInstance().graphicArray.get(i)) != targetGraphic) {
				((Graphic) Controller.getInstance().graphicArray.get(i)).disableHighlight();
			}
	    }
		
	    if (targetGraphic != null) {
	    	if (targetGraphic.isSelected == true) {
	    		targetGraphic.disableHighlight();
	    	}
	    	else {
	    		targetGraphic.highlight();
	    	}
	    }
	}

	public void selectRegion() {
		Graphic tempfigure = null;
		for (int i = 0; i < Controller.getInstance().graphicArray.size(); i++) {
			if (Controller.getInstance().graphicArray.get(i).getClass().getSuperclass().getName() == "graphic.BaseObject"){
				tempfigure = ( (BaseObject) Controller.getInstance().graphicArray.get(i));

				if ((region.position.x <= tempfigure.position.x) && (region.position.y <= tempfigure.position.y) &&
	             ((tempfigure.position.x + tempfigure.width) <= (region.position.x + region.width)) &&
	             ((tempfigure.position.y + tempfigure.height) <= (region.position.y + region.height))) {
					// Graphic is in region
					if (tempfigure.isSelected == true) {
						tempfigure.disableHighlight();
					}
					else {
			            tempfigure.highlight();
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
	
	// Unused method
	public void mouseEntered(MouseEvent e) {
	
	}
	
	public void mouseExited(MouseEvent e) {

	}
	
	public void mouseMoved(MouseEvent e) {

	}
	
}
