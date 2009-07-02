package graphic;

import java.awt.event.*;

abstract public class BasicObject extends Graphic {

	public int groupID;
	int currentX,currentY;

	public BasicObject() {
		// new connection port
		for (int i = 1; i <= PortNum; i++) {
			portList[i] = new ConnectionPort(this);
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

	public ConnectionPort getPort(MouseEvent e) {
		ConnectionPort port;
		if (currentX - graphicPoint.x < width / 2) {
			if (currentY - graphicPoint.y < height / 2) {
				if (currentX - graphicPoint.x > currentY - graphicPoint.y) {
					port = portList[1];
				}
				else {
					port = portList[4];
				}
			}
			else {
				if (currentX - graphicPoint.x > graphicPoint.y + height - currentY) {
					port = portList[3];
				}
				else {
					port = portList[4];
				}
			}
		}
		else {
			if (currentY - graphicPoint.y < height / 2) {
				if (graphicPoint.x + width - currentX > currentY - graphicPoint.y) {
			           port = portList[1];
				}
				else {
					port = portList[2];
				}
			}
			else {
				if (graphicPoint.x + width - currentX > graphicPoint.y + height - currentY) {
			           port = portList[3];
				}
				else {
					port = portList[2];
				}
			}
		}
		return port;
	}

}
