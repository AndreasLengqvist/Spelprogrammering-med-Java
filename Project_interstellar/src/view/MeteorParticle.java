package view;

import java.util.Random;
import javax.media.opengl.GLAutoDrawable;



/*
 * Each star particle gets a random size, velocity and delay. The delay
 * is used only to get the randomness of each star position instead of having them all on same position.
 */
public class MeteorParticle {
	
	// Position.
	private float x;
	private float y;
	
	// Direction.
	private float yi;
	
	// Size.
	private float size;
	
	// Life only used for the delay.
	private float life;
	
	// Max position for Y coordinate. Re spawn on higher.
	private float maxY = 1.5f;
	
	// Delay.
	private float delayTimeSeconds;
	private float xi;
	private float rotation;
	private float rotationSpeed;

	
	public MeteorParticle(){
		respawn();
	}
	
	public void respawn() {
		
		Random rand = new Random();
		
		// Set Starting position.
		this.x = rand.nextFloat();
		this.y = (-rand.nextFloat()*0.5f)-0.2f;
		
		// Set random direction.
		this.yi = rand.nextFloat() * 0.01f;
		this.xi = (rand.nextFloat() - 0.1f) * 1.0f;

		// Reset the life.
		this.life = 0.0f;
		
		// Reset size.
		this.size = rand.nextFloat()*0.07f+0.05f;
		
		// Set delay for making the stars more unpredictable.
		this.delayTimeSeconds = rand.nextFloat() * 5.0f;
		
		// Speed of the rotation and its direction randomize.
		this.rotationSpeed = (rand.nextFloat() - 0.5f) * 1.0f;
	}
	
	public void update(float timeElapsed){
		life = life + timeElapsed;
		if(isDelayed()){
			
			rotation += rotationSpeed;
			
			xi = xi + timeElapsed * 0.01f;
			x = x + timeElapsed * xi;
			yi = yi + timeElapsed * 0.07f;
			y = y + timeElapsed * yi;
		}
	}
	
	// Re spawn control.
	public boolean isAlive() {
		return y < maxY;
	}
	
	// Delay control.
	public boolean isDelayed() {
		return life > delayTimeSeconds;
	}

	public void draw(GLAutoDrawable drawable, Core core, Camera camera) {
			float viewX = camera.toViewCoord(x);
			float viewY = camera.toViewCoord(y);
			float viewSize = camera.toViewCoord(size);
			core.drawMeteor(drawable, viewX, viewY, viewSize, viewSize, rotation);		
	}
}