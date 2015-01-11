package model;

import javax.media.opengl.GLAutoDrawable;

import view.Camera;
import view.Core;


/*
 * System for creating each star in the universe with re spawn method.
 */
public class MeteorSystem {
	
	public MeteorParticle particles[];
	private int MAX_PARTICLES;
	
	
	public MeteorSystem(int MAX_PARTICLES){
		this.MAX_PARTICLES = MAX_PARTICLES;
		particles = new MeteorParticle[MAX_PARTICLES];
		for(int i = 0; i < MAX_PARTICLES; i++){			
			particles[i] = new MeteorParticle();
		}
	}

	public void render(GLAutoDrawable drawable, Core core, Camera camera) {
		for(int i = 0; i < MAX_PARTICLES; i++){
			particles[i].draw(drawable, core, camera);
		}
	}

	public void update(float timeElapsed, Rocket rocket, boolean newLevel) {
		for(int i = 0; i < MAX_PARTICLES; i++){
			if(particles[i].isAlive()){				
				particles[i].update(timeElapsed, rocket);
			}
			else if (!newLevel) {	
				particles[i].respawn();
			}
		}		
	}
}