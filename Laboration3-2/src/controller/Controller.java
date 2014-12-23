package controller;

import javax.media.opengl.GLAutoDrawable;
import model.BallSimulation;
import view.View;

public class Controller {

	private View view;
	private BallSimulation ballsimulation;

	
	public Controller(BallSimulation ballsimulation, View view) {
		this.view = view;
		this.ballsimulation = ballsimulation;
	}

	public void update(float timeElapsed, GLAutoDrawable drawable) {
		
		
		// Input.
		
		// If mouse is pressed down shoot.
		if(view.mousePressed()){
			float x = view.getMouseXPos(); 
			float y = view.getMouseYPos();
			ballsimulation.didBallDie(x, y);
			view.doShot(x, y);
		}
		
		ballsimulation.update(timeElapsed);

		// Output.
		view.render(drawable, timeElapsed);

	}
}
