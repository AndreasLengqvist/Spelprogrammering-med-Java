package view;

import javax.media.opengl.GLAutoDrawable;


/*
 *  Menu and button class.
 */
public class IMGUI {
	
	private Core core;
	private Input input;
	private Camera camera;
	private StarSystem starsystem;
	
	private float lifeRestartButton;

	private static float  minFade = 1.0f;
	private static float  maxFade = 0.0f;
	
	public IMGUI(Core core, Input input, Camera camera) {
		this.core = core;
		this.input = input;
		this.camera = camera;
		starsystem = new StarSystem();
	}
	
	public boolean quitKeyPressed() {
		if(input.keyPressed == 27){
			return true;
		}
		return false;
	}
	
	public boolean pauseKeyPressed() {
		if(input.keyPressed == 80){
			return true;
		}
		return false;
	}
	

	public void doBackground(GLAutoDrawable drawable){
		core.drawMenuBackground(drawable, 0, 0, camera.toViewCoord(1.5f), camera.toViewCoord(1.2f));			
	}

	public boolean doStartButton(GLAutoDrawable drawable){
		
		float mx = camera.toModel(input.getMousePosX());
		float my = camera.toModel(input.getMousePosY());
		float x = 0.9f;
		float y = 0.8f;
		float w = 0.3f;
		float h = 0.04f;
		boolean mouseOver = false;
		
		if(mx > x && mx < x+w){
			if(my > y && my < y+h){
				mouseOver = true;
			}
		} else {
			mouseOver = false;
		}
		
		if(mouseOver){
			core.drawStartButtonHover(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h));			
		} else {
			core.drawStartButton(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h));			
		}
		
		if(mouseOver && input.userReleasesButton()){
			return true;
		}
		return false;
	}
	

	public boolean doRestartButton(GLAutoDrawable drawable, float timeElapsed){
		
		float mx = camera.toModel(input.getMousePosX());
		float my = camera.toModel(input.getMousePosY());
		float x = 0.6f;
		float y = 0.6f;
		float w = 0.4f;
		float h = 0.06f;
		boolean mouseOver = false;
		
		lifeRestartButton += timeElapsed;
		float lifePercent = lifeRestartButton / 5.0f;
		float fade = maxFade + lifePercent * minFade;
		
		if(mx > x && mx < x+w){
			if(my > y && my < y+h){
				mouseOver = true;
			}
		} else {
			mouseOver = false;
		}
		
		if(mouseOver){
			core.drawReStartButtonHover(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), fade);			
		} else {
			core.drawReStartButton(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h), fade);			
		}
		
		if(mouseOver && input.userReleasesButton()){
			return true;
		}
		return false;
	}
	

	public boolean doQuitButton(GLAutoDrawable drawable){
		
		float mx = camera.toModel(input.getMousePosX());
		float my = camera.toModel(input.getMousePosY());
		float x = 0.9f;
		float y = 0.85f;
		float w = 0.15f;
		float h = 0.04f;
		boolean mouseOver = false;
		
		if(mx > x && mx < x+w){
			if(my > y && my < y+h){
				mouseOver = true;
			}
		} else {
			mouseOver = false;
		}
		
		if(mouseOver){
			core.drawQuitButtonHover(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h));			
		} else {
			core.drawQuitButton(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h));			
		}
		
		if(mouseOver && input.userReleasesButton()){
			return true;
		}
		return false;
	}
	
	public boolean doContinueButton(GLAutoDrawable drawable){
		
		float mx = camera.toModel(input.getMousePosX());
		float my = camera.toModel(input.getMousePosY());
		float x = 0.9f;
		float y = 0.73f;
		float w = 0.4f;
		float h = 0.06f;
		boolean mouseOver = false;
		
		if(mx > x && mx < x+w){
			if(my > y && my < y+h){
				mouseOver = true;
			}
		} else {
			mouseOver = false;
		}
		
		if(mouseOver){
			core.drawContinueButtonHover(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h));			
		} else {
			core.drawContinueButton(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h));			
		}
		
		if(mouseOver && input.userReleasesButton()){
			return true;
		}
		return false;
	}

	public void doInfoButton(GLAutoDrawable drawable) {
		float mx = camera.toModel(input.getMousePosX());
		float my = camera.toModel(input.getMousePosY());
		float x = 0.05f;
		float y = 0.05f;
		float w = 0.05f;
		float h = 0.05f;
		boolean mouseOver = false;

		if(mx > x && mx < x+w){
			if(my > y && my < y+h){
				mouseOver = true;
			}
		} else {
			mouseOver = false;
		}
		if(mouseOver){
			w = 0.4f;
			h = 0.15f;
			core.drawGameInfo(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h));			
		} else {
			core.drawInfoButton(drawable, camera.toViewCoord(x), camera.toViewCoord(y), camera.toViewCoord(w), camera.toViewCoord(h));			
		}
	}
	
	public void doStarBackgroundSystem(GLAutoDrawable drawable, float timeElapsed){
		starsystem.render(drawable, core, timeElapsed, camera, 0.00005f);
	}
	
}
