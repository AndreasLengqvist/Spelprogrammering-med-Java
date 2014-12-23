package view;

import javax.media.opengl.GLAutoDrawable;



public class ParticleSystem {

	private ExplosionSystem explosionsystem;
	private SplitterSystem splittersystem;
	private SmokeSystem smokesystem;
	
	
	public ParticleSystem(float x, float y){	
		splittersystem = new SplitterSystem(x, y);
		explosionsystem = new ExplosionSystem(x, y);
		smokesystem = new SmokeSystem(x, y);
	}
	
	public void render(GLAutoDrawable drawable, Core core, float timeElapsed, Camera camera) {
		splittersystem.render(drawable, core, timeElapsed, camera);
		explosionsystem.render(drawable, core, timeElapsed, camera);	
		smokesystem.render(drawable, core, timeElapsed, camera);	
	}
}
