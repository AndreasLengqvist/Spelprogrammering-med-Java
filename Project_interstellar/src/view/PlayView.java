package view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.media.opengl.GLAutoDrawable;
import model.IRocketObserver;
import model.Model;

public class PlayView implements IRocketObserver{

	private Model model;
	private Input input;
	private Camera camera;
	private Core core;
	private Sound music;

	private AliveParticleSystem aliveparticlesystem1;

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
	
	private static float  minFade = 1.0f;
	private static float  maxFade = 0.0f;
	

	public PlayView(Model model, Input input, Core core, Camera camera) {
		this.model = model;
		this.input = input;
		this.core = core;
		this.camera = camera;
		music = new Sound(new File("montana.wav"), 0);
		aliveparticlesystem1 = new AliveParticleSystem(0.75f, 1.0f);
	}
	
	
	@Override
	public void doExplode(float centerX, float centerY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doAlive(float centerX, float centerY) {
			this.centerX = centerX;
			this.centerY = centerY;
	}
	
	public void render(GLAutoDrawable drawable, float timeElapsed) {
		life = life + timeElapsed;
		
		if(aliveparticlesystem1 != null){
			aliveparticlesystem1.setStartPos(centerX, centerY);
			aliveparticlesystem1.render(drawable, core, timeElapsed, camera, life);	
		}
		drawRocket(drawable, model);
	}
	
	private void drawRocket(GLAutoDrawable drawable, Model model) {
		float color[] = new float[4];
		color[0] = color[1] = color[2] = 1;
		color[3] = 1.0f;
		
		float vx = camera.toViewCoord(model.rocket.centerX);
	    float vy = camera.toViewCoord(model.rocket.centerY);
		float vRocketSize = ((model.rocket.radius * 2.0f) * camera.getScale());
		
		if(rocketLeft){
			core.drawRocketLeft(drawable, vx - vRocketSize / 2.0f, vy - vRocketSize / 2.0f, vRocketSize, vRocketSize*1.3f, color);
		}
		else if(rocketRight){
			core.drawRocketRight(drawable, vx - vRocketSize / 2.0f, vy - vRocketSize / 2.0f, vRocketSize, vRocketSize*1.3f, color);
		}
		else {
			core.drawRocket(drawable, vx - vRocketSize / 2.0f, vy - vRocketSize / 2.0f, vRocketSize, vRocketSize*1.3f, color);
		}
	}	
	
	public boolean leftKeyPressed() {
		if(input.keyPressed == 65){
			return true;
		}
		return false;
	}

	public boolean rightKeyPressed() {
		if(input.keyPressed == 68){
			return true;
		}
		return false;
	}

	public boolean quitKeyPresed() {
		if(input.keyPressed == 27){
			return true;
		}
		return false;
	}
	
	public boolean pauseKeyPresed() {
		if(input.keyPressed == 80){
			return true;
		}
		return false;
	}
	
	public void startMusic() {
		music.start();
	}

	public void stopMusic() {
		music.stop();
	}

/*
 * Display the dynamic score of the game in lightyears.
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
	    float w = 0.05f;
	    float h = 0.05f;
    	float y = 1.0f;
    	
	    // Singular.
	    if(size == 1){
	    	doScore(drawable, score, w, h, y, 1.40f, 0);
	    }

	    // Ten.
	    if(size == 2){
	    	doScore(drawable, score, w, h, y, 1.40f, 0);
	    	doScore(drawable, score, w, h, y, 1.35f, 1);
	    }
	    
	    // Hundred.
	    if(size == 3){
	    	doScore(drawable, score, w, h, y, 1.40f, 0);
	    	doScore(drawable, score, w, h, y, 1.35f, 1);
	    	doScore(drawable, score, w, h, y, 1.30f, 2);
	    }
	    
	    // Thousands.
	    if(size == 4){
	    	doScore(drawable, score, w, h, y, 1.40f, 0);
	    	doScore(drawable, score, w, h, y, 1.35f, 1);
	    	doScore(drawable, score, w, h, y, 1.30f, 2);
	    	doScore(drawable, score, w, h, y, 1.25f, 3);
	    }
	    
	    // Tens of thousands.
	    if(size == 5){
	    	doScore(drawable, score, w, h, y, 1.40f, 0);
	    	doScore(drawable, score, w, h, y, 1.35f, 1);
	    	doScore(drawable, score, w, h, y, 1.30f, 2);
	    	doScore(drawable, score, w, h, y, 1.25f, 3);
	    	doScore(drawable, score, w, h, y, 1.20f, 4);
	    }	
	    
	    // Hundreds of thousands.
	    if(size == 6){
	    	doScore(drawable, score, w, h, y, 1.40f, 0);
	    	doScore(drawable, score, w, h, y, 1.35f, 1);
	    	doScore(drawable, score, w, h, y, 1.30f, 2);
	    	doScore(drawable, score, w, h, y, 1.25f, 3);
	    	doScore(drawable, score, w, h, y, 1.20f, 4);
	    	doScore(drawable, score, w, h, y, 1.15f, 5);
	    }	
	    
	    // Millions.
	    if(size == 7){
	    	doScore(drawable, score, w, h, y, 1.40f, 0);
	    	doScore(drawable, score, w, h, y, 1.35f, 1);
	    	doScore(drawable, score, w, h, y, 1.30f, 2);
	    	doScore(drawable, score, w, h, y, 1.25f, 3);
	    	doScore(drawable, score, w, h, y, 1.20f, 4);
	    	doScore(drawable, score, w, h, y, 1.15f, 5);
	    	doScore(drawable, score, w, h, y, 1.10f, 6);
	    }	
    }

/*
 * Lazy method for displaying score. Basically draws a texture number between 0-9.
 */
	private void doScore(GLAutoDrawable drawable, List<Integer> score, float w, float h, float y, float x, int pos) {
		Integer scoreValue = score.get(pos);
    	
		if(scoreValue == 0){
			core.drawCountDown0(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f);
		}
		if(scoreValue == 1){
			core.drawCountDown1(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f);
		}
		if(scoreValue == 2){
			core.drawCountDown2(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f);
		}
		if(scoreValue == 3){
			core.drawCountDown3(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f);
		}
		if(scoreValue == 4){
			core.drawCountDown4(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f);
		}
		if(scoreValue == 5){
			core.drawCountDown5(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f);
		}
		if(scoreValue == 6){
			core.drawCountDown6(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f);
		}
		if(scoreValue == 7){
			core.drawCountDown7(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f);
		}
		if(scoreValue == 8){
			core.drawCountDown8(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f);
		}
		if(scoreValue == 9){
			core.drawCountDown9(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f);
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
			float lifePercent = lifeCountDown3 / 1.9f;
			float fade = maxFade + lifePercent * minFade;
			core.drawCountDown3(drawable, camera.toViewCoord(0.65f), camera.toViewCoord(0.2f), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f - fade);
		}
		if(countDownTime > 2.0f && countDownTime < 4.0f){
			lifeCountDown2 += timeElapsed;
			float lifePercent = lifeCountDown2 / 2.0f;
			float fade = maxFade + lifePercent * minFade;
			core.drawCountDown2(drawable, camera.toViewCoord(0.65f), camera.toViewCoord(0.2f), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f - fade);
		}
		if(countDownTime > 4.1f && countDownTime < 6.1f){
			lifeCountDown1 += timeElapsed;
			float lifePercent = lifeCountDown1 / 1.9f;
			float fade = maxFade + lifePercent * minFade;
			core.drawCountDown1(drawable, camera.toViewCoord(0.65f), camera.toViewCoord(0.2f), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f - fade);
		}
		if(countDownTime > 6.2f && countDownTime < 8.5f){
			lifeCountDown0 += timeElapsed;
			float lifePercent = lifeCountDown0 / 1.9f;
			float fade = maxFade + lifePercent * minFade;
			core.drawCountDown0(drawable, camera.toViewCoord(0.65f), camera.toViewCoord(0.2f), camera.toViewCoord(w), camera.toViewCoord(h), 1.0f - fade);
		}
	}
}
