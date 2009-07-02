package graphic;

import java.awt.*;

public class CompositionLine extends Line {

	int ArrowSize = 10;

	public CompositionLine(int F_ID, ConnectionPort pstart, ConnectionPort pend) {
		graphicID = F_ID;
		startpoint = pstart;
		endpoint = pend;
	}

	public void draw(Graphics g){
		g.setColor(Color.black);
		g.drawLine(startpoint.x + (startpoint.width / 2), startpoint.y + (startpoint.height / 2), endpoint.x + (endpoint.width / 2), endpoint.y + (startpoint.height / 2));
		int correctX, correctY;
		correctX = (int) (ArrowSize * countSin());
		correctY = (int) (ArrowSize * countCos());
		int x, y;
		x = endpoint.x + (endpoint.width/2) - (int) (ArrowSize * countCos());
		y = endpoint.y + (endpoint.height/2) + (int) (ArrowSize * countSin());
		int xValue[] = {x - correctX, x - correctY, x + correctX, x + correctY};
		int yValue[] = {y - correctY, y + correctX, y + correctY, y - correctX};
		g.setColor(Color.white);
		g.fillPolygon(xValue, yValue, 4);
		g.setColor(Color.black);
		g.drawPolygon(xValue, yValue, 4);
	}
}
