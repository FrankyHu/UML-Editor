package graphic;

import java.awt.event.*;

abstract public class BaseObject extends Graphic {

	public int groupID;
	int NowPosX,NowPosY;

	public BaseObject() {
		for (int i = 1; i <= PortNum; i++) { // new connection port
			portList[i] = new ConnectionPort(this);
		}
	}

	public boolean isSelected(MouseEvent e, int objectWidth, int objectHeight) {
		NowPosX = e.getX();
		NowPosY = e.getY();
		System.out.println("width = " + objectWidth);
		System.out.println("height = " + objectHeight);
		if ((NowPosX <= position.x + width - 1) && (NowPosX >= position.x) && (NowPosY <= position.y + height - 1) && (NowPosY >= position.y)) {
			System.out.println("result = true");
			return true;
		}
		else if (((NowPosX < position.x) && (NowPosY <= position.y + height - 1)) || ((NowPosY < position.y) && (NowPosX <= position.x + width - 1))) {
			if ((NowPosX + objectWidth >= position.x) && (NowPosY + objectHeight >= position.y)) {
				System.out.println("result = true");
				return true;
			}
			else {
				System.out.println("result = false");
				return false;
			}
		}
		else {
			System.out.println("result = false");
			return false;
		}
	}

	public ConnectionPort getPort(MouseEvent e) {
		ConnectionPort fport;
		if (NowPosX - position.x < width / 2) {
			if (NowPosY - position.y < height / 2) {
				if (NowPosX - position.x > NowPosY - position.y) {
					fport = portList[1];
				}
				else {
					fport = portList[4];
				}
			}
			else {
				if (NowPosX - position.x > position.y + height - NowPosY) {
					fport = portList[3];
				}
				else {
					fport = portList[4];
				}
			}
		}
		else {
			if (NowPosY - position.y < height / 2) {
				if (position.x + width - NowPosX > NowPosY - position.y) {
			           fport = portList[1];
				}
				else {
					fport = portList[2];
				}
			}
			else {
				if (position.x + width - NowPosX > position.y + height - NowPosY) {
			           fport = portList[3];
				}
				else {
					fport = portList[2];
				}
			}
		}
		return fport;
	}

	public void attachPort() {
		portList[1].x = position.x + (width / 2) - (portList[1].width / 2);
		portList[1].y = position.y - (portList[1].height / 2);
		portList[2].x = position.x + width - (portList[2].width / 2);
		portList[2].y = position.y + (height / 2) - (portList[2].height / 2);
		portList[3].x = position.x + (width / 2) - (portList[3].width / 2);
		portList[3].y = position.y + height - (portList[3].height / 2);
		portList[4].x = position.x - (portList[4].width / 2);
		portList[4].y = position.y + (height / 2) - (portList[4].height / 2);
	}

	public void setPosition(int distx, int disty) {
		position.x = position.x + distx;
		position.y = position.y + disty;
		attachPort();
	}
}
