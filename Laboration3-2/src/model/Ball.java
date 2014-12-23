package model;

import java.util.Random;

public class Ball {
	private Box box;
	public float radius = 2.0f;
		
	public float speedX = 30.0f;
	public float speedY = 50.0f;
	public float centerX;
	public float centerY;
	public boolean isAlive = true;
	
	
	public Ball(Box box){
		
		Random rand = new Random();

		this.box = box;
		this.centerX = rand.nextFloat()*100;
		this.centerY = rand.nextFloat()*100;
	}
	
	public void update(float timeElapsedSeconds){
		
		if(isAlive){
			centerY = centerY + speedY * timeElapsedSeconds;
			centerX = centerX + speedX * timeElapsedSeconds;
			
			if (centerX + radius > box.width) {
				speedX *= -1.0f;
				centerX = box.width - radius;
			}
			
			if (centerX - radius < 0) {
				speedX *= -1.0f;
				centerX = 0.0f + radius;
			}
			
			if (centerY + radius > box.height) {
				speedY *= -1.0f;
				centerY = box.height - radius;
			}
			
			if (centerY - radius < 0.0f) {
				speedY *= -1.0f;
				centerY = 0.0f + radius;
			}
		}
	}

	public void didBallDie(float x, float y) {
		float dx = (centerX - x);
		float dy = (centerY - y);
		
		// Pythagoras do make the "circle" / "hitarea" around the gunshot.
		float length = (float) Math.sqrt(dx*dx+dy*dy);
		
		if(length < 5.0f){
			killBall();
		}
	}

	private void killBall() {
		isAlive  = false;
	}
}
