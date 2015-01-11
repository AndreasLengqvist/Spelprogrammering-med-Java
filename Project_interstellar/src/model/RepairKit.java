package model;

import java.util.Random;

import javax.media.opengl.GLAutoDrawable;

import view.Camera;
import view.Core;


public class RepairKit {
	
	// Position.
	private float x;
	private float y;
	
	// Direction.
	private float yi;
	
	// Radius.
	private float radius;
	
	// Max position for Y coordinate. Respawn on higher.
	private float maxY = 1.5f;
	private boolean doOnce = true;
	

	
	public RepairKit(){
		respawn();
	}
	
	public void respawn() {
		
		Random rand = new Random();
		// Set Starting position.
		this.x = rand.nextFloat();
		this.y = (-rand.nextFloat()*0.5f)-0.2f;
		
		// Set random direction.
		
		this.yi = rand.nextFloat() * 0.01f;
		
		// Reset size.
		this.radius = 0.03f;
	}
	
	public void update(float timeElapsed, Rocket rocket) {
		
			yi = yi + timeElapsed * 0.03f;
			y = y + timeElapsed * yi;
			
			if(RepairKitCollidedWithRocket(rocket)){
				if(doOnce ){
					radius = 0.0f;
					rocket.doRepair = true;
					rocket.repairKitFetched = true;
					doOnce = false;
				}
			}
	}
	
	// Re spawn control.
	public boolean isAlive() {
		return y < maxY;
	}


	public void draw(GLAutoDrawable drawable, Core core, Camera camera) {
			float viewX = camera.toViewCoord(x);
			float viewY = camera.toViewCoord(y);
			float viewSize = ((radius * 2.0f) * camera.getScale());

			core.drawRepairKit(drawable, viewX - viewSize / 2.0f, viewY - viewSize / 2.0f, viewSize, viewSize);		
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

	private boolean RepairKitCollidedWithRocket(Rocket rocket) {
		
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
}