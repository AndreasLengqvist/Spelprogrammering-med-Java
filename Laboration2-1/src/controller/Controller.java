package controller;

import javax.media.opengl.GLAutoDrawable;

import model.Model;
import view.View;

public class Controller {

	private View view;

	public Controller(Model model, View view) {
		this.view = view;
	}

	public void update(float timeElapsed, GLAutoDrawable drawable){
		view.render(drawable, timeElapsed);
	}

}
