package view;

import javax.media.opengl.GLAutoDrawable;


/*
 * System for creating each star in the universe with re spawn method.
 */
public class StarSystem {
	
	private StarParticle particles[];
	private static int MAX_PARTICLES = 300;	
	
	
	public StarSystem(){
		particles = new StarParticle[MAX_PARTICLES];
		for(int i = 0; i < MAX_PARTICLES; i++){			
			particles[i] = new StarParticle();
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
				particles[i].respawn();
			}
		}		
	}
}