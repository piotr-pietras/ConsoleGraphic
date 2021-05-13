package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.graph.camera.Camera;
import com.graph.geometry.Cube;
import com.graph.geometry.Point;
import com.graph.light.LightSource;

public class Test {

	static boolean alive = true;
	
	public static void main(String[] args) {

		Cube cube = new Cube(new Point(35, 35, 20), 15.0);
		Camera camera = new Camera(cube);	
		camera.add(new LightSource());
		Render render = null;
		
		//Cmd.cls();
		System.out.println("Welcome to console's graphic!!!" +
				"\n" + "by PETERO"+
				"\n" + "-type '-close' to close console" + 
				"\n" + "-type '-start' to start rendering geometry");
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(alive) {
			try {
				String line = reader.readLine();
				switch (line) {
				
				case "-close": 
					System.out.println("Console terminated");
					alive = false;
					if(render != null) render.kill();
				
				case "-start":
					render = new Render(camera);
				
				}	
			} catch (IOException e) {
				System.out.print("Error! Stream is closed!");
				alive = false;
			} 
		}
	}
}
/*
abstract class Cmd {
	
	static void cls() {	
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException e1) {
			System.out.println(e1);
		} catch (IOException e2) {
			System.out.println(e2);
		}
	}
}
*/