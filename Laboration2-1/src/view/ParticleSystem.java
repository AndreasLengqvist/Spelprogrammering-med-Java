package view;

import java.util.Random;

import javax.media.opengl.GLAutoDrawable;

public class ParticleSystem {

	private static final float MAX_TIME = 3;
	private Particle particles[];
	private int NUM_PARTICLES = 100;
	private float totalTime = 0;
	
	ParticleSystem(){
		particles = new Particle[NUM_PARTICLES];
		
		float startPosX = 300;
		float startPosY = 300;
		
		spawnNewSystem(startPosX, startPosY);
	}


	private void spawnNewSystem(float startPosX, float startPosY) {
		Random rand = new Random();
		
		for(int i = 0; i < NUM_PARTICLES; i++){
			float vx = (rand.nextFloat() - 0.5f) * 220;
			float vy = (rand.nextFloat() - 0.5f) * 220;
			
			particles[i] = new Particle(startPosX, startPosY, vx, vy);
		}
	}
	
	
	public void render(GLAutoDrawable drawable, Core core, float timeElapsed) {

		update(timeElapsed);
		draw(drawable, core);
	}


	private void draw(GLAutoDrawable drawable, Core core) {
		for(int i = 0; i < NUM_PARTICLES; i++){
			particles[i].draw(drawable, core);
		}
	}


	private void update(float timeElapsed) {
		totalTime += timeElapsed;
		for(int i = 0; i < NUM_PARTICLES; i++){
			particles[i].update(timeElapsed);
		}		
		
		if(totalTime > MAX_TIME){
			totalTime = 0;
			spawnNewSystem(300, 300);
		}
	}

	
	
	
}
