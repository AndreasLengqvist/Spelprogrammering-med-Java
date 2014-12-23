package model;



public class BallSimulation {
	
	public Ball balls[];
	public Box box;
	

	public static int MAX_BALLS = 10;
	
	public BallSimulation(){
		this.box = new Box();
		
		balls = new Ball[MAX_BALLS];
		for(int i = 0; i < MAX_BALLS; i++){
			balls[i] = new Ball(box);
		}
	}

	  
	public void update(float timeElapsedSeconds) {
		for(int i = 0; i < MAX_BALLS; i++){
			balls[i].update(timeElapsedSeconds);
		}
	}


	public void didBallDie(float x, float y) {
		for(int i = 0; i < MAX_BALLS; i++){
			balls[i].didBallDie(x, y);
		}
	}
}
