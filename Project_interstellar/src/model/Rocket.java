package model;



public class Rocket {
	
	// Rocket coordinates.	
	public float width = 0.035f;
	public float height = 0.12f;
	public float centerX = 0.75f;
	public float centerY = 1.20f;
	
	// Left wing coordinates.
	public float leftwidth = 0.03f;
	public float leftheight = 0.07f;
	public float leftcenterX = 0.72f;
	public float leftcenterY = 1.235f;
	
	// Right wing coordinates.
	public float rightwidth = 0.03f;
	public float rightheight = 0.07f;
	public float rightcenterX = 0.785f;
	public float rightcenterY = 1.235f;
		
	public float speedX = 0.0f;
	public float speedY = 0.1f;
	
	public RepairKit repairkit;

	boolean doRepair = false;
	boolean isAlive = true;
	boolean leftWingGone = false;
	boolean rightWingGone = false;
	boolean sendOutOnce = true;
	public boolean repairKitFetched = false;

	

	public void update(float timeElapsedSeconds, Rocket rocket, Box box, IRocketObserver observer, MeteorSystem meteorsystem, int lightYears) {

		if(centerY > 0.75f){
			centerY -= timeElapsedSeconds * 0.25f;
			leftcenterY -= timeElapsedSeconds * 0.25f;
			rightcenterY -= timeElapsedSeconds * 0.25f;
		}

		if(isAlive){
			observer.doAlive(rocket.centerX, rocket.centerY);
		}
		if(!isAlive){
			observer.doExplode(rocket.centerX, rocket.centerY);
		}
		
		if(leftWingGone){
			observer.doDestroyLeftWing();
		}
		
		if(rightWingGone){
			observer.doDestroyRightWing();
		}
		
		int repairCounter = lightYears % 100;
		
		if(repairCounter == 0){
			sendOutOnce  = true;
		}
		
		if(repairCounter == 99){
			if(sendOutOnce){
				repairkit = new RepairKit();
				sendOutOnce = false;
			}
		}
		if(repairkit != null){
			observer.doSendOutRepairKit();
			repairkit.update(timeElapsedSeconds, rocket);
		}
		
		if(doRepair){
			observer.doRepairShip();
			leftWingGone = false;
			rightWingGone = false;
			doRepair = false;
		}
	}
}