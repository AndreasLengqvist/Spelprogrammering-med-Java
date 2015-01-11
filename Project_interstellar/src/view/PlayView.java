package view;

import java.util.ArrayList;
import java.util.List;
import javax.media.opengl.GLAutoDrawable;
import model.IRocketObserver;
import model.PlayModel;



public class PlayView implements IRocketObserver{

	private PlayModel playmodel;
	private Input input;
	private Camera camera;
	private Core core;
	private Sound music;
	private float RedPosGameOverY = -0.30f;

	private AliveParticleSystem aliveparticlesystem;

	ArrayList<Integer> yearList = new ArrayList<>();

	private float centerX;
	private float centerY;
	public boolean rocketLeft;
	public boolean rocketRight;

	private float life;
	private float countDownTime;
	private float lifeCountDown3;
	private float lifeCountDown2;
	private float lifeCountDown1;
	private float lifeCountDown0;
	private float lifeGameOver;
	private float lifeNextLevel;
	private float lifeInfinityLevel;

	private boolean destroyLeftWingOnce = true;
	private boolean destroyRightWingOnce = true;
	private boolean destroyRocketOnce = true;
	private boolean leftWingOn = true;
	private boolean rightWingOn = true;
	private boolean sendOutRepairKit = false;
	public float starSpeed = 0.0005f;
 
	private static float  minFade = 1.0f;
	private static float  maxFade = 0.0f;
	

	public PlayView(PlayModel playmodel, Input input, Core core, Camera camera) {
		this.playmodel = playmodel;
		this.input = input;
		this.core = core;
		this.camera = camera;
		music = new Sound();
		aliveparticlesystem = new AliveParticleSystem(0.75f, 1.0f);
	}
	
	public void render(GLAutoDrawable drawable, float timeElapsed) {
		life = life + timeElapsed;
		
		if(aliveparticlesystem != null){
			aliveparticlesystem.setStartPos(centerX, centerY);
			aliveparticlesystem.render(drawable, core, timeElapsed, camera, life, starSpeed);
		}
		
		drawRocket(drawable, playmodel);
		
		if(sendOutRepairKit){
			drawRepairKit(drawable, playmodel);		
		}
		
		if(aliveparticlesystem != null){
			drawMeteorSystem(drawable, playmodel);		
		}
	}
	
	private void drawMeteorSystem(GLAutoDrawable drawable, PlayModel model2) {
		playmodel.meteorsystem.render(drawable, core, camera);
	}
	
	private void drawRepairKit(GLAutoDrawable drawable, PlayModel model2) {
		playmodel.rocket.repairkit.draw(drawable, core, camera);
	}

	private void drawRocket(GLAutoDrawable drawable, PlayModel model) {
		float color[] = new float[4];
		color[0] = color[1] = color[2] = 1;
		color[3] = 1.0f;
		
		// Rocket.
		float vx = camera.toViewCoord(model.rocket.centerX);
	    float vy = camera.toViewCoord(model.rocket.centerY);
		float vw = camera.toViewCoord(model.rocket.width);
		float vh = camera.toViewCoord(model.rocket.height);

		// Left wing.
		float lvx = camera.toViewCoord(model.rocket.leftcenterX);
	    float lvy = camera.toViewCoord(model.rocket.leftcenterY);
		float lvw = camera.toViewCoord(model.rocket.leftwidth);
		float lvh = camera.toViewCoord(model.rocket.leftheight);
		
		// Right wing.
		float rvx = camera.toViewCoord(model.rocket.rightcenterX);
	    float rvy = camera.toViewCoord(model.rocket.rightcenterY);
		float rvw = camera.toViewCoord(model.rocket.rightwidth);
		float rvh = camera.toViewCoord(model.rocket.rightheight);
		
		if(leftWingOn){
			core.drawRocketLeftWing(drawable, lvx, lvy, lvw, lvh, color);
		}
		if(rightWingOn){
			core.drawRocketRightWing(drawable, rvx, rvy, rvw, rvh, color);
		}
		core.drawRocket(drawable, vx, vy, vw, vh, color);
	}	
	
	public boolean leftKeyPressed() {
		if(input.keyPressed == 65 || input.keyPressed == 37){
			return true;
		}
		return false;
	}

	public boolean rightKeyPressed() {
		if(input.keyPressed == 68 || input.keyPressed == 39){
			return true;
		}
		return false;
	}
	
	public void startMusic() {
		music.loop();
	}

	public void stopMusic() {
		music.stop();
	}

/*
 * Display the dynamic score of the game.
 */
	public void doLightYearScore(GLAutoDrawable drawable, int lightYears) {
		List<Integer> score = new ArrayList<Integer>();

		// Put each digit into the ArrayList.
	    while(lightYears > 0) {
	        score.add(lightYears % 10);
	        lightYears /= 10;
	    }	
	    
	    // Get the size of the ArrayList.
		int size = score.size();
	    float w = 0.1f;
	    float h = 0.1f;
    	float y = 0.95f;
    	
	    // Singular.
	    if(size == 1){
	    	doScore(drawable, score, w, h, y, 1.35f, 0);
	    }

	    // Ten.
	    if(size == 2){
	    	doScore(drawable, score, w, h, y, 1.35f, 0);
	    	doScore(drawable, score, w, h, y, 1.25f, 1);
	    }
	    
	    // Hundred.
	    if(size == 3){
	    	doScore(drawable, score, w, h, y, 1.35f, 0);
	    	doScore(drawable, score, w, h, y, 1.25f, 1);
	    	doScore(drawable, score, w, h, y, 1.15f, 2);
	    }
	    
	    // Thousands.
	    if(size == 4){
	    	doScore(drawable, score, w, h, y, 1.35f, 0);
	    	doScore(drawable, score, w, h, y, 1.25f, 1);
	    	doScore(drawable, score, w, h, y, 1.15f, 2);
	    	doScore(drawable, score, w, h, y, 1.05f, 3);
	    }
	    
	    // Tens of thousands.
	    if(size == 5){
	    	doScore(drawable, score, w, h, y, 1.35f, 0);
	    	doScore(drawable, score, w, h, y, 1.25f, 1);
	    	doScore(drawable, score, w, h, y, 1.15f, 2);
	    	doScore(drawable, score, w, h, y, 1.05f, 3);
	    	doScore(drawable, score, w, h, y, 0.95f, 4);
	    }	
	    
	    // Hundreds of thousands.
	    if(size == 6){
	    	doScore(drawable, score, w, h, y, 1.35f, 0);
	    	doScore(drawable, score, w, h, y, 1.25f, 1);
	    	doScore(drawable, score, w, h, y, 1.15f, 2);
	    	doScore(drawable, score, w, h, y, 1.05f, 3);
	    	doScore(drawable, score, w, h, y, 0.95f, 4);
	    	doScore(drawable, score, w, h, y, 0.85f, 5);
	    }	
	    
	    // Millions.
	    if(size == 7){
	    	doScore(drawable, score, w, h, y, 1.35f, 0);
	    	doScore(drawable, score, w, h, y, 1.25f, 1);
	    	doScore(drawable, score, w, h, y, 1.15f, 2);
	    	doScore(drawable, score, w, h, y, 1.05f, 3);
	    	doScore(drawable, score, w, h, y, 0.95f, 4);
	    	doScore(drawable, score, w, h, y, 0.85f, 5);
	    	doScore(drawable, score, w, h, y, 0.75f, 6);
	    }	
    }

/*
 * Lazy method for displaying score. Basically draws a texture number between 0-9.
 */
	private void doScore(GLAutoDrawable drawable, List<Integer> score, float w, float h, float y, float x, int pos) {
		Integer scoreValue = score.get(pos);
    	
		if(scoreValue == 0){
			core.drawCountDown0(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 0.8f);
		}
		if(scoreValue == 1){
			core.drawCountDown1(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 0.8f);
		}
		if(scoreValue == 2){
			core.drawCountDown2(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 0.8f);
		}
		if(scoreValue == 3){
			core.drawCountDown3(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 0.8f);
		}
		if(scoreValue == 4){
			core.drawCountDown4(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 0.8f);
		}
		if(scoreValue == 5){
			core.drawCountDown5(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 0.8f);
		}
		if(scoreValue == 6){
			core.drawCountDown6(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 0.8f);
		}
		if(scoreValue == 7){
			core.drawCountDown7(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 0.8f);
		}
		if(scoreValue == 8){
			core.drawCountDown8(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 0.8f);
		}
		if(scoreValue == 9){
			core.drawCountDown9(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 0.8f);
		}					
	}
	
/*
 * Counts down 3, 2, 1, 0 seconds when game starts and when game continues.
 */
	public void doCountDown(GLAutoDrawable drawable, float timeElapsed){
		countDownTime += timeElapsed;
		float w = 0.2f;
		float h = 0.3f;

		if(countDownTime < 1.7f){
			lifeCountDown3 += timeElapsed;
			float lifePercent = lifeCountDown3 / 1.5f;
			float fade = maxFade + lifePercent * minFade;
			core.drawCountDown3(drawable, camera.toViewCoord(0.65f), camera.toViewCoord(0.2f), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f - fade);
		}
		if(countDownTime > 2.0f){
			lifeCountDown2 += timeElapsed;
			float lifePercent = lifeCountDown2 / 1.5f;
			float fade = maxFade + lifePercent * minFade;
			core.drawCountDown2(drawable, camera.toViewCoord(0.65f), camera.toViewCoord(0.2f), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f - fade);
		}
		if(countDownTime > 4.2f){
			lifeCountDown1 += timeElapsed;
			float lifePercent = lifeCountDown1 / 1.5f;
			float fade = maxFade + lifePercent * minFade;
			core.drawCountDown1(drawable, camera.toViewCoord(0.65f), camera.toViewCoord(0.2f), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f - fade);
		}
		if(countDownTime > 6.5f){
			lifeCountDown0 += timeElapsed;
			float lifePercent = lifeCountDown0 / 1.5f;
			float fade = maxFade + lifePercent * minFade;
			core.drawCountDown0(drawable, camera.toViewCoord(0.65f), camera.toViewCoord(0.2f), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f - fade);
		}
	}


	public void showGameOver(GLAutoDrawable drawable, float timeElapsed) {
		lifeGameOver += timeElapsed;
		float lifePercent = lifeGameOver / 3.0f;
		float fade = maxFade + lifePercent * minFade;

		RedPosGameOverY += timeElapsed*0.02f;
		core.drawGameOverBackground(drawable, 0, 0, camera.toViewCoord(1.5f), camera.toViewCoord(1.2f), fade);			
		core.drawGameOver(drawable, camera.toViewCoord(0.25f), camera.toViewCoord(0.0f), camera.toViewCoord(1.0f), camera.toViewCoord(1.0f), fade);
		core.drawRedGameOver(drawable, camera.toViewCoord(0.0f), camera.toViewCoord(RedPosGameOverY), camera.toViewCoord(1.5f), camera.toViewCoord(1.5f), fade);
		
		if(RedPosGameOverY > -0.25f){
			RedPosGameOverY = -0.30f;
		}
	}
	
	@Override
	public void doExplode(float centerX, float centerY) {
		if(destroyRocketOnce){
			core.playRocketDestroyed();
			destroyRocketOnce = false;
		}	
	}

	@Override
	public void doAlive(float centerX, float centerY) {
			this.centerX = centerX;
			this.centerY = centerY;
	}

	@Override
	public void doDestroyLeftWing() {
		leftWingOn = false;
		if(destroyLeftWingOnce){
			core.playWingDestroyed();
			destroyLeftWingOnce = false;
		}
	}

	@Override
	public void doDestroyRightWing() {
		rightWingOn = false;
		if(destroyRightWingOnce){
			core.playWingDestroyed();
			destroyRightWingOnce = false;
		}	
	}

	@Override
	public void doSendOutRepairKit() {
		sendOutRepairKit = true;
	}

	@Override
	public void doRepairShip() {
		leftWingOn = true;
		rightWingOn = true;
		destroyRightWingOnce = true;
		destroyLeftWingOnce = true;
		core.playRepair();
	}

	public void showNextLevel(float timeElapsed, GLAutoDrawable drawable) {
		lifeNextLevel += timeElapsed;
		float lifePercent = lifeNextLevel / 3.0f;
		float fade = maxFade + lifePercent * minFade;
		core.drawNextLevel(drawable, camera.toViewCoord(0.35f), camera.toViewCoord(0.2f), camera.toViewCoord(0.8f), camera.toViewCoord(0.15f), 1.0f - fade);				
	}
	
	public void showIntoInfinity(float timeElapsed, GLAutoDrawable drawable) {
		lifeInfinityLevel += timeElapsed;
		float lifePercent = lifeInfinityLevel / 3.0f;
		float fade = maxFade + lifePercent * minFade;
		core.drawIntoInfinity(drawable, camera.toViewCoord(0.35f), camera.toViewCoord(0.2f), camera.toViewCoord(0.8f), camera.toViewCoord(0.15f), 1.0f - fade);				
	}
}
