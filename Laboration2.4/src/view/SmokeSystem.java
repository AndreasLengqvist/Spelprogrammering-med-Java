package view;

import javax.media.opengl.GLAutoDrawable;



public class SmokeSystem {
	
	private Particle particles[];
	private static int MAX_PARTICLES = 500;
	
	
	
	public SmokeSystem(float startPosX, float startPosY){
		particles = new Particle[MAX_PARTICLES];
		for(int i = 0; i < MAX_PARTICLES; i++){			
			particles[i] = new Particle(startPosX, startPosY);
		}
	}
	
	public void render(GLAutoDrawable drawable, Core core, float timeElapsed, Camera camera, float startPosX, float startPosY) {
		update(timeElapsed, startPosX, startPosY);
		draw(drawable, core, camera);
	}

	private void draw(GLAutoDrawable drawable, Core core, Camera camera) {
		for(int i = 0; i < MAX_PARTICLES; i++){
			particles[i].draw(drawable, core, camera);
		}
	}

	private void update(float timeElapsed, float startPosX, float startPosY) {
		for(int i = 0; i < MAX_PARTICLES; i++){
			if(particles[i].isAlive()){
				particles[i].update(timeElapsed);
			}
			else {	
				particles[i].respawn(startPosX, startPosY);
			}
		}		
	}
}