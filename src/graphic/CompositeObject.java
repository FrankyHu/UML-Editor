package graphic;

import java.awt.*;
import java.util.*;
import controller.*;

public class CompositeObject extends BaseObject {
	int PortNum = 4;
	public Vector groupArray = new Vector();
	  
	public CompositeObject() {
		this.width = 0;      // Set Group width and height
		this.height = 0;
		this.graphicID = ++Controller.getInstance().IDcount;
		graphicName  = "Group"+graphicID;

		for (int i = 1; i <= PortNum; i++) { //new all port
			portList[i] = new ConnectionPort(this);
		}
	}

	public void AddBaseObject(Graphic f) {
		this.groupArray.add(f);
		this.setplace(f);
		attachPort();
	}

	public void setplace(Graphic f) {
		if(f.getClass().getSuperclass().getName() == "graphic.BaseObject") {
			if (this.position == null){
				this.position= new Point();
				this.position.x=f.position.x;
				this.position.y=f.position.y;
				this.height = f.height;
				this.width = f.width;
			}
			System.out.println("處理"+f.graphicID);
			System.out.println("f的最下點為"+f.position.y+"100");
			System.out.println("g的最上點為"+this.position.y);
			System.out.println("g的高為"+this.height);
			if (f.position.x < this.position.x) {
				this.width = this.position.x + this.width - f.position.x;
				this.position.x = f.position.x;
			}
			if (f.position.y < this.position.y) {
				this.height = this.position.y + this.height - f.position.y;
				this.position.y = f.position.y;
			}
			if ((f.position.x + f.width) > (this.position.x + this.width)) {
				this.width = (f.position.x + f.width) - this.position.x;
			}
			if ((f.position.y + f.height) > (this.position.y + this.height)) {
				this.height = (f.position.y + f.height) - this.position.y;
			}
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.magenta);
		g.drawRoundRect(position.x,position.y,width,height,10,10);
		g.drawString(graphicName, position.x, position.y -5);
		System.out.println("共有元件"+this.groupArray.size()+"個");
		for(int i =0; i<this.groupArray.size(); i++){
			System.out.println("繪出元件"+((Graphic)this.groupArray.get(i)).graphicID+"個");
				((Graphic)this.groupArray.get(i)).draw(g);
		}
		if (isSelected == true){
			for (int i = 1; i <= PortNum; i++)
				this.portList[i].draw(g, Color.BLUE);
		}
	}

	public void Highlight(){
		for(int i =0; i<this.groupArray.size(); i++) {
			((Graphic)this.groupArray.get(i)).Highlight();
		}
		this.isSelected = true;
	}

	public void DisHighlight(){
		for(int i =0; i<this.groupArray.size(); i++) {
			((Graphic)this.groupArray.get(i)).DisHighlight();
		}
		this.isSelected = false;
	}

	public void setPosition(int distx,int disty) {//Group move each figure reset position
		for(int i =0; i<this.groupArray.size(); i++){
			if ((this.groupArray.get(i)).getClass().getSuperclass().getName() == "graphic.BaseObject")
				((BaseObject)this.groupArray.get(i)).setPosition(distx, disty);
		}
		super.setPosition(distx, disty);
	}
}
