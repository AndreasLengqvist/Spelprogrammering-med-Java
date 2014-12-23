package view;

import java.util.Random;

import javax.media.opengl.GLAutoDrawable;



public class SplitterSystem {

	private SplitterParticle particles[];
	private int NUM_PARTICLES = 100;
	
	
	SplitterSystem(float startPosX, float startPosY){
		particles = new SplitterParticle[NUM_PARTICLES];
		spawnNewSystem(startPosX, startPosY);
	}

	private void spawnNewSystem(float startPosX, float startPosY) {
		Random rand = new Random();
		for(int i = 0; i < NUM_PARTICLES; i++){
			float vx = (rand.nextFloat() - 0.5f) * 120;
			float vy = (rand.nextFloat() - 0.5f) * 200;
			particles[i] = new SplitterParticle(startPosX, startPosY, vx, vy);
		}
	}
	
	public void render(GLAutoDrawable drawable, Core core, float timeElapsed, Camera camera) {
		update(timeElapsed);
		draw(drawable, camera, core);
	}

	private void draw(GLAutoDrawable drawable, Camera camera, Core core) {
		for(int i = 0; i < NUM_PARTICLES; i++){
			particles[i].draw(drawable, camera, core);
		}
	}

	private void update(float timeElapsed) {
		for(int i = 0; i < NUM_PARTICLES; i++){
			particles[i].update(timeElapsed);
		}		
	}
}