package view;

import java.util.Random;

import javax.media.opengl.GLAutoDrawable;



/*
 * Each star particle gets a random size, velocity and delay. The delay
 * is used only to get the randomness of each star position instead of having them all on same position.
 */
public class StarParticle {
	
	// Position.
	private float x;
	private float y;
	
	// Direction.
	private float yi;
	
	// Variable that has different value as in the menu or in a game and level.
	private float starSpeed;
	
	// Size.
	private float size;
	
	// Max position for Y coordinate. Respawn on higher.
	private float maxY = 1.1f;
	private float boost;

	public StarParticle(){
		Random rand = new Random();
		this.y = rand.nextFloat();
		respawn();
	}
	
	public void respawn() {
		Random rand = new Random();

		// If the particles life has ended reset Y-position.
		if(y > 1.1f){
			this.y = -0.1f;
		}

		// Set Starting X-position.
		this.x = 0.0f + (float)(Math.random() * ((1.5f - 0.0f) + 1.0f));
		
		// Set random direction.
		this.yi = rand.nextInt(100 - 0 + 1);
		
		if(yi < 0.000001f){
			yi += 0.001f;
		}
		
		// Reset size.
		this.size = rand.nextFloat()*0.01f;
	}
	
	public void update(float timeElapsed, float starSpeed){
		this.starSpeed = starSpeed;
		y = y + (timeElapsed * (yi*starSpeed)) + boost;
		if(y < 0.0f){
			Math.abs(y);
		}
	}
	
	// Respawn control.
	public boolean isAlive() {
		return y < maxY;
	}

	public void draw(GLAutoDrawable drawable, Core core, Camera camera) {
			float viewX = camera.toViewCoord(x);
			float viewY = camera.toViewCoord(y);
			float viewSize = camera.toViewCoord(size);
			core.drawStar(drawable, viewX, viewY, viewSize, viewSize);		
	}
}