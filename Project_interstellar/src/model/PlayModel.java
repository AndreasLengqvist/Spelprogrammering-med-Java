package model;



public class PlayModel {
	
	public enum LevelState { LEVEL1, LEVEL2, LEVEL3 };
	public LevelState levelstate = LevelState.LEVEL1;

	
	public Rocket rocket = new Rocket();
	public Box box = new Box();
	
	public MeteorSystem meteorsystem;


	private boolean doLevel1 = true;
	private boolean doLevel2 = true;
	private boolean doLevel3 = true;


	private float delay2;
	private float delay3;


	private boolean newLevel = false;

	
	/*
	 *  In case of which level the game is in different MeteorSystem will spawn.
	 *  When a new level is started there is a little delay. Only to let the old MeteorSystem finish.
	 */
	public void update(float timeElapsedSeconds, IRocketObserver observer, float life, int lightYears) {		
		switch(levelstate){
		
	    case LEVEL1:
	    	if(doLevel1){
	    		meteorsystem = new MeteorSystem(50);
	    		doLevel1 = false;
	    	}
			if(meteorsystem != null && life > 10.0f){
				meteorsystem.update(timeElapsedSeconds, rocket, newLevel );
			}
	    	break;
	    	
	    case LEVEL2:
	    	delay2 += timeElapsedSeconds;
	    	
	    	if(doLevel2) {
	    		newLevel = true;
	    	}
	    	if(doLevel2 && delay2 > 10.0f){
		    		meteorsystem = new MeteorSystem(150);
		    		newLevel = false;
		    		doLevel2 = false;
	    	}
			if(meteorsystem != null){
				meteorsystem.update(timeElapsedSeconds, rocket, newLevel);
			}
    		break;
    	
    case LEVEL3:
    	delay3 += timeElapsedSeconds;
    	
    	if(doLevel3) {
    		newLevel = true;
    	}
    	if(doLevel3 && delay3 > 15.0f){
	    		meteorsystem = new MeteorSystem(200);
	    		newLevel = false;
	    		doLevel3 = false;
    	}
		if(meteorsystem != null){
			meteorsystem.update(timeElapsedSeconds, rocket, newLevel);
		}
		break;
	}
		
		rocket.update(timeElapsedSeconds, rocket, box, observer, meteorsystem, lightYears);
	}

	public boolean gameover() {
		if(!rocket.isAlive){
			return true;
		}
		return false;
	}
	
	public boolean leftWingIsGone() {
		if(rocket.leftWingGone){
			return true;
		}
		return false;
	}
	
	public boolean rightWingIsGone() {
		if(rocket.rightWingGone){
			return true;
		}
		return false;
	}
	
	public boolean repairKitFetched() {
		if(rocket.repairKitFetched){
			rocket.repairKitFetched = false;
			return true;
		}
		return false;
	}
}
