package graphic;

public class Line extends Graphic{
	public ConnectionPort startpoint = null;
	public ConnectionPort endpoint = null;

	public Line () {
		
	}
	
	public double countSin() {
		double sin = (startpoint.y - endpoint.y) / countDistance();
		return sin;
	}

	public double countCos() {
		double cos = (endpoint.x - startpoint.x) / countDistance();
		return cos;
	}

	public double countDistance() {
		double Distance = Math.sqrt(Math.pow((startpoint.x - endpoint.x), 2) + Math.pow((startpoint.y - endpoint.y), 2));
		return Distance;
	}
}
