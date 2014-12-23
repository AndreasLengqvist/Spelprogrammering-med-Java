package view;

import javax.media.opengl.GLAutoDrawable;



public class ParticleSystem {
	
	private Particle particles[];
	private static int MAX_PARTICLES = 1;
	private static float startPosX = 0.5f;
	private static float startPosY = 0.9f;
	
	
	
	public ParticleSystem(){
		particles = new Particle[MAX_PARTICLES];
		for(int i = 0; i < MAX_PARTICLES; i++){			
			particles[i] = new Particle(startPosX, startPosY);
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
		}		
	}
}