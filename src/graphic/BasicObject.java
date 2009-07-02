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
			// Left part
			if (currentY - graphicPoint.y < height / 2) {
				if (currentX - graphicPoint.x > currentY - graphicPoint.y) {
					// Up
					port = portList[1];
				}
				else {
					// Left
					port = portList[4];
				}
			}
			else {
				if (currentX - graphicPoint.x > graphicPoint.y + height - currentY) {
					// Down
					port = portList[3];
				}
				else {
					// Left
					port = portList[4];
				}
			}
		}
		else {
			// Right part
			if (currentY - graphicPoint.y < height / 2) {
				if (graphicPoint.x + width - currentX > currentY - graphicPoint.y) {
					// Up
					port = portList[1];
				}
				else {
					// Right
					port = portList[2];
				}
			}
			else {
				if (graphicPoint.x + width - currentX > graphicPoint.y + height - currentY) {
					// Down
					port = portList[3];
				}
				else {
					// Right
					port = portList[2];
				}
			}
		}
		return port;
	}

	public void attachPort() {
		portList[1].x = graphicPoint.x + (width / 2) - (portList[1].width / 2);
		portList[1].y = graphicPoint.y - (portList[1].height / 2);
		
		portList[2].x = graphicPoint.x + width - (portList[2].width / 2);
		portList[2].y = graphicPoint.y + (height / 2) - (portList[2].height / 2);
		
		portList[3].x = graphicPoint.x + (width / 2) - (portList[3].width / 2);
		portList[3].y = graphicPoint.y + height - (portList[3].height / 2);
		
		portList[4].x = graphicPoint.x - (portList[4].width / 2);
		portList[4].y = graphicPoint.y + (height / 2) - (portList[4].height / 2);
	}

	public void setPosition(int distanceX, int distanceY) {
		graphicPoint.x = graphicPoint.x + distanceX;
		graphicPoint.y = graphicPoint.y + distanceY;
		attachPort();
	}
	
}
