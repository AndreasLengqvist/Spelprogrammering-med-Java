package view;

import javax.media.opengl.GLAutoDrawable;
import model.Model;


public class View {
	private Model model;
	private Camera camera;
	private ParticleSystem particles;

	
	private Core core = new Core();

	public View(Model model, int width, int height) {
		this.model = model;
		camera = new Camera(100.0f, 100.0f);
		particles = new ParticleSystem();
	}

	public void render(GLAutoDrawable drawable, float timeElapsed) {

		core.loadResources();
		core.clearScreen(drawable);
		
		particles.render(drawable, core, timeElapsed);
		
	}
	
	
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		core.reshape(drawable, x, y, w, h);
		camera.setDimensions(w, h);    
	}
}