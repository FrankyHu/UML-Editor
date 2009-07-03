package mode;

import java.awt.event.*;

import controller.*;
import graphic.*;

public class SelectMode extends Mode {
	Range range;
	Graphic targetGraphic;
	int targetPortNum = 0;
	MouseEvent startSelect;
	MouseEvent endSelect;
	int distanceX = 0;
	int distanceY = 0;

	public SelectMode() {
		
	}

	public void mouseClicked(MouseEvent e) {
		targetGraphic = EditorController.getInstance().getDeepestGraphic(e, 0, 0);
	    selectThisGraphic(); // Select target
	    EditorController.mainFrame.repaint();
	}

	public void mousePressed(MouseEvent e) {
		targetGraphic = EditorController.getInstance().getDeepestGraphic(e, 0, 0);
	    startSelect = e;
	    if (targetGraphic == null) {
	    	// Draw select range
	    	range = new Range(e.getX(), e.getY());
	    	selectThisGraphic(); // Remove all selected object
	    }
	    else if(targetGraphic.isHighlighted == true && (targetGraphic.getClass().getSuperclass().getName() == "graphic.BasicObject")) { // If targetGraphic is selected, then find which port inside
	    	targetPortNum = selectedPort(((BasicObject) targetGraphic), startSelect);
	    }
	    EditorController.mainFrame.repaint();
	}

	public void mouseReleased(MouseEvent e) {
	    if (targetGraphic == null) {
	    	// Range is draw
	    	endSelect = e;
	    	selectRange();
	    	EditorController.getInstance().graphicArray.remove(range);
	    }
	    EditorController.mainFrame.repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		endSelect = e;
	    if (targetGraphic != null && (targetGraphic.getClass().getSuperclass().getName() == "graphic.BasicObject")) {
	    	// Object is selected
	    	if (targetPortNum == 0) {
	    		// Didn't press any port
	    		distanceX =  endSelect.getX() - startSelect.getX();
	    		distanceY =  endSelect.getY() - startSelect.getY();
	    		startSelect = endSelect;
	    		((BasicObject) targetGraphic).setPosition(distanceX, distanceY);
	    	}
	    }
	    else if (targetGraphic != null && (targetGraphic.getClass().getName() == "graphic.CompositeObject")) {
	    	// Object is selected
	    	if (targetPortNum == 0) {
	    		// Didn't press any port
	    		distanceX =  endSelect.getX() - startSelect.getX();
	    		distanceY =  endSelect.getY() - startSelect.getY();
	    		startSelect = endSelect;
	    		((CompositeObject) targetGraphic).setPosition(distanceX, distanceY);
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

	public void selectThisGraphic() {
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

	public void selectRange() {
		Graphic temp;
		for (int i = 0; i < EditorController.getInstance().graphicArray.size(); i++) {
			if (EditorController.getInstance().graphicArray.get(i).getClass().getSuperclass().getName() == "graphic.BasicObject"){
				temp = ( (BasicObject) EditorController.getInstance().graphicArray.get(i));

				if ((range.graphicPoint.x <= temp.graphicPoint.x) && (range.graphicPoint.y <= temp.graphicPoint.y) &&
	             ((temp.graphicPoint.x + temp.width) <= (range.graphicPoint.x + range.width)) &&
	             ((temp.graphicPoint.y + temp.height) <= (range.graphicPoint.y + range.height))) {
					// Graphic is in region
					if (temp.isHighlighted == true) {
						temp.disableHighlight();
					}
					else {
			            temp.highlight();
					}
				}
			}
			
			if (EditorController.getInstance().graphicArray.get(i).getClass().getName() == "graphic.CompositeObject") {
				temp = ( (CompositeObject) EditorController.getInstance().graphicArray.get(i));

				if ((range.graphicPoint.x <= temp.graphicPoint.x) && (range.graphicPoint.y <= temp.graphicPoint.y) &&
	             ((temp.graphicPoint.x + temp.width) <= (range.graphicPoint.x + range.width)) &&
	             ((temp.graphicPoint.y + temp.height) <= (range.graphicPoint.y + range.height))) {
					// Graphic is in region
					if (temp.isHighlighted == true) {
						temp.disableHighlight();
					}
					else {
			            temp.highlight();
					}
				}
			}
		}
	}

	public int selectedPort(BasicObject basicObject,MouseEvent e){
		for (int i = 1; i <= 4; i++) {
			if (basicObject.portArray[i].isSelected(e, 0, 0)) {
				return i;
			}
		}
	    return 0;
	}
	
	// Unused method
	public void mouseEntered(MouseEvent e) {
	
	}
	
	public void mouseExited(MouseEvent e) {

	}
	
	public void mouseMoved(MouseEvent e) {

	}
	
}
