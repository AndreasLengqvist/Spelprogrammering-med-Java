package view;

import javax.media.opengl.GLAutoDrawable;
import model.BallSimulation;


public class View {
	private BallSimulation ballsimulation;
	private Camera camera;

	
	private Core core = new Core();

	public View(BallSimulation ballsimulation, int width, int height) {
		this.ballsimulation = ballsimulation;
		camera = new Camera(ballsimulation.box.width, ballsimulation.box.height);
		
	}

	public void render(GLAutoDrawable drawable) {

		core.loadResources();
		core.clearScreen(drawable);
		
		drawBox(drawable, ballsimulation);
		drawBall(drawable, ballsimulation);
		
	}
	
	
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		core.reshape(drawable, x, y, w, h);
		camera.setDimensions(w, h);    
	}
	
	
	private void drawBox(GLAutoDrawable drawable, BallSimulation ballsimulation) {
		
		for  (int x = 0; x < ballsimulation.box.width; x++) {
			for (int y = 0; y < ballsimulation.box.height; y++)  {
				float w = camera.getScale();
				float h = camera.getScale();
					float vx = camera.toViewCoord(x);
					float vy = camera.toViewCoord(y);
					
					core.drawBox(drawable, vx, vy, w, h, 1, 1, 0);
				}
			}
	}
	
	
	private void drawBall(GLAutoDrawable drawable, BallSimulation ballsimulation) {
		
		 float vx = camera.toViewCoord(ballsimulation.ball.centerX);
		 float vy = camera.toViewCoord(ballsimulation.ball.centerY);
		 float vBallSize = ((ballsimulation.ball.radius * 2.0f) * camera.getScale());
		 
		 core.drawBall(drawable, vx - vBallSize / 2.0f, vy - vBallSize / 2.0f, vBallSize, vBallSize);
	}
}