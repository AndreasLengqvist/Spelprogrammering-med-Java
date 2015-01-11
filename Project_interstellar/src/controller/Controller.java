package controller;

import javax.media.opengl.GLAutoDrawable;

import model.PlayModel;
import view.IMGUI;
import view.Input;
import view.PlayView;
import view.View;



public class Controller{

	private View view;
	private IMGUI imgui;
	private Input input;
	private PlayModel playmodel;
	private PlayView playview;
	private float life;

	enum State { STOPPED, PAUSED, RUNNING, GAMEOVER };
	private State state = State.STOPPED;
	private int lightYears;
	private float scoreCounter;
	
	
	public Controller(View view) {
		this.view = view;
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
	    case GAMEOVER:
	    	showGameOver(timeElapsed, drawable);
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
		imgui.doStarBackgroundSystem(drawable, timeElapsed);
				
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
		playmodel = new PlayModel();
		playview = new PlayView(playmodel, input, view.getCore(), view.getCamera());		
	}

	
	private void playGame(float timeElapsed, GLAutoDrawable drawable) {
		life = life + timeElapsed;
		playview.startMusic();
		
		if(playmodel.gameover()){
			state = Controller.State.GAMEOVER;
		}

		// The first seconds of the game. Display count down.
		if(life > 2.0f && life < 10.0f){
			playview.doCountDown(drawable, timeElapsed);
		}
		
		// If Escape is pressed inside a game. Quit the game.
		if(imgui.quitKeyPressed()){
	        System.exit(0);
		}
		
		// If P is pressed inside a game. Pause the game.
		if(imgui.pauseKeyPressed()){
			playview.stopMusic();
			state = Controller.State.PAUSED;
		}
		
		// If A is pressed inside a game. Make rocket go left. Also checks if wing is gone.
		if(playview.leftKeyPressed()){
			if(playmodel.rocket.centerX > 0.0f){
				if(playmodel.leftWingIsGone()){
					playmodel.rocket.centerX -= 0.002f;
					playmodel.rocket.leftcenterX -= 0.002f;
					playmodel.rocket.rightcenterX -= 0.002f;
				}
				else {
					playmodel.rocket.centerX -= 0.007f;
					playmodel.rocket.leftcenterX -= 0.007f;
					playmodel.rocket.rightcenterX -= 0.007f;
				}
				playview.rocketLeft = true;
			}
		}
		
		// If D is pressed inside a game. Make rocket go right. Also checks if wing is gone.
		if(playview.rightKeyPressed()){
			if(playmodel.rocket.centerX < 1.46f){
				if(playmodel.rightWingIsGone()){
					playmodel.rocket.centerX += 0.002f;
					playmodel.rocket.leftcenterX += 0.002f;
					playmodel.rocket.rightcenterX += 0.002f;
				}
				else {
					playmodel.rocket.centerX += 0.007f;
					playmodel.rocket.leftcenterX += 0.007f;
					playmodel.rocket.rightcenterX += 0.007f;
				}
				playview.rocketRight = true;
			}
		}
		
		// If no key is pressed inside a game. Reset rocket image.
		if(!playview.leftKeyPressed() && !playview.rightKeyPressed()){
			playview.rocketLeft = false;
			playview.rocketRight = false;
		}
		
		// If repair kit is fetched. +350 score and ship repaired.
		if(playmodel.repairKitFetched()){
			lightYears += 350;
		}
		

		// Count and display the game score.
		scoreCounter = scoreCounter + timeElapsed;
		if(life > 10.0f){
			if(scoreCounter > 0.1f){
				scoreCounter = 0;
				lightYears++;
			}
		}
		
		// Next level.
		if(life > 108.0f && life < 230.0f){
			if(life > 113.2f && life < 123.0f){
				playview.showNextLevel(timeElapsed, drawable);
			}
			playmodel.levelstate = PlayModel.LevelState.LEVEL2;
			if(life > 113.2f){
				playview.starSpeed = 0.001f;
			}
		}
		
		// Into infinity.
		if(life > 227.1f){
			if(life < 240.0f){
				playview.showIntoInfinity(timeElapsed, drawable);
			}
			playmodel.levelstate = PlayModel.LevelState.LEVEL3;
			playview.starSpeed = 0.01f;
		}
		
		// Update game model and render game view.
		playmodel.update(timeElapsed, playview, life, lightYears);
		playview.render(drawable, timeElapsed);	
		playview.doLightYearScore(drawable, lightYears);
	}
	
	
	private void showGameOver(float timeElapsed, GLAutoDrawable drawable) {
		playview.stopMusic();
		playview.render(drawable, 0);	
		playview.showGameOver(drawable, timeElapsed);
		playview.doLightYearScore(drawable, lightYears);
		
		// If Restart is clicked. Restart Game.
		if(imgui.doRestartButton(drawable, timeElapsed)){
			reset();
			state = Controller.State.RUNNING;
		}
		
		// If Escape is pressed inside a game. Quit the game.
		if(imgui.quitKeyPressed()){
	        System.exit(0);
		}
	}
}
