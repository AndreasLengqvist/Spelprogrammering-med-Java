package view;

import javax.media.opengl.GLAutoDrawable;



public class SmokeSystem {
	
	private SmokeParticle particles[];
	
	private float startPosX;
	private float startPosY;
	
	private static int MAX_PARTICLES = 100;
	
	
	public SmokeSystem(float startPosX, float startPosY){
		this.startPosX = startPosX;
		this.startPosY = startPosY;
		particles = new SmokeParticle[MAX_PARTICLES];
		for(int i = 0; i < MAX_PARTICLES; i++){			
			particles[i] = new SmokeParticle(startPosX, startPosY);
		}
	}
	
	public void render(GLAutoDrawable drawable, Core core, float timeElapsed, Camera camera) {
		update(timeElapsed);
		draw(drawable, core, camera);
	}

	private void draw(GLAutoDrawable drawable, Core core, Camera camera) {
		for(int i = 0; i < MAX_PARTICLES; i++){
			particles[i].draw(drawable, core, camera);
		}
	}

	private void update(float timeElapsed) {
		for(int i = 0; i < MAX_PARTICLES; i++){
			if(particles[i].isAlive()){
				particles[i].update(timeElapsed);
			}
			else {	
				particles[i].respawn(this.startPosX, this.startPosY);
			}
		}		
	}
}