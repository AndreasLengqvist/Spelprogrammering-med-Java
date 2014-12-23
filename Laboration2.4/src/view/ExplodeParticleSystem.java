package view;

import javax.media.opengl.GLAutoDrawable;



public class ExplodeParticleSystem {

	private ExplosionSystem explosionsystem;
	private SplitterSystem splittersystem;
	
	
	public ExplodeParticleSystem(float x, float y){	
		splittersystem = new SplitterSystem(x, y);
		explosionsystem = new ExplosionSystem(x, y);
	}
	
	public void render(GLAutoDrawable drawable, Core core, float timeElapsed, Camera camera) {
		splittersystem.render(drawable, core, timeElapsed, camera);
		explosionsystem.render(drawable, core, timeElapsed, camera);	
	}
}
