package view;

import javax.media.opengl.GLAutoDrawable;

import model.IRocketObserver;
import model.Model;


public class View  implements IRocketObserver{
	
	private Model model;
	private Camera camera;
	private ExplodeParticleSystem explodeparticlesystem;
	private AliveParticleSystem aliveparticlesystem1;
	private AliveParticleSystem aliveparticlesystem2;
	private Core core = new Core();
	
	private float centerX;
	private float centerY;

	public View(Model model, int width, int height) {
		this.model = model;
		camera = new Camera(100.0f, 100.0f);
		aliveparticlesystem1 = new AliveParticleSystem(47.0f, 88.0f);
		aliveparticlesystem2 = new AliveParticleSystem(52.0f, 88.0f);

	}

	public void render(GLAutoDrawable drawable, float timeElapsed) {
		
		core.loadResources();
		core.clearScreen(drawable);
				
		drawBox(drawable, model);
		
		if(explodeparticlesystem != null){
			explodeparticlesystem.render(drawable, core, timeElapsed, camera);	
		}
		if(model.rocket.radius > 0.0f && aliveparticlesystem1 != null && aliveparticlesystem2 != null){
			aliveparticlesystem1.setStartPos(centerX-2.0f, centerY+5.0f);
			aliveparticlesystem2.setStartPos(centerX+3.0f, centerY+5.0f);
			aliveparticlesystem1.render(drawable, core, timeElapsed, camera);	
			aliveparticlesystem2.render(drawable, core, timeElapsed, camera);	
		}
		drawBall(drawable, model);

	}
	
	
	private void drawBall(GLAutoDrawable drawable, Model model) {
		
		float vx = camera.toViewCoord(model.rocket.centerX);
	    float vy = camera.toViewCoord(model.rocket.centerY);
		float vRocketSize = ((model.rocket.radius * 2.0f) * camera.getScale());
		core.drawBall(drawable, vx - vRocketSize / 2.0f, vy - vRocketSize / 2.0f, vRocketSize, vRocketSize*1.8f);
	}
	
	
	private void drawBox(GLAutoDrawable drawable, Model model) {
		
		for  (int x = 0; x < model.box.width; x++) {
			for (int y = 0; y < model.box.height; y++)  {
				float w = camera.getScale();
				float h = camera.getScale();
					float vx = camera.toViewCoord(x);
					float vy = camera.toViewCoord(y);
					
					core.drawBox(drawable, vx, vy, w, h, 0, 0, 0);
			}
		}
	}
	
	
	
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		core.reshape(drawable, x, y, w, h);
		camera.setDimensions(w, h);    
	}

	@Override
	public void doExplode(float centerX, float centerY) {
		explodeparticlesystem = new ExplodeParticleSystem(centerX, centerY);
	}

	@Override
	public void doAlive(float centerX, float centerY) {
		this.centerX = centerX;
		this.centerY = centerY;
	}
}