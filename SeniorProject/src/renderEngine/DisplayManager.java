package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	
	private static final int WIDTH = 1920;
	private static final int HEIGHT = 990;
	private static final int FPS_CAP = 120;
	
	private static final String TITLE = "Awaiting Adventure";
	
	
	//This creates the Window for the game
	public static void createDisplay() {
		
		ContextAttribs attribs = new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);
		
		try {
			//These set the Height, Format, and Location. It also makes it not resizeable.
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setResizable(false);
			Display.setLocation(-3,  0);
			
			Display.setTitle(TITLE);
			
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
			
	
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
	}
	
	//This updates the Window for the game
	public static void updateDisplay() {
		
		//This is the max FPS for the game
		Display.sync(FPS_CAP);
		Display.update();
		
	}
	
	//This closes the display
	public static void closeDisplay() {
		
		Display.destroy();
		
	}

}
