package model;



public class Model {
	
	private static int LEVEL_1_METEOR = 1;
	
	public Rocket rocket = new Rocket();
	public Box box = new Box();
	
	public void update(float timeElapsedSeconds, IRocketObserver observer) {
		rocket.update(timeElapsedSeconds, rocket, box, observer);
	}
}
