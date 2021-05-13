package com.graph.camera;

import com.graph.geometry.Geometry;
import com.graph.geometry.Point;
import com.graph.geometry.Surface;
import com.graph.light.LightSource;

/**
 * It's class that describes camera which is also considered as user's eyes.
 * Camera looking direction is along axis Z.
 * Any point which Z value is equal 0 is located at camera's lens and also 
 * is considered as pixel (smallest visible unit)
 * Camera is always static, any camera move are performed by Geometry's movement.
 */
public class Camera {
	
	final int width = 80;
	final int height = 50;

	public Geometry geometry;
	public LightSource lightSource;
	
	public Camera(Geometry geometry) {
		this.geometry = geometry;
	}
	
	public void add(LightSource lightSource) {
		this.lightSource = lightSource;
	}
	
	/**
	 * Methods gets line of characters which represents geometry's
	 * reflection at very moment
	 * String is ready to be printed on console.
	 * @return
	 */
	public String getString() {		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= height; i++) {
			for(int j = 1; j <= width; j++) {
				Surface surface = geometry.checkPixel(new Point(j, i, 0));
				if(surface != null)			
					if(lightSource != null) {
						sb.append(lightSource.getReflection(surface));
					}
					else {
						sb.append('#');
					}
				else sb.append(' ');
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
