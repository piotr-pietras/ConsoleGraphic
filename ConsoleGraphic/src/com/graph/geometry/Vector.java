package com.graph.geometry;

/**
 * It is class that describes vector in 3D
 * Vector extends Point
 */
public class Vector extends Point{
	
	@Override
	public String toString(){
		String string = "Vector x: " + x + " y: " + y + " z: " + z;
		return string;
	}
	
	public Vector(double x, double y, double z) {
		super(x, y, z);
	}
	
	public Vector(double x0, double y0, double z0, double x, double y, double z) {
		super(x - x0, y - y0, z - z0);
	}	
	
	public Vector(Point point) {
		super(point.x, point.y, point.z);
	}	

	public Vector(Point point0, Point point) {
		super(point.x - point0.x, point.y - point0.y, point.z - point0.z);	
	}	
	
	/**
	 * Method calculates contrary vector to current one
	 * @return Vector - is contrary to current one
	 */
	public Vector contrary() {
		Vector vector = new Vector(x*(-1), y*(-1), z*(-1));
		return vector;
	}
	
	/**
	 * Method calculates dot product of 2 vectors
	 * Current vector is replaced by calculated product!
	 * @source https://en.wikipedia.org/wiki/Dot_product
	 * @param vector2 - is 'b' of dot equation
	 */
	public void multiply(Vector vector2) {	
		double xT = this.y * vector2.z - this.z * vector2.y;
		double yT = this.z * vector2.x - this.x * vector2.z;
		double zT = this.x * vector2.y - this.y * vector2.x;
		x = xT; y = yT; z = zT;
	}
	
	/**
	 * Method gets vector's module
	 * @return double
	 */
	public double getModule() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
	}
	
	/**
	 * Method gets vector's angle to Z axis
	 * @return double
	 */
	public double getAngleZ() {
		return Math.toDegrees(Math.acos(z / getModule()));
	}
	
	/**
	 * Method gets vector's angle to Y axis
	 * @return double
	 */
	public double getAngleY() {
		return Math.toDegrees(Math.acos(y / getModule()));
	}

	/**
	 * Method gets vector's angle to X axis
	 * @return double
	 */
	public double getAngleX() {
		return Math.toDegrees(Math.acos(x / getModule()));
	}
}
