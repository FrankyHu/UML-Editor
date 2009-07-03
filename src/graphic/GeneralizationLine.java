package graphic;

import java.awt.*;

public class GeneralizationLine extends Line {

	int arrowSize = 10;

	public GeneralizationLine(ConnectionPort pstart, ConnectionPort pend) {
		startpoint = pstart;
		endpoint = pend;
	}

	public void draw(Graphics g){
		g.setColor(Color.black);
		g.drawLine(startpoint.x + (startpoint.width / 2), startpoint.y + (startpoint.height / 2), endpoint.x + (endpoint.width / 2), endpoint.y + (startpoint.height / 2));
		int correctX, correctY;
		correctX = (int) (arrowSize * calculateSin());
		correctY = (int) (arrowSize * calculateCos());
		int x, y;
		x = endpoint.x + (endpoint.width/2) - (int) (arrowSize * calculateCos());
		y = endpoint.y + (endpoint.height/2) + (int) (arrowSize * calculateSin());
		int xValue[] = {x - correctX, x + correctX, x + correctY};
		int yValue[] = {y - correctY, y + correctY, y - correctX};
		g.setColor(Color.white);
		g.fillPolygon(xValue, yValue, 3);
		g.setColor(Color.black);
		g.drawPolygon(xValue, yValue, 3);
	}
}
