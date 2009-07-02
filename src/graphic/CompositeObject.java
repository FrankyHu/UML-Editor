package graphic;

import java.awt.*;
import java.util.*;
import controller.*;

public class CompositeObject extends Graphic {

	public Vector groupArray = new Vector();
	  
	public CompositeObject() {
		// Set Composite width and height
		width = 0;
		height = 0;
		
		graphicID = ++Controller.getInstance().IDcount;
		graphicName  = "Composite " + graphicID;
	}

	public void addBasicObject(Graphic graphic) {
		groupArray.add(graphic);
		setRange(graphic);
		// attachPort();
	}

	public void setRange(Graphic graphic) {
		System.out.println(graphic.getClass().getSuperclass().getName());

		if(graphic.getClass().getSuperclass().getName() == "graphic.BasicObject") {
			if (graphicPoint == null){
				graphicPoint = new Point();
				graphicPoint.x=graphic.graphicPoint.x;
				graphicPoint.y=graphic.graphicPoint.y;
				height = graphic.height;
				width = graphic.width;
			}
			// System.out.println("處理"+graphic.graphicID);
			// System.out.println("f的最下點為"+graphic.graphicPoint.y+"100");
			// System.out.println("g的最上點為"+this.graphicPoint.y);
			// System.out.println("g的高為"+this.height);
			if (graphic.graphicPoint.x < this.graphicPoint.x) {
				width = this.graphicPoint.x + this.width - graphic.graphicPoint.x;
				graphicPoint.x = graphic.graphicPoint.x;
			}
			if (graphic.graphicPoint.y < this.graphicPoint.y) {
				height = this.graphicPoint.y + this.height - graphic.graphicPoint.y;
				graphicPoint.y = graphic.graphicPoint.y;
			}
			if ((graphic.graphicPoint.x + graphic.width) > (this.graphicPoint.x + this.width)) {
				width = (graphic.graphicPoint.x + graphic.width) - this.graphicPoint.x;
			}
			if ((graphic.graphicPoint.y + graphic.height) > (this.graphicPoint.y + this.height)) {
				height = (graphic.graphicPoint.y + graphic.height) - this.graphicPoint.y;
			}
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.magenta);
		g.drawRoundRect(graphicPoint.x,graphicPoint.y,width,height, 10, 10);
		g.drawString(graphicName, graphicPoint.x, graphicPoint.y - 5);
		// System.out.println("共有元件"+this.groupArray.size()+"個");
		for(int i = 0; i < groupArray.size(); i++){
			// System.out.println("繪出元件"+((Graphic)this.groupArray.get(i)).graphicID+"個");
			((Graphic) groupArray.get(i)).draw(g);
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
	
	public void setPosition(int distanceX,int distanceY) { //Group move each figure reset position
		System.out.println("Group setPosition");
		for(int i = 0; i< groupArray.size(); i++) {
			if ((groupArray.get(i)).getClass().getSuperclass().getName() == "graphic.BasicObject")
				((BasicObject) groupArray.get(i)).setPosition(distanceX, distanceY);
		}
		graphicPoint.x = graphicPoint.x + distanceX;
		graphicPoint.y = graphicPoint.y + distanceY;
	}
}
