package com.graph.geometry;

/**
 * It's class that describes cube in 3D
 * Cube is built based on 12 surfaces
 */
public class Cube extends Geometry{
	
	Surface surfaces[] = new Surface[12];
	Point center;
	
	public Cube(Point center, Double size){
		
		this.center = center;
		
		surfaces[0] = new Surface(new Point(center.x-size/2, center.y-size/2, center.z-size/2),
				new Point(center.x-size/2, center.y+size/2, center.z-size/2),
				new Point(center.x+size/2, center.y-size/2, center.z-size/2));

		surfaces[1] = new Surface(new Point(center.x+size/2, center.y+size/2, center.z-size/2),
				new Point(center.x+size/2, center.y-size/2, center.z-size/2),
				new Point(center.x-size/2, center.y+size/2, center.z-size/2));
		
		surfaces[2] = surfaces[0].clone(); surfaces[2].rotate(new Vector(center), 90, 0, 0); 
		surfaces[3] = surfaces[1].clone(); surfaces[3].rotate(new Vector(center), 90, 0, 0); 
		surfaces[4] = surfaces[0].clone(); surfaces[4].rotate(new Vector(center), 180, 0, 0); 
		surfaces[5] = surfaces[1].clone(); surfaces[5].rotate(new Vector(center), 180, 0, 0); 	
		surfaces[6] = surfaces[0].clone(); surfaces[6].rotate(new Vector(center), 270, 0, 0); 
		surfaces[7] = surfaces[1].clone(); surfaces[7].rotate(new Vector(center), 270, 0, 0);
		surfaces[8] = surfaces[0].clone(); surfaces[8].rotate(new Vector(center), 0, 90, 0); 
		surfaces[9] = surfaces[1].clone(); surfaces[9].rotate(new Vector(center), 0, 90, 0); 
		surfaces[10] = surfaces[0].clone(); surfaces[10].rotate(new Vector(center), 0, -90, 0); 
		surfaces[11] = surfaces[1].clone(); surfaces[11].rotate(new Vector(center), 0, -90, 0); 
	}
	
	/**
	 * Method checks if selected pixel contains in visible part of this cube 
	 * In other words Point(x,y,0) is projected in camera direction (Axis Z)
	 * and if it pass through this cube returns true.
	 * @param point - its point on console - Point(x,y,0);
	 * @return 
	 */
	@Override
	public Surface checkPixel(Point point) {
		Surface closestSurface = null;
		Double distanceSurface = 999999.9;
		for(Surface surface : surfaces) {
			if(surface.checkPixel(point) != null) {
				if(surface.distancePixel(point) < distanceSurface) {
					closestSurface = surface;
					distanceSurface = surface.distancePixel(point);
				}
			}
		}
		return closestSurface;
	}
	
	/**
	 * Method moves cube by vector
	 * @param vector
	 */
	@Override
	public void move(Vector vector) {
		for(Surface surface : surfaces) surface.move(vector);
		
	}

	/**
	 * Method rotates cube around point by defined angles
	 * @param vector - vector that points rotation point
	 * @param Rx - rotation around axis X
	 * @param Ry - rotation around axis Y
	 * @param Rz - rotation around axis Z
	 */
	@Override
	public void rotate(Vector vector, double Rx, double Ry, double Rz) {
		for(Surface surface : surfaces) {
			surface.rotate(vector, Rx, Ry, Rz);
		}
	}
	
	/**
	 * Method rotate cube around (0,0,0) point by defined angles
	 * @param Rx - rotation around axis X
	 * @param Ry - rotation around axis Y
	 * @param Rz - rotation around axis Z
	 */
	@Override
	public void rotate(double Rx, double Ry, double Rz) {
		rotate(new Vector(center), Rx, Ry, Rz);
	}

	/**
	 * Method gets normal vector to the first facet
	 * @return Vector
	 */
	@Override
	public Vector getNorm() {
		return surfaces[0].getNorm();
	}
}
