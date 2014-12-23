package view;

import java.util.Random;

import javax.media.opengl.GLAutoDrawable;

public class Particle {
	
	// Position.
	private float x;
	private float y;
	
	private float fade = 1.0f;
	private float size;
	private float life;
	private float maxLife;
	private float delayTimeSeconds;
	private float framePercent;
	private int frame;
	
	private static float minSize = 0.0f;
	private static float maxSize = 0.1f;
	private static float minFade = 1.0f;
	private static float maxFade = 0.0f;

	
	public Particle(float startPosX, float startPosY){
		respawn(startPosX, startPosY);
	}
	
	public void respawn(float posX, float posY) {
		
		Random rand = new Random();

		
		// Set Starting position.
		this.x = posX;
		this.y = posY;
		
		// Set fade.
		this.fade = 1.0f;
		
		
		// Set random max life. The last value is the variable of life also know as the height of the smoke.
		this.maxLife = 1.0f;
		
		
		// Reset the life.
		this.life = 0.0f;
		
		// Reset size.
		this.size = 0.1f;
	}
	
	public void update(float timeElapsed){
		life = life + timeElapsed;
				
		framePercent = life / maxLife;
		frame = (int)(framePercent * 24);
		System.out.println(framePercent);
	}

	public void draw(GLAutoDrawable drawable, Core core, Camera camera) {
		
			float viewX = camera.toViewCoord(x);
			float viewY = camera.toViewCoord(y);
			float viewSize = camera.toViewCoord(size);
			 
			float color[] = new float[4];
			color[0] = color[1] = color[2] = 1;
			color[3] = fade;
			 
			core.drawSmoke(drawable, viewX, viewY, viewSize, viewSize, frame);		
		
	}

	public boolean isAlive() {
		return life < (maxLife+0.3f);
	}
}