package controller;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GLAutoDrawable;

import model.Model;
import view.IMGUI;
import view.Input;
import view.PlayView;
import view.View;

public class Controller {

	private View view;
	private Model model;
	private IMGUI imgui;
	private Input input;
	private PlayView playview;
	private float life;

	enum State { STOPPED, PAUSED, RUNNING };
	private State state = State.STOPPED;
	private int lightYears;
	private float scoreCounter;
	
	
	public Controller(Model model, View view) {
		this.view = view;
		this.model = model;
		this.input = view.getInput();
		this.imgui = new IMGUI(view.getCore(), input, view.getCamera());
	}

	
	public void update(float timeElapsed, GLAutoDrawable drawable) {
		view.reload(drawable);

		switch(state){
	    case STOPPED:
			doMenu(timeElapsed, drawable);
	        break;
	    case PAUSED:
			doMenu(timeElapsed, drawable);
			break;
	    case RUNNING:
	        playGame(timeElapsed, drawable);
	        break;
	}
		// Clear all key and button events.
		input.clear();
	}
	
/*
 * When in menu mode.
 */
	private void doMenu(float timeElapsed, GLAutoDrawable drawable) {
		imgui.doBackground(drawable);
				
		imgui.doInfoButton(drawable);
		
		// If in pause show Continue button.
		if(state == Controller.State.PAUSED){
			
			// If Continue is pressed. Continue game.
			if(imgui.doContinueButton(drawable)){
				state = Controller.State.RUNNING;
			}
		}
		
		// If Start Game is clicked. Start Game / Restart Game.
		if(imgui.doStartButton(drawable)){
			reset();
			state = Controller.State.RUNNING;
		}
		
		// If Quit is clicked. Exit game.
		if(imgui.doQuitButton(drawable)){
	        System.exit(0);
		}
	}

	
/* When a New game is started or a old game is restarted (Game Over / Paused -> New Game).
 * Reset both game model and game view (basically just override the old one.)
 */
	private void reset() {
		life = 0.0f;
		lightYears = 0;
		playview = new PlayView(model, input, view.getCore(), view.getCamera());		
	}

	
	private void playGame(float timeElapsed, GLAutoDrawable drawable) {
		life = life + timeElapsed;
		playview.startMusic();

		// The first seconds of the game. Display count down. Also displayed on continue.
		if(life > 2.0f && life < 20.0f){
			playview.doCountDown(drawable, timeElapsed);
		}
		
		// If Escape is pressed inside a game. Quit the game.
		if(playview.quitKeyPresed()){
	        System.exit(0);

		}
		
		// If P is pressed inside a game. Pause the game.
		if(playview.pauseKeyPresed()){
			playview.stopMusic();
			state = Controller.State.PAUSED;
		}
		
		// If A is pressed inside a game. Make rocket go left.
		if(playview.leftKeyPressed()){
			if(model.rocket.centerX > 0.0f){
				model.rocket.centerX -= 0.005f;
				playview.rocketLeft = true;
			}
		}
		
		// If D is pressed inside a game. Make rocket go right.
		if(playview.rightKeyPressed()){
			if(model.rocket.centerX < 1.5f){
				model.rocket.centerX += 0.005f;
				playview.rocketRight = true;
			}
		}
		
		// If no key is pressed inside a game. Reset rocket image.
		if(!playview.leftKeyPressed() && !playview.rightKeyPressed()){
			playview.rocketLeft = false;
			playview.rocketRight = false;
		}
		
		// Update game model and render game view.
		model.update(timeElapsed, playview);
		playview.render(drawable, timeElapsed);	

		// Count and display the game score.
		scoreCounter = scoreCounter + timeElapsed;
		if(life > 10.0f){
			if(scoreCounter > 0.1f){
				scoreCounter = 0;
				lightYears++;
			}
		}
		playview.doLightYearScore(drawable, lightYears);
	}
}
