package view;

import javax.media.opengl.GLAutoDrawable;



public class AliveParticleSystem {

	private SmokeSystem smokesystem;
	private StarSystem starsystem;
	
	private float centerX;
	private float centerY;
	
	private float earthY = 0.8f;
	private float marsY = -0.5f;
	private float jupiterY = -1.0f;
	private float jupiterX = 1.1f;

	private float saturnusY = -0.5f;
	private float marsX = -0.2f;
	
	
	public AliveParticleSystem(float x, float y){	
		smokesystem = new SmokeSystem(x, y);
		starsystem = new StarSystem();
	}
	
	public void render(GLAutoDrawable drawable, Core core, float timeElapsed, Camera camera, float life) {
		starsystem.render(drawable, core, timeElapsed, camera);	
		System.out.println(life);

		if(life < 10.0f){
			drawEarth(drawable, timeElapsed, core, camera);	
		}
		
		if(life > 24.0f && life < 43.0f){
			drawMars(drawable, timeElapsed, core, camera);	
		}
		if(life > 65.0f && life < 95.0f){
			drawJupiter(drawable, timeElapsed, core, camera);	
		}
		if(life > 100.0f && life < 120.0f){
			drawSaturnus(drawable, timeElapsed, core, camera);	
		}
		smokesystem.render(drawable, core, timeElapsed, camera, centerX, centerY);	
	}

	public void setStartPos(float centerX, float centerY) {
		this.centerX = centerX;
		this.centerY = centerY;
	}
	
	public void drawEarth(GLAutoDrawable drawable, float timeElapsed, Core core, Camera camera){

		earthY += timeElapsed*0.03f;
		float w = 1.5f;
		float h = 0.3f;
		
		core.drawEarth(drawable, camera.toViewCoord(0.0f), camera.toViewCoord(earthY), camera.toViewCoord(w), camera.toViewCoord(h));
	}
	
	public void drawMars(GLAutoDrawable drawable, float timeElapsed, Core core, Camera camera){

		marsY += timeElapsed*0.1f;
		float w = 0.5f;
		float h = 0.5f;
		
		core.drawMars(drawable, camera.toViewCoord(marsX), camera.toViewCoord(marsY), camera.toViewCoord(w), camera.toViewCoord(h));
	}
	
	public void drawJupiter(GLAutoDrawable drawable, float timeElapsed, Core core, Camera camera){

		jupiterY += timeElapsed*0.07f;
		float w = 0.9f;
		float h = 0.9f;
		
		core.drawJupiter(drawable, camera.toViewCoord(jupiterX), camera.toViewCoord(jupiterY), camera.toViewCoord(w), camera.toViewCoord(h));
	}
	
	public void drawSaturnus(GLAutoDrawable drawable, float timeElapsed, Core core, Camera camera){

		saturnusY += timeElapsed*0.1f;
		float w = 0.5f;
		float h = 0.5f;
		
		core.drawMars(drawable, camera.toViewCoord(marsX), camera.toViewCoord(saturnusY), camera.toViewCoord(w), camera.toViewCoord(h));
	}
	
	
}