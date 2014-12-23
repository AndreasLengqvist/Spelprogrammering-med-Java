package view;

import javax.media.opengl.GLAutoDrawable;



public class SplitterParticle {

	float x;
	float y;
	float vy;
	float vx;
	float ax = 5;
	float ay = 20;
	
	
	SplitterParticle(float x, float y, float vx, float vy){
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}

	public void update(float timeElapsed) {
		vx = vx + timeElapsed * ax;
		vy = vy + timeElapsed * ay;
		
		x = x + timeElapsed * vx;
		y = y + timeElapsed * vy;	
	}	
	
	public void draw(GLAutoDrawable drawable, Camera camera, Core core){
		float viewX = camera.toViewCoord(x);
		float viewY = camera.toViewCoord(y);
		float viewSize = camera.toViewCoord(0.5f);
		
		core.drawSpark(drawable, viewX, viewY, viewSize, viewSize);
	}
}
