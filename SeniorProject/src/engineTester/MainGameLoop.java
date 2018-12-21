package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;

public class MainGameLoop {

	public static void main(String[] args) {
		
		DisplayManager.createDisplay();
		
		while(!Display.isCloseRequested()) {
		
			//Game code
			//While Game is Running
			
			
			DisplayManager.updateDisplay();
			
		}
		
		DisplayManager.closeDisplay();
		
	}
	
}
