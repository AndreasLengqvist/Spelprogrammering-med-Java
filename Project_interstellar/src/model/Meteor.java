package model;



public class Meteor {
	
	public float centerX = 0.5f;
	public float centerY = 0.75f;
	public float radius = 0.05f;
		
	public float speedX = 0.0f;
	public float speedY = 0.1f;
	private float delayTime;
	
	public Meteor(){
		
	}
	

	public void update(float timeElapsedSeconds, Rocket rocket, Box box) {

//		delayTime += timeElapsedSeconds;
//		
//		boolean hasExploded = false;
		boolean isAlive = true;
//		
		if(isAlive){
		}
//		if(isAlive && delayTime > 3.5f){
//			rocket.centerY = rocket.centerY - rocket.speedY * timeElapsedSeconds;
//			rocket.centerX = rocket.centerX + rocket.speedX * timeElapsedSeconds;
//		}
	}
}
