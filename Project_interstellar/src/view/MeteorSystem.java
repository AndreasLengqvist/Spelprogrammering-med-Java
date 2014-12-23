package view;

import javax.media.opengl.GLAutoDrawable;


/*
 * System for creating each star in the universe with re spawn method.
 */
public class MeteorSystem {
	
	private MeteorParticle particles[];
	private static int MAX_PARTICLES = 100;	
	
	
	public MeteorSystem(){
		particles = new MeteorParticle[MAX_PARTICLES];
		for(int i = 0; i < MAX_PARTICLES; i++){			
			particles[i] = new MeteorParticle();
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