package view;

import javax.media.opengl.GLAutoDrawable;
import model.Model;


/*
 * Initializing view.
 * Basically the setup of the window and all its features.
 * Handles the Core, Camera and also the reload and reshape methods.
 */
public class View {
	
	private Input input;
	private Camera camera;
	private Core core = new Core();

	

	public View(Model model, int width, int height, Input input) {
		this.input = input;
		camera = new Camera(1.5f, 1.0f);
	}
	

	public void reload(GLAutoDrawable drawable) {
		core.loadResources();
		core.clearScreen(drawable);				
	}
	
	public Core getCore(){
		return core;
	}
	
	public Input getInput() {
		return input;
	}
	
	public Camera getCamera(){
		return camera;
	}
	
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		core.reshape(drawable, x, y, w, h);
		camera.setDimensions(w, h);    
	}
}