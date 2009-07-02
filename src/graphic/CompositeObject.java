package graphic;

import java.awt.*;
import java.util.*;
import controller.*;

public class CompositeObject extends Graphic {
	int PortNum = 4;
	public Vector groupArray = new Vector();
	  
	public CompositeObject() {
		this.width = 0; // Set Group width and height
		this.height = 0;
		this.graphicID = ++Controller.getInstance().IDcount;
		graphicName  = "Group"+graphicID;

		for (int i = 1; i <= PortNum; i++) { //new all port
			portList[i] = new ConnectionPort(this);
		}
	}

	public void addBasicObject(Graphic f) {
		this.groupArray.add(f);
		this.setplace(f);
		attachPort();
	}

	public void setplace(Graphic f) {
		System.out.println(f.getClass().getSuperclass().getName());

		if(f.getClass().getSuperclass().getName() == "graphic.BasicObject") {
			if (this.graphicPoint == null){
				this.graphicPoint= new Point();
				this.graphicPoint.x=f.graphicPoint.x;
				this.graphicPoint.y=f.graphicPoint.y;
				this.height = f.height;
				this.width = f.width;
			}
			System.out.println("處理"+f.graphicID);
			System.out.println("f的最下點為"+f.graphicPoint.y+"100");
			System.out.println("g的最上點為"+this.graphicPoint.y);
			System.out.println("g的高為"+this.height);
			if (f.graphicPoint.x < this.graphicPoint.x) {
				this.width = this.graphicPoint.x + this.width - f.graphicPoint.x;
				this.graphicPoint.x = f.graphicPoint.x;
			}
			if (f.graphicPoint.y < this.graphicPoint.y) {
				this.height = this.graphicPoint.y + this.height - f.graphicPoint.y;
				this.graphicPoint.y = f.graphicPoint.y;
			}
			if ((f.graphicPoint.x + f.width) > (this.graphicPoint.x + this.width)) {
				this.width = (f.graphicPoint.x + f.width) - this.graphicPoint.x;
			}
			if ((f.graphicPoint.y + f.height) > (this.graphicPoint.y + this.height)) {
				this.height = (f.graphicPoint.y + f.height) - this.graphicPoint.y;
			}
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.magenta);
		g.drawRoundRect(graphicPoint.x,graphicPoint.y,width,height, 10, 10);
		g.drawString(graphicName, graphicPoint.x, graphicPoint.y - 5);
		System.out.println("共有元件"+this.groupArray.size()+"個");
		for(int i =0; i<this.groupArray.size(); i++){
			System.out.println("繪出元件"+((Graphic)this.groupArray.get(i)).graphicID+"個");
				((Graphic)this.groupArray.get(i)).draw(g);
		}
		if (isHighlighted == true){
			for (int i = 1; i <= PortNum; i++)
				this.portList[i].draw(g, Color.BLUE);
		}
	}

	public void highlight(){
		for(int i =0; i<this.groupArray.size(); i++) {
			((Graphic)this.groupArray.get(i)).highlight();
		}
		this.isHighlighted = true;
	}

	public void disableHighlight(){
		for(int i =0; i<this.groupArray.size(); i++) {
			((Graphic)this.groupArray.get(i)).disableHighlight();
		}
		this.isHighlighted = false;
	}

	public void setPosition(int distx,int disty) { //Group move each figure reset position
		for(int i =0; i<this.groupArray.size(); i++){
			if ((this.groupArray.get(i)).getClass().getSuperclass().getName() == "graphic.BasicObject")
				((BasicObject)this.groupArray.get(i)).setPosition(distx, disty);
		}
		super.setPosition(distx, disty);
	}
}
