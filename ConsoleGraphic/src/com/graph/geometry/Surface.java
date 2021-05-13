package com.graph.geometry;

/**
 * It is basic class that describes surface in 3D
 * Surface is built based on 3 points that are connected each other
 */
public class Surface extends Geometry {
	
	Point points[] = new Point[3];
	
	public Surface(Point[] points) {
		if(points.length == 3) {
			this.points[0] = points[0];
			this.points[1] = points[1];
			this.points[2] = points[2];
		}
		else System.out.print("Wrong size of array");
	}
	 
	public Surface(Point point1, Point point2, Point point3) {
		points[0] = point1;
		points[1] = point2;
		points[2] = point3;
	}
	
	/**
	 * Method checks if selected pixel contains in visible part of this surface 
	 * In other words Point(x,y,0) is projected in camera direction (Axis Z)
	 * and if it pass through this surface returns true.
	 * @param point - its point on console - Point(x,y,0);
	 * @return 
	 */
	@Override
	public Surface checkPixel(Point point) {
		Surface surface1 = new Surface (point, this.points[0], this.points[1]);	
		Surface surface2 = new Surface(point, this.points[1], this.points[2]);	
		Surface surface3 = new Surface(point, this.points[2], this.points[0]);			
		double area = Math.round((surface1.getXYArea() + surface2.getXYArea() + surface3.getXYArea()) * 10);
		
		if(Math.round(getXYArea()*10) == area) return this;
		else return null;
	}
	
	/**
	 * Method calculates distance between selected pixel Point(x,y,0) to this surface 
	 * in camera direction's line (Axis Z)
	 * @param point - its point on console - Point(x,y,0);
	 * @return
	 */
	public double distancePixel(Point point) {
		double a = (points[1].y-points[0].y)*(points[2].z-points[0].z) - (points[2].y-points[0].y)*(points[1].z-points[0].z);
		double b = (points[1].z-points[0].z)*(points[2].x-points[0].x) - (points[2].z-points[0].z)*(points[1].x-points[0].x);
		double c = (points[1].x-points[0].x)*(points[2].y-points[0].y) - (points[2].x-points[0].x)*(points[1].y-points[0].y);
		double d = -(a*points[0].x + b*points[0].y + c*points[0].z);
		
		double z = (a*point.x + b*point.y + d) / (-c);
		if(z < 0) z = 0;
		
		return z;
	}
	
	/**
	 * Method gets surface's area 
	 * @return
	 */
	public double getXYArea() {	
		return Math.abs((points[0].x * (points[1].y - points[2].y) 
				+ points[1].x * (points[2].y - points[0].y)
				+ points[2].x * (points[0].y - points[1].y)) / 2);
	}
	
	/**
	 * Method moves surface by vector
	 * @param vector
	 */
	@Override
	public void move(Vector vector) {
		for(Point point : points) point.move(vector);
	}
	
	/**
	 * Method rotates surface around point by defined angles
	 * @param vector - vector that points rotation point
	 * @param Rx - rotation around axis X
	 * @param Ry - rotation around axis Y
	 * @param Rz - rotation around axis Z
	 */
	@Override
	public void rotate(Vector vector, double Rx, double Ry, double Rz) {
		for(Point point : points) point.rotate(vector, Rx, Ry, Rz);
	}
	
	/**
	 * Method rotate surface around (0,0,0) point by defined angles
	 * @param Rx - rotation around axis X
	 * @param Ry - rotation around axis Y
	 * @param Rz - rotation around axis Z
	 */
	@Override
	public void rotate(double Rx, double Ry, double Rz) {
		for(Point point : points) point.rotate(new Vector(0, 0, 0), Rx, Ry, Rz);
	}
	
	/**
	 * Method gets normal vector to this surface
	 * @return Vector
	 */
	@Override
	public Vector getNorm() {
		Vector vec1 = new Vector(points[0], points[1]);
		Vector vec2 = new Vector(points[0], points[2]);
		Vector norm = vec1; 
		norm.multiply(vec2);
	
		return norm;
	}
	
	/**
	 * Method clones current surface
	 * @return Surface
	 */
	public Surface clone() {
		return new Surface(new Point(points[0].x, points[0].y, points[0].z),
				new Point(points[1].x, points[1].y, points[1].z),
				new Point(points[2].x, points[2].y, points[2].z));
	}
}
