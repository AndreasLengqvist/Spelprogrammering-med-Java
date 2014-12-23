package view;

import java.util.ArrayList;

import javax.media.opengl.GLAutoDrawable;

import model.Ball;
import model.BallSimulation;


public class View{
	
	private BallSimulation ballsimulation;
	private Camera camera;
	private Core core = new Core();
	private ParticleSystem particlesystem;
	private Input input;
	
	ArrayList<ParticleSystem> particlesystems = new ArrayList<>();


	public View(BallSimulation ballsimulation, Input input, int width, int height) {
		this.ballsimulation = ballsimulation;
		this.input = input;

		camera = new Camera(100.0f, 100.0f);
		camera.setDimensions(width, height);    
	}

	public void render(GLAutoDrawable drawable, float timeElapsed) {
		
		core.loadResources();
		core.clearScreen(drawable);

		drawBox(drawable, ballsimulation);
		
		for(int i = 0; i < BallSimulation.MAX_BALLS; i++){
			drawBall(drawable, ballsimulation.balls[i]);
		}
		
		for (ParticleSystem particlesystem : particlesystems) {
			particlesystem.render(drawable, core, timeElapsed, camera);	
		}
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
					core.drawBox(drawable, vx, vy, w, h, 0.3f, 0.3f, 0.3f);
				}
			}
	}
	
	private void drawBall(GLAutoDrawable drawable, Ball ball) {
		
		 float vx = camera.toViewCoord(ball.centerX);
		 float vy = camera.toViewCoord(ball.centerY);
		 float vBallSize = ((ball.radius * 2.0f) * camera.getScale());
		 if(ball.isAlive){
			 core.drawBall(drawable, vx - vBallSize / 2.0f, vy - vBallSize / 2.0f, vBallSize, vBallSize);
		 }
		 else {
			 core.drawDeadBall(drawable, vx - vBallSize / 2.0f, vy - vBallSize / 2.0f, vBallSize, vBallSize);
		 }
	}
	
	
	public float getMouseXPos() {
		float viewMousePos = input.getMousePosX();
		return camera.toModelX(viewMousePos);
	}
	
	public float getMouseYPos() {
		float viewMousePos = input.getMousePosY();
		return camera.toModelY(viewMousePos);
	}

	public boolean mousePressed() {
		return input.userPressedButton();
	}

	public void doShot(float x, float y) {
		particlesystems.add(new ParticleSystem(x, y));
		core.playGunShot();
	}
}