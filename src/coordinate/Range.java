package coordinate;

public class Range {
	private int xFrom;
	private int xTo;
	private int yFrom;
	private int yTo;
	private int zFrom;
	private int zTo;

	public Range(int xFrom, int xTo, int yFrom, int yTo, int zFrom, int zTo) {
		super();
		this.xFrom = xFrom;
		this.xTo = xTo;
		this.yFrom = yFrom;
		this.yTo = yTo;
		this.zFrom = zFrom;
		this.zTo = zTo;
	}

	public int getxFrom() {
		return xFrom;
	}

	public int getxTo() {
		return xTo;
	}

	public int getyFrom() {
		return yFrom;
	}

	public int getyTo() {
		return yTo;
	}

	public int getzFrom() {
		return zFrom;
	}

	public int getzTo() {
		return zTo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xFrom;
		result = prime * result + xTo;
		result = prime * result + yFrom;
		result = prime * result + yTo;
		result = prime * result + zFrom;
		result = prime * result + zTo;
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
		Range other = (Range) obj;
		if (xFrom != other.xFrom)
			return false;
		if (xTo != other.xTo)
			return false;
		if (yFrom != other.yFrom)
			return false;
		if (yTo != other.yTo)
			return false;
		if (zFrom != other.zFrom)
			return false;
		if (zTo != other.zTo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Range [xFrom=" + xFrom + ", xTo=" + xTo + ", yFrom=" + yFrom + ", yTo=" + yTo + ", zFrom=" + zFrom
				+ ", zTo=" + zTo + "]";
	}

}
