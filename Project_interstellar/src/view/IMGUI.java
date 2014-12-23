package view;

import javax.media.opengl.GLAutoDrawable;

public class IMGUI {
	
	private Core core;
	private Input input;
	private Camera camera;
	
	
	public IMGUI(Core core, Input input, Camera camera) {
		this.core = core;
		this.input = input;
		this.camera = camera;
	}

	public void doBackground(GLAutoDrawable drawable){
		core.drawMenuBackground(drawable, 0, 0, camera.toViewCoord(1.5f), camera.toViewCoord(1.0f));			
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
	

	public boolean doQuitButton(GLAutoDrawable drawable){
		
		float mx = camera.toModel(input.getMousePosX());
		float my = camera.toModel(input.getMousePosY());
		float x = 0.9f;
		float y = 0.87f;
		float w = 0.16f;
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
	
}
