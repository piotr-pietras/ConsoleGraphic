package com.graph.geometry;

/**
 * It is abstract class that is extended by any class associated with visible geometry
 */
abstract public class Geometry {
	
	abstract public Surface checkPixel(Point point);
	abstract public void move(Vector vector);
	abstract public void rotate(Vector vector, double Rx, double Ry, double Rz);
	abstract public void rotate(double Rx, double Ry, double Rz);
	abstract public Vector getNorm();
}
