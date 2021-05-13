package com.graph.light;

import com.graph.geometry.Surface;

public class LightSource {
	
	public LightSource() {}
	
	/**
	 * Methods calculates light reflection of selected surface based on
	 * angle of normal vector to the camera direction (Axis Z)
	 * @param surface
	 * @return
	 */
	public char getReflection(Surface surface) {
		
		double angle = surface.getNorm().getAngleZ();
		
		if(90 < angle && 95 > angle) return '#';
		else if(95 <= angle && 100 > angle) return '%';
		else if(100 <= angle && 105 > angle) return '&';
		else if(105 <= angle && 110 > angle) return '@';
		else if(110 <= angle && 115 > angle) return 'a';
		else if(115 <= angle && 120 > angle) return 'W';
		else if(120 <= angle && 125 > angle) return 'w';
		else if(125 <= angle && 130 > angle) return 'O';
		else if(130 <= angle && 135 > angle) return 'o';
		else if(135 <= angle && 140 > angle) return 'l';
		else if(140 <= angle && 145 > angle) return '!';
		else if(145 <= angle && 150 > angle) return '+';
		else if(150 <= angle && 155 > angle) return '~';
		else if(155 <= angle && 160 > angle) return '-';
		else if(160 <= angle && 165 > angle) return ';';
		else if(165 <= angle && 170 > angle) return ':';
		else if(170 <= angle && 175 > angle) return '"';
		else if(175 <= angle && 180 >= angle) return '.';
		else return ' ';
	}
}
