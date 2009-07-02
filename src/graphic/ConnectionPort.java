package graphic;

import java.awt.*;
import java.awt.event.*;


public class ConnectionPort {
	public int x;
	public int y;
	int width = 10;
	int height = 10;
	public Graphic port_fig;
	public ConnectionPort(Graphic f) {
		port_fig = f;
	}

	public void draw(Graphics g){
		System.out.print("do draw");
		this.draw(g,Color.green);
	}

	public void draw(Graphics g,Color color){
		g.setColor(color);
		g.fillRect(x,y,width,height);
		g.setColor(Color.black);
		g.drawRect(x,y,width,height);
	}


	public boolean isSelected(MouseEvent e,int O_width, int O_height) {
		int NowPosX = e.getX();
		int NowPosY = e.getY();
		System.out.println("width = "+O_width);
		System.out.println("height = "+O_height);

		if ((NowPosX <= x + width /*-1*/) && (NowPosX >= x) && (NowPosY <= y + height /*-1*/) && (NowPosY >= y)){
			System.out.println("result = true");
			return true;
		}
		else if (((NowPosX < x) && (NowPosY <= y + height /*-1*/)) || ((NowPosY < y) && (NowPosX <= x + width/*-1*/))) {
			if ((NowPosX + O_width >= x) && (NowPosY+ O_height >= y)){
				System.out.println("result = true");
				return true;
			}
			else{
				System.out.println("result = false");
				return false;
			}
		}
		else{
			System.out.println("result = false");
			return false;
		}
	}
	
}
