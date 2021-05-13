package com.test;

import com.graph.camera.Camera;

public class Render extends Thread{
	
	Camera camera;
	boolean alive = true;
	long time;
	int fps = 25;
	
	Render(Camera camera) {
		time = System.currentTimeMillis();
		this.camera = camera;
		this.start();
	}
	
	@Override
	public void run() {
		while(alive) {
			if(System.currentTimeMillis() - time > 1000 / fps) {
				time = System.currentTimeMillis();
				//Cmd.cls();
				camera.geometry.rotate(66.6/fps, 27.7/fps, 0);
				System.out.print(camera.getString());
			}
		}
	}
	
	public void kill() {
		alive = false;
	}
}
