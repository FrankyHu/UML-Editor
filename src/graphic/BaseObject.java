package graphic;

import java.awt.event.*;

abstract public class BaseObject extends Graphic {

	public int Group_ID;
	int NowPosX,NowPosY;

	public BaseObject() {
		
	}

	public boolean isSelected(MouseEvent e,int O_width, int O_height) {
		NowPosX = e.getX();
		NowPosY = e.getY();
		System.out.println("width = "+O_width);
		System.out.println("height = "+O_height);
		if ((NowPosX <= position.x + width - 1) && (NowPosX >= position.x) && (NowPosY <= position.y + height - 1) && (NowPosY >= position.y)) {
			System.out.println("result = true");
			return true;
		}
		else if (((NowPosX < position.x) && (NowPosY <= position.y + height - 1)) || ((NowPosY < position.y) && (NowPosX <= position.x + width - 1))) {
			if ((NowPosX + O_width >= position.x) && (NowPosY+ O_height >= position.y)) {
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

	public ConnectionPort GetPort(MouseEvent e) {
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
