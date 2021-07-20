package component;

import java.util.List;

import coordinate.Dimension;

public class FuselageB implements StructureModule {

	private int id;
	private Dimension geometricFeatures;
	private double mass;
	// 三维中的角需要有新的表现形式
	private double mountingAngle;

	public FuselageB(int id, double mountingAngle) {
		if (id < 0) {
			throw new IllegalArgumentException("ID must be positive or zero.");
		}
		this.id = id;
		this.mountingAngle = mountingAngle;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLinkNumber() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public List<Integer> getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public Dimension getGeometricFeatures() {
		return geometricFeatures;
	}

	public double getMass() {
		return mass;
	}

	public double getMountingAngle() {
		return mountingAngle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((geometricFeatures == null) ? 0 : geometricFeatures.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(mass);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mountingAngle);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		FuselageB other = (FuselageB) obj;
		if (geometricFeatures == null) {
			if (other.geometricFeatures != null)
				return false;
		} else if (!geometricFeatures.equals(other.geometricFeatures))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(mass) != Double.doubleToLongBits(other.mass))
			return false;
		if (Double.doubleToLongBits(mountingAngle) != Double.doubleToLongBits(other.mountingAngle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FuselageB [id=" + id + ", geometricFeatures=" + geometricFeatures + ", mass=" + mass
				+ ", mountingAngle=" + mountingAngle + "]";
	}

}
