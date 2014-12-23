package controller;

import javax.media.opengl.GLAutoDrawable;

import model.BallSimulation;
import view.View;



public class Controller {

	private BallSimulation ballsimulation;
	private View view;

	
	public Controller(BallSimulation ballsimulation, View view) {
		this.ballsimulation = ballsimulation;
		this.view = view;
	}

	public void update(float timeElapsed, GLAutoDrawable drawable) {
		
		// Handling
		ballsimulation.update(timeElapsed);
		
		//Generating
		view.render(drawable);
	}

}
