package graphic;

public class Line extends Graphic{
	public ConnectionPort startpoint;
	public ConnectionPort endpoint;

	public Line () {
		
	}
	
	public double calculateSin() {
		double sin = (startpoint.y - endpoint.y) / calculateDistance();
		return sin;
	}

	public double calculateCos() {
		double cos = (endpoint.x - startpoint.x) / calculateDistance();
		return cos;
	}

	public double calculateDistance() {
		double distance = Math.sqrt(Math.pow((startpoint.x - endpoint.x), 2) + Math.pow((startpoint.y - endpoint.y), 2));
		return distance;
	}
}
