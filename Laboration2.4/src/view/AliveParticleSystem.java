package view;

import javax.media.opengl.GLAutoDrawable;



public class AliveParticleSystem {

	private SmokeSystem smokesystem;
	
	private float centerX;
	private float centerY;
	
	
	public AliveParticleSystem(float x, float y){	
		smokesystem = new SmokeSystem(x, y);
	}
	
	public void render(GLAutoDrawable drawable, Core core, float timeElapsed, Camera camera) {
		smokesystem.render(drawable, core, timeElapsed, camera, centerX, centerY);	
	}

	public void setStartPos(float centerX, float centerY) {
		this.centerX = centerX;
		this.centerY = centerY;
	}
}
