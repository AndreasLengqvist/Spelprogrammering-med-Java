package model;

public class Rocket {
	public float centerX = 0.75f;
	public float centerY = 1.20f;
	public float radius = 0.05f;
		
	public float speedX = 0.0f;
	public float speedY = 0.1f;
	private float delayTime;

	public void update(float timeElapsedSeconds, Rocket rocket, Box box, IRocketObserver observer) {

		if(centerY > 0.75f){
			centerY -= timeElapsedSeconds*0.05f;
		}
//		delayTime += timeElapsedSeconds;
//		
//		boolean hasExploded = false;
		boolean isAlive = true;
//		
		if(isAlive){
			observer.doAlive(rocket.centerX, rocket.centerY);
		}
//		if(isAlive && delayTime > 3.5f){
//			rocket.centerY = rocket.centerY - rocket.speedY * timeElapsedSeconds;
//			rocket.centerX = rocket.centerX + rocket.speedX * timeElapsedSeconds;
//		}
	}
}