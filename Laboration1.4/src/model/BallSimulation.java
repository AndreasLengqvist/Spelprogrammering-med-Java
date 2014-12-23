package model;

public class BallSimulation {
	
	public Room room = new Room();
	public Ball ball = new Ball();
	
	public void update(float timeElapsedSeconds) {
		
		ball.centerX = ball.centerX + ball.speedX * timeElapsedSeconds;
		
		if (ball.centerX + ball.diameter/2 > room.width) {
			ball.speedX = ball.speedX * -1.0f;
		}
		if (ball.centerX - ball.diameter/2 < 0) {
			ball.speedX = ball.speedX * -1.0f;
		}
		
		ball.centerY = ball.centerY + ball.speedY * timeElapsedSeconds;
		
		if (ball.centerY + ball.diameter/2 > room.height) {
			ball.speedY = ball.speedY * -1.0f;
		}
		
		if (ball.centerY - ball.diameter/2 < 0) {
			ball.speedY = ball.speedY * -1.0f;
		}
	}
}
