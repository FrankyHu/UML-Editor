package graphic;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.*;
import controller.*;

public class CompositeObject extends Graphic {

	public Vector groupArray = new Vector();
	int currentX,currentY;
	
	public CompositeObject() {
		// Set Composite width and height
		width = 0;
		height = 0;
		EditorController.getInstance().compositeCounter++;
		graphicID = EditorController.getInstance().compositeCounter;
		graphicName  = "Composite " + graphicID;
	}

	public void addBasicObject(Graphic graphic) {
		groupArray.add(graphic);
		setRange(graphic);
	}

	public void setRange(Graphic graphic) {
		if(graphic.getClass().getSuperclass().getName() == "graphic.BasicObject") {
			if (graphicPoint == null){
				graphicPoint = new Point();
				graphicPoint.x = graphic.graphicPoint.x;
				graphicPoint.y = graphic.graphicPoint.y;
				height = graphic.height;
				width = graphic.width;
			}

			if (graphic.graphicPoint.x < graphicPoint.x) {
				width = graphicPoint.x + width - graphic.graphicPoint.x;
				graphicPoint.x = graphic.graphicPoint.x;
			}
			
			if (graphic.graphicPoint.y < graphicPoint.y) {
				height = graphicPoint.y + height - graphic.graphicPoint.y;
				graphicPoint.y = graphic.graphicPoint.y;
			}
			
			if ((graphic.graphicPoint.x + graphic.width) > (graphicPoint.x + width)) {
				width = (graphic.graphicPoint.x + graphic.width) - graphicPoint.x;
			}
			
			if ((graphic.graphicPoint.y + graphic.height) > (graphicPoint.y + height)) {
				height = (graphic.graphicPoint.y + graphic.height) - graphicPoint.y;
			}
		}
	}
	
	public boolean isSelected(MouseEvent e, int objectWidth, int objectHeight) {
		currentX = e.getX();
		currentY = e.getY();
		int widthUpperBound = graphicPoint.x + width - 1;
		int widthLowerBound = graphicPoint.x;
		int heightUpperBound = graphicPoint.y + height - 1;
		int heightLowerBound = graphicPoint.y;
		if ((currentX <= widthUpperBound) && (currentX >= widthLowerBound) && (currentY <= heightUpperBound) && (currentY >= heightLowerBound)) {
			return true;
		}
		else if (((currentX < widthLowerBound) && (currentY <= heightUpperBound)) || ((currentY < heightLowerBound) && (currentX <= widthUpperBound))) {
			if ((currentX + objectWidth >= widthLowerBound) && (currentY + objectHeight >= heightLowerBound)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	public void highlight() {
		for(int i = 0; i< groupArray.size(); i++) {
			((Graphic) groupArray.get(i)).highlight();
		}
		this.isHighlighted = true;
	}

	public void disableHighlight() {
		for(int i = 0; i< groupArray.size(); i++) {
			((Graphic) groupArray.get(i)).disableHighlight();
		}
		this.isHighlighted = false;
	}
	
	public void setPosition(int distanceX,int distanceY) { // Move each graphic and reset position
		for(int i = 0; i< groupArray.size(); i++) {
			if ((groupArray.get(i)).getClass().getSuperclass().getName() == "graphic.BasicObject")
				((BasicObject) groupArray.get(i)).setPosition(distanceX, distanceY);
		}
		graphicPoint.x = graphicPoint.x + distanceX;
		graphicPoint.y = graphicPoint.y + distanceY;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.drawRoundRect(graphicPoint.x - 5, graphicPoint.y - 5, width + 10, height + 10, 10, 10);
		g.drawString(graphicName, graphicPoint.x, graphicPoint.y - 10);
		for(int i = 0; i < groupArray.size(); i++){
			((Graphic) groupArray.get(i)).draw(g);
		}
	}
}
