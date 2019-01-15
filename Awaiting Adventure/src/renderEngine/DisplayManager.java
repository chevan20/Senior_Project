package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	
	public static final int WIDTH = 1920, HEIGHT = 995, FPS = 120;
	
	public static final String title = "Awaiting Adventure";

	/**
	 * This void
	 * sets the LWJGL version number, 
	 * creates the window on the screen, 
	 * sets its location on the screen, 
	 * sets it to be in pixel format,
	 * sets the title
	 * and sets the frame that we use in the window
	 */
	
	public static void createDisplay() 
	{
		
		ContextAttribs attribs = new ContextAttribs(3,2);
		attribs.withForwardCompatible(true);
		attribs.withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setLocation(0, 0);
			Display.create(new PixelFormat(), attribs);
			Display.setTitle(title);
		}catch(LWJGLException e) {
			e.printStackTrace();
		}
		
		GL11.glViewport(0,  0, WIDTH, HEIGHT);
		
		
	}
	
	/**
	 * This void
	 * syncs the fps
	 * updates the display
	 */
	public static void updateDisplay() 
	{
		
		Display.sync(FPS);
		Display.update();
		
	}
	
	/**
	 * This void
	 * closes window
	 */
	public static void closeDisplay() 
	{
		
		Display.destroy();
		
	}
	
	
}
