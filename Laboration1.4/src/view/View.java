package view;
import java.io.IOException;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLException;

import model.BallSimulation;


public class View {
	private BallSimulation ballsimulation;
	private Camera camera;

	
	private Core core = new Core();

	public View(BallSimulation ballsimulation, int width, int height) {
		this.ballsimulation = ballsimulation;
		camera = new Camera(ballsimulation.room.width, ballsimulation.room.height);
		camera.setDimensions(width, height);
		
	}

	public void render(GLAutoDrawable drawable) {
		try {
			core.loadResources();
		} catch (GLException | IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		core.clearScreen(drawable);
		
		drawRoom(drawable, ballsimulation);
		drawBall(drawable, ballsimulation);
		
	}
	
	
	private void drawRoom(GLAutoDrawable drawable, BallSimulation ballsimulation) {
		
		for  (int x = 0; x < ballsimulation.room.width; x++) {
			for (int y = 0; y < ballsimulation.room.height; y++)  {
				float w = camera.getScale();
				float h = camera.getScale();
					float vx = camera.toViewCoord(x);
					float vy = camera.toViewCoord(y);
					
					core.drawRoom(drawable, vx, vy, w, h, 1, 1, 1);
				}
			}
	}
	
	
	private void drawBall(GLAutoDrawable drawable, BallSimulation ballsimulation) {
		
		 float vx = camera.toViewCoord(ballsimulation.ball.centerX);
		 float vy = camera.toViewCoord(ballsimulation.ball.centerY);
		 float vBallSize = (ballsimulation.ball.diameter * camera.getScale());
		 
		 core.drawBall(drawable, vx - vBallSize / 2.0f, vy - vBallSize / 2.0f, vBallSize, vBallSize);
	}
	
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		core.reshape(drawable, x, y, w, h);
		camera.setDimensions(w, h);    
	}
}