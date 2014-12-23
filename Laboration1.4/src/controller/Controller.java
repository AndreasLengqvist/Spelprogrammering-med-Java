package controller;
import javax.media.opengl.GLAutoDrawable;

import view.View;

import model.BallSimulation;


public class Controller {

	private BallSimulation ballsimulation;
	private View view;

	public Controller(BallSimulation ballsimulation, View view) {
		this.ballsimulation = ballsimulation;
		this.view = view;
	}

	public void update(float timeElapsed, GLAutoDrawable drawable) {
		
		//Change model state
		ballsimulation.update(timeElapsed);
		
		//Generate output
		view.render(drawable);
	}

}