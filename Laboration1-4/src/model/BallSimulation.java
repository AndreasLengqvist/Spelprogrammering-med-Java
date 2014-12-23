package model;



public class BallSimulation {
	
	public Ball ball = new Ball();
	public Box box = new Box();

	  
	public void update(float timeElapsedSeconds) {
		
		ball.centerY = ball.centerY + ball.speedY * timeElapsedSeconds;
		ball.centerX = ball.centerX + ball.speedX * timeElapsedSeconds;
		
		if (ball.centerX + ball.radius > box.width) {
			ball.speedX *= -1.0f;
			ball.centerX = box.width - ball.radius;
		}
		
		if (ball.centerX - ball.radius < 0) {
			ball.speedX *= -1.0f;
			ball.centerX = 0.0f + ball.radius;
		}
		
		if (ball.centerY + ball.radius > box.height) {
			ball.speedY *= -1.0f;
			ball.centerY = box.height - ball.radius;
		}
		
		if (ball.centerY - ball.radius < 0.0f) {
			ball.speedY *= -1.0f;
			ball.centerY = 0.0f + ball.radius;
		}
		

		
		
		
	}
}
