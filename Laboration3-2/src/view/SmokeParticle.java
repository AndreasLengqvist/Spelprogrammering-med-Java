package view;

import java.util.Random;

import javax.media.opengl.GLAutoDrawable;

public class SmokeParticle {
	
	// Position.
	private float x;
	private float y;
	
	// Direction.
	private float xi;
	private float yi;

	// Gravity.
	private float xg;
	private float yg;
	
	private float fade;
	private float size;
	private float lifePercent;
	private float life;
	private float maxLife;
	private float delayTimeSeconds;
	
	private static float minSize = 0.0f;
	private static float maxSize = 20.0f;
	private static float minFade = 1.0f;
	private static float maxFade = 0.0f;

	
	public SmokeParticle(float startPosX, float startPosY){
		respawn(startPosX, startPosY);
	}
	
	public void respawn(float posX, float posY) {
		
		Random rand = new Random();

		
		// Set Starting position.
		this.x = posX;
		this.y = posY;
		
		// Set fade.
		this.fade = 1.0f;
		
		// Set gravity.
		this.xg = 4.0f;
		this.yg = -10.0f;
		
		// Set random direction.
		this.xi = (rand.nextFloat() - 1.5f) * 10.0f;
		this.yi = (rand.nextFloat() - 1.0f) * 20.0f;
		
		// Set delay for making the smoke more unpredictable.
		this.delayTimeSeconds = rand.nextFloat() * 3.0f;
		
		// Set random max life. The last value is the variable of life also know as the height of the smoke.
		this.maxLife = 2.5f;
		
		
		// Reset the life.
		this.life = 0.0f;
		
		// Reset size.
		this.size = 0.0f;
	}
	
	public void update(float timeElapsed){
		life = life + timeElapsed;
		
		if(isDelayed()){
			xi = xi + timeElapsed * xg;
			yi = yi + timeElapsed * yg;
			
			x = x + timeElapsed * xi;
			y = y + timeElapsed * yi;
			
				
			lifePercent = (life-delayTimeSeconds) / maxLife;
			size =  minSize + lifePercent * maxSize;
			fade = maxFade + lifePercent * minFade;
		}
	}

	public void draw(GLAutoDrawable drawable, Core core, Camera camera) {
		
			float viewX = camera.toViewCoord(x);
			float viewY = camera.toViewCoord(y);
			float viewSize = camera.toViewCoord(size);
			 
			float color[] = new float[4];
			color[0] = color[1] = color[2] = 1;
			color[3] = 1.0f - fade;
			 
			core.drawSmoke(drawable, viewX, viewY, viewSize, viewSize, color);		
		
	}
	
	public boolean isAlive() {
		return life < (maxLife+delayTimeSeconds);
	}
	
	public boolean isDelayed() {
		return life > delayTimeSeconds;
	}
}