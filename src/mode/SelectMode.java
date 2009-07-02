package mode;

import java.awt.event.*;

import controller.*;
import graphic.*;

public class SelectMode extends Mode {
	Range range;
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
	    EditorController.mainFrame.repaint();
	}

	public void mousePressed(MouseEvent e) {
	    targetGraphic = getTargetGraphic(e);
	    startSelect = e;
	    if (targetGraphic == null) {
	    	// Draw select range
	    	range = new Range(e.getX(), e.getY());
	    	selectOne(); // Remove all selected object
	    }
	    else if(targetGraphic.isHighlighted == true && (targetGraphic.getClass().getSuperclass().getName() == "graphic.BasicObject")) { // If targetGraphic is selected, then find which port inside
	    	targetPortNum = selectedPort(((BasicObject) targetGraphic), startSelect);
	    }
	    EditorController.mainFrame.repaint();
	}

	public void mouseReleased(MouseEvent e) {
	    if (targetGraphic == null) { // If null, then region is draw
	    	// Range is draw
	    	endSelect = e;
	    	selectRegion();
	    	EditorController.getInstance().graphicArray.remove(range);
	    }
	    EditorController.mainFrame.repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		endSelect = e;
	    if (targetGraphic != null && (targetGraphic.getClass().getSuperclass().getName() == "graphic.BasicObject")) {// If not null, then object is selected
	    	
	    	if (targetPortNum == 0) {
	    		// Didn't press any port
	    		distX =  endSelect.getX() - startSelect.getX();
	    		distY =  endSelect.getY() - startSelect.getY();
	    		startSelect = endSelect;
	    		((BasicObject)targetGraphic).setPosition(distX, distY);
	    	}
	    	else if (targetGraphic.getClass().getName() != "graphic.CompositeObject") {
	    		modifySize (((BasicObject) targetGraphic), targetPortNum, endSelect);
	    	}
	    }
	    else if (targetGraphic != null && (targetGraphic.getClass().getName() == "graphic.CompositeObject")) {
	    	if (targetPortNum == 0) {
	    		// Didn't press any port
	    		distX =  endSelect.getX() - startSelect.getX();
	    		distY =  endSelect.getY() - startSelect.getY();
	    		startSelect = endSelect;
	    		((CompositeObject)targetGraphic).setPosition(distX, distY);
	    	}
	    }
	    else if (targetGraphic == null) {
	    	// Didn't press any object, draw select region
	    	range.graphicPoint.x = Math.min(endSelect.getX(), startSelect.getX());
	    	range.graphicPoint.y = Math.min(endSelect.getY(), startSelect.getY());
	    	range.width = Math.abs(endSelect.getX() - startSelect.getX()) ;
	    	range.height = Math.abs(endSelect.getY() - startSelect.getY());
	    	EditorController.getInstance().graphicArray.remove(range); // Remove region first
	    	EditorController.getInstance().graphicArray.add(range); // Add region to graphicArray, and remove it when mouse release
	    }
	    EditorController.mainFrame.repaint();
	}

	public void selectOne() {
		// Disable highlight for all graphics
		for (int i = 0; i < EditorController.getInstance().graphicArray.size(); i++) {
			if (((Graphic) EditorController.getInstance().graphicArray.get(i)) != targetGraphic) {
				((Graphic) EditorController.getInstance().graphicArray.get(i)).disableHighlight();
			}
	    }
		
	    if (targetGraphic != null) {
	    	if (targetGraphic.isHighlighted == true) {
	    		targetGraphic.disableHighlight();
	    	}
	    	else {
	    		targetGraphic.highlight();
	    	}
	    }
	}

	public void selectRegion() {
		Graphic tempGraphic = null;
		for (int i = 0; i < EditorController.getInstance().graphicArray.size(); i++) {
			if (EditorController.getInstance().graphicArray.get(i).getClass().getSuperclass().getName() == "graphic.BasicObject"){
				tempGraphic = ( (BasicObject) EditorController.getInstance().graphicArray.get(i));

				if ((range.graphicPoint.x <= tempGraphic.graphicPoint.x) && (range.graphicPoint.y <= tempGraphic.graphicPoint.y) &&
	             ((tempGraphic.graphicPoint.x + tempGraphic.width) <= (range.graphicPoint.x + range.width)) &&
	             ((tempGraphic.graphicPoint.y + tempGraphic.height) <= (range.graphicPoint.y + range.height))) {
					// Graphic is in region
					if (tempGraphic.isHighlighted == true) {
						tempGraphic.disableHighlight();
					}
					else {
			            tempGraphic.highlight();
					}
				}
			}
			
			if (EditorController.getInstance().graphicArray.get(i).getClass().getName() == "graphic.CompositeObject") {
				tempGraphic = ( (CompositeObject) EditorController.getInstance().graphicArray.get(i));

				if ((range.graphicPoint.x <= tempGraphic.graphicPoint.x) && (range.graphicPoint.y <= tempGraphic.graphicPoint.y) &&
	             ((tempGraphic.graphicPoint.x + tempGraphic.width) <= (range.graphicPoint.x + range.width)) &&
	             ((tempGraphic.graphicPoint.y + tempGraphic.height) <= (range.graphicPoint.y + range.height))) {
					// Graphic is in region
					if (tempGraphic.isHighlighted == true) {
						tempGraphic.disableHighlight();
					}
					else {
			            tempGraphic.highlight();
					}
				}
			}
		}
	}

	public int selectedPort(BasicObject basicObject,MouseEvent e){
		for (int i = 1; i <= 4; i++) {
			if (basicObject.portList[i].isSelected(e, 0, 0)) {
				return i;
			}
		}
	    return 0;
	}

	public void modifySize (BasicObject baseObject,int targetPortNum,MouseEvent e) {
		int limit = 30;
	    switch(targetPortNum) {
	    	case 1 : 
	    		if (e.getY() <= baseObject.graphicPoint.y + baseObject.height - limit) {
	    			baseObject.height = (baseObject.graphicPoint.y + baseObject.height) - e.getY();
	    			baseObject.graphicPoint.y = e.getY();
	    		}
	    		break;
	    		
	    	case 2 : 
	    		if (e.getX() >= baseObject.graphicPoint.x + limit) {
	    			baseObject.width = e.getX() - (baseObject.graphicPoint.x);
	    		}
	    		break;
	    	
	    	case 3 : 
	    		if (e.getY() >= baseObject.graphicPoint.y + limit) {
	    			baseObject.height = e.getY() - (baseObject.graphicPoint.y);
	    		}
	    		break;
	    	
	    	case 4 : 
	    		if (e.getX() <= baseObject.graphicPoint.x + baseObject.width - limit) {
	    			baseObject.width = (baseObject.graphicPoint.x + baseObject.width) - e.getX();
	    			baseObject.graphicPoint.x = e.getX();
	    		}
	    		break;
	    	default:
	    		break;
	    }
	    baseObject.attachPort();
	}
	
	// Unused method
	public void mouseEntered(MouseEvent e) {
	
	}
	
	public void mouseExited(MouseEvent e) {

	}
	
	public void mouseMoved(MouseEvent e) {

	}
	
}
