package model;

public class Rocket {
	public float centerX = 50.0f;
	public float centerY = 80.0f;
	public float radius = 5.0f;
		
	public float speedX = 0.0f;
	public float speedY = 10.0f;
	private float delayTime;

	public void update(float timeElapsedSeconds, Rocket rocket, Box box, IRocketObserver observer) {

		delayTime += timeElapsedSeconds;
		
		boolean hasExploded = false;
		boolean isAlive = true;
		
		if(isAlive && delayTime > 3.5f){
			rocket.centerY = rocket.centerY - rocket.speedY * timeElapsedSeconds;
			rocket.centerX = rocket.centerX + rocket.speedX * timeElapsedSeconds;
		}
		
		if(rocket.radius > 0.0f && isAlive){
			observer.doAlive(rocket.centerX, rocket.centerY);
		}
		
		if(rocket.centerY - rocket.radius < 0.0f) {
			rocket.speedY = rocket.speedY * -1.0f;
			hasExploded = true;
		}
		
		if(hasExploded){
			observer.doExplode(rocket.centerX, rocket.centerY);
			rocket.radius = 0.0f;
			isAlive = false;
		}
	}
}