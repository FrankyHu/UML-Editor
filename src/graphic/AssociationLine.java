package graphic;

import java.awt.*;

public class AssociationLine extends Line{

	public AssociationLine(ConnectionPort pstart, ConnectionPort pend) {
		startpoint = pstart;
		endpoint = pend;
	}

	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawLine(startpoint.x + (startpoint.width / 2), startpoint.y + (startpoint.height / 2), endpoint.x + (endpoint.width / 2), endpoint.y + (endpoint.height / 2));
	}
}
