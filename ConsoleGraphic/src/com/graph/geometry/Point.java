package com.graph.geometry;

/**
 * It is basic class that describes point in 3D
 */
public class Point{
	double x = 0, y = 0, z = 0;
	
	@Override
	public String toString(){
		String string = "Point x: " + x + " y: " + y + " z: " + z;
		return string;
	}
	
	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;		
	}
	
	/**
	 * Method moves point by vector
	 * @param vector
	 */
	public void move(Vector vector) {
		x += vector.x;
		y += vector.y;
		z += vector.z;
	}
	
	/**
	 * Method rotates point around point by defined angles
	 * @source https://en.wikipedia.org/wiki/Rotation_matrix
	 * @param vector - vector that points rotation point
	 * @param Rx - rotation around axis X
	 * @param Ry - rotation around axis Y
	 * @param Rz - rotation around axis Z
	 */
	public void rotate(Vector vector, double Rx, double Ry, double Rz) {
		double a = Math.toRadians(Rz); //Alfa
		double b = Math.toRadians(Ry); //Beta
		double c = Math.toRadians(Rx); //Gamma

		double sina = Math.sin(a), cosa = Math.cos(a);
		double sinb = Math.sin(b), cosb = Math.cos(b);
		double sinc = Math.sin(c), cosc = Math.cos(c);
		
		move(vector.contrary());

		double xT = cosa*cosb*x + (cosa*sinb*sinc - sina*cosc)*y + (cosa*sinb*cosc + sina*cosc)*z;
		double yT = sina*cosb*x + (sina*sinb*sinc + cosa*cosc)*y + (sina*sinb*cosc - cosa*sinc)*z;
		double zT = -sinb*x + cosb*sinc*y + cosb*cosc*z;
		x = xT; y = yT; z = zT;

		move(vector);
	}
	
	/**
	 * Method rotate point around (0,0,0) point by defined angles
	 * @param Rx - rotation around axis X
	 * @param Ry - rotation around axis Y
	 * @param Rz - rotation around axis Z
	 */
	public void rotate(double Rx, double Ry, double Rz) {
		rotate(new Vector(0, 0, 0), Rx, Ry, Rz);
	}
}
