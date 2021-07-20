package coordinate;

import java.util.List;

public class Dimension {
	private Range size;
	private Point gravityCenter;
	private Point airDynamicCenter;
	private Point origin;
	private List<Point> fixedPoints;
	
	
	
	public Dimension(Range size, Point gravityCenter, Point airDynamicCenter, Point origin, List<Point> fixedPoints) {
		super();
		this.size = size;
		this.gravityCenter = gravityCenter;
		this.airDynamicCenter = airDynamicCenter;
		this.origin = origin;
		this.fixedPoints = fixedPoints;
	}

	public boolean merge(Dimension main, Dimension... others) {
		
		return false;
	}
	
	public void changeOrigin(Point newOrigin) {
		
	}
	
	public void setDefaultOrigin() {
		
	}

	public Range getSize() {
		return size;
	}

	public Point getGravityCenter() {
		return gravityCenter;
	}

	public Point getAirDynamicCenter() {
		return airDynamicCenter;
	}

	public Point getOrigin() {
		return origin;
	}

	public List<Point> getFixedPoints() {
		return fixedPoints;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airDynamicCenter == null) ? 0 : airDynamicCenter.hashCode());
		result = prime * result + ((fixedPoints == null) ? 0 : fixedPoints.hashCode());
		result = prime * result + ((gravityCenter == null) ? 0 : gravityCenter.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dimension other = (Dimension) obj;
		if (airDynamicCenter == null) {
			if (other.airDynamicCenter != null)
				return false;
		} else if (!airDynamicCenter.equals(other.airDynamicCenter))
			return false;
		if (fixedPoints == null) {
			if (other.fixedPoints != null)
				return false;
		} else if (!fixedPoints.equals(other.fixedPoints))
			return false;
		if (gravityCenter == null) {
			if (other.gravityCenter != null)
				return false;
		} else if (!gravityCenter.equals(other.gravityCenter))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dimension [size=" + size + ", gravityCenter=" + gravityCenter + ", airDynamicCenter=" + airDynamicCenter
				+ ", origin=" + origin + ", fixedPoints=" + fixedPoints + "]";
	}
	
	
}
