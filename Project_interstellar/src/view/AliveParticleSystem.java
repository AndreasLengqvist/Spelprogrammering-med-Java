package view;

import javax.media.opengl.GLAutoDrawable;



public class AliveParticleSystem {

	private SmokeSystem smokesystem;
	private StarSystem starsystem;
	
	private float centerX;
	private float centerY;
	
	private float earthY = 0.8f;
	private float marsY = -0.7f;
	private float marsX = -0.3f;
	private float jupiterY = -1.5f;
	private float jupiterX = 0.7f;
	private float saturnusY = -1.0f;
	private float saturnusX = -0.5f;
	private float uranusY = -0.7f;
	private float uranusX = -0.4f;
	private float neptunusY = -1.0f;
	private float neptunusX = 0.4f;
	private float plutoY = -0.5f;
	private float plutoX = 0.6f;
	
	public AliveParticleSystem(float x, float y){	
		smokesystem = new SmokeSystem(x, y);
		starsystem = new StarSystem();
	}
	
	public void render(GLAutoDrawable drawable, Core core, float timeElapsed, Camera camera, float life, float starSpeed) {
		starsystem.render(drawable, core, timeElapsed, camera, starSpeed);	

		if(life < 10.0f){
			drawEarth(drawable, timeElapsed, core, camera);	
		}
		if(life > 24.0f && life < 43.0f){
			drawMars(drawable, timeElapsed, core, camera);	
		}
		if(life > 24.0f && life < 43.0f){
			drawMars(drawable, timeElapsed, core, camera);	
		}
		if(life > 65.0f && life < 120.0f){
			drawJupiter(drawable, timeElapsed, core, camera);	
		}
		if(life > 115.0f && life < 140.0f){
			drawSaturnus(drawable, timeElapsed, core, camera);	
		}
		if(life > 140.0f && life < 170.0f){
			drawUranus(drawable, timeElapsed, core, camera);	
		}
		if(life > 170.0f && life < 200.0f){
			drawNeptunus(drawable, timeElapsed, core, camera);	
		}
		if(life > 195.0f && life < 230.0f){
			drawPluto(drawable, timeElapsed, core, camera);	
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

		marsY += timeElapsed*0.06f;
		float w = 0.7f;
		float h = 0.7f;
		
		core.drawMars(drawable, camera.toViewCoord(marsX), camera.toViewCoord(marsY), camera.toViewCoord(w), camera.toViewCoord(h));
	}
	
	public void drawJupiter(GLAutoDrawable drawable, float timeElapsed, Core core, Camera camera){

		jupiterY += timeElapsed*0.05f;
		float w = 1.5f;
		float h = 1.5f;
		
		core.drawJupiter(drawable, camera.toViewCoord(jupiterX), camera.toViewCoord(jupiterY), camera.toViewCoord(w), camera.toViewCoord(h));
	}
	
	public void drawSaturnus(GLAutoDrawable drawable, float timeElapsed, Core core, Camera camera){

		saturnusY += timeElapsed*0.09f;
		float w = 1.26f;
		float h = 0.95f;
		
		core.drawSaturnus(drawable, camera.toViewCoord(saturnusX), camera.toViewCoord(saturnusY), camera.toViewCoord(w), camera.toViewCoord(h));
	}
	
	public void drawUranus(GLAutoDrawable drawable, float timeElapsed, Core core, Camera camera){

		uranusY += timeElapsed*0.06f;
		float w = 0.7f;
		float h = 0.7f;
		
		core.drawUranus(drawable, camera.toViewCoord(uranusX), camera.toViewCoord(uranusY), camera.toViewCoord(w), camera.toViewCoord(h));
	}
	
	public void drawNeptunus(GLAutoDrawable drawable, float timeElapsed, Core core, Camera camera){

		neptunusY += timeElapsed*0.08f;
		float w = 0.70f;
		float h = 0.70f;
		
		core.drawNeptunus(drawable, camera.toViewCoord(neptunusX), camera.toViewCoord(neptunusY), camera.toViewCoord(w), camera.toViewCoord(h));
	}
	
	public void drawPluto(GLAutoDrawable drawable, float timeElapsed, Core core, Camera camera){

		plutoY += timeElapsed*0.05f;
		float w = 0.50f;
		float h = 0.50f;
		
		core.drawPluto(drawable, camera.toViewCoord(plutoX), camera.toViewCoord(plutoY), camera.toViewCoord(w), camera.toViewCoord(h));
	}
}