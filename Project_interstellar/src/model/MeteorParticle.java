package model;

import java.util.Random;

import javax.media.opengl.GLAutoDrawable;

import view.Camera;
import view.Core;



/*
 * Each meteor particle gets a random size, velocity and delay. The delay
 * is used only to get the randomness of each meteor position instead of having them all on same position.
 */
public class MeteorParticle {
	
	// Position.
	private float x;
	private float y;
	
	// Direction.
	private float yi;
	
	// Radius.
	private float radius;
	
	// Life only used for the delay.
	private float life;
	
	// Max position for Y coordinate. Respawn on higher.
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
		this.radius = rand.nextFloat()*0.04f+0.02f;
		
		// Set delay for making the stars more unpredictable.
		this.delayTimeSeconds = rand.nextFloat() * 5.0f;
		
		// Speed of the rotation and its direction randomize.
		this.rotationSpeed = (rand.nextFloat() - 0.5f) * 1.0f;
	}
	
	public void update(float timeElapsed, Rocket rocket) {
		life = life + timeElapsed;
		if(isDelayed()){
			xi = xi + timeElapsed * 0.01f;
			x = x + timeElapsed * xi;
			yi = yi + timeElapsed * 0.07f;
			y = y + timeElapsed * yi;
			
			if(MeteorCollidedWithLeftWing(rocket)){
				rocket.leftWingGone = true;
			}
			if(MeteorCollidedWithRightWing(rocket)){
				rocket.rightWingGone = true;
			}
			if(MeteorCollidedWithRocket(rocket)){
				rocket.isAlive = false;
			}
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
			float viewSize = ((radius * 2.0f) * camera.getScale());

			core.drawMeteor(drawable, viewX - viewSize / 2.0f, viewY - viewSize / 2.0f, viewSize, viewSize);		
	}

	public float getPositionY() {
		return y;
	}
	
	public float getPositionX() {
		return x;
	}

	public float getRadius() {
		return radius;
	}

	private boolean MeteorCollidedWithRocket(Rocket rocket) {
		
		   float cx = Math.abs(x - rocket.centerX - (rocket.width/2));
		    float xDist = (rocket.width/2) + radius;
		    if (cx > xDist){
		    	return false;
		    }
		    float cy = Math.abs(y - rocket.centerY - (rocket.height/2));
		    float yDist = (rocket.height/2) + radius;
		    if (cy > yDist){
		        return false;
		    }
		    
		    if (cx <= (rocket.width/2) || cy <= (rocket.height/2)){
		        return true;
		    }
		    float xCornerDist = cx - (rocket.width/2);
		    float yCornerDist = cy - (rocket.height/2);
		    
		    float xCornerDistSq = xCornerDist * xCornerDist;
		    float yCornerDistSq = yCornerDist * yCornerDist;
		    
		    float maxCornerDistSq = radius *radius;
		    
		    return xCornerDistSq + yCornerDistSq <= maxCornerDistSq;
	}
	
	private boolean MeteorCollidedWithLeftWing(Rocket rocket) {
		
		   float cx = Math.abs(x - rocket.leftcenterX - (rocket.leftwidth/2));
		    float xDist = (rocket.leftwidth/2) + radius;
		    if (cx > xDist){
		    	return false;
		    }
		    float cy = Math.abs(y - rocket.leftcenterY - (rocket.leftheight/2));
		    float yDist = (rocket.leftheight/2) + radius;
		    if (cy > yDist){
		        return false;
		    }
		    
		    if (cx <= (rocket.leftwidth/2) || cy <= (rocket.leftheight/2)){
		        return true;
		    }
		    float xCornerDist = cx - (rocket.leftwidth/2);
		    float yCornerDist = cy - (rocket.leftheight/2);
		    
		    float xCornerDistSq = xCornerDist * xCornerDist;
		    float yCornerDistSq = yCornerDist * yCornerDist;
		    
		    float maxCornerDistSq = radius *radius;
		    
		    return xCornerDistSq + yCornerDistSq <= maxCornerDistSq;
	}
	
	private boolean MeteorCollidedWithRightWing(Rocket rocket) {
		
		   float cx = Math.abs(x - rocket.rightcenterX - (rocket.rightwidth/2));
		    float xDist = (rocket.rightwidth/2) + radius;
		    if (cx > xDist){
		    	return false;
		    }
		    float cy = Math.abs(y - rocket.rightcenterY - (rocket.rightheight/2));
		    float yDist = (rocket.rightheight/2) + radius;
		    if (cy > yDist){
		        return false;
		    }
		    
		    if (cx <= (rocket.rightwidth/2) || cy <= (rocket.rightheight/2)){
		        return true;
		    }
		    float xCornerDist = cx - (rocket.rightwidth/2);
		    float yCornerDist = cy - (rocket.rightheight/2);
		    
		    float xCornerDistSq = xCornerDist * xCornerDist;
		    float yCornerDistSq = yCornerDist * yCornerDist;
		    
		    float maxCornerDistSq = radius *radius;
		    
		    return xCornerDistSq + yCornerDistSq <= maxCornerDistSq;
	}
}