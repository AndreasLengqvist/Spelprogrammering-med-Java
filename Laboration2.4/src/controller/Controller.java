package controller;

import javax.media.opengl.GLAutoDrawable;

import model.Model;
import view.View;

public class Controller {

	private View view;
	private Model model;

	public Controller(Model model, View view) {
		this.view = view;
		this.model = model;
	}

	public void update(float timeElapsed, GLAutoDrawable drawable) {
		model.update(timeElapsed, view);
		view.render(drawable, timeElapsed);
	}
}
