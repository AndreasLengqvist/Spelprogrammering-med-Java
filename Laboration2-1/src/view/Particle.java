package view;

import javax.media.opengl.GLAutoDrawable;

public class Particle {

	float x;
	float y;
	float vy = 10;
	float vx = 10;
	float ax = 100;
	float ay = 500;
	
	Particle(float x, float y, float vx, float vy){
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}
	
	public void draw(GLAutoDrawable drawable, Core core){
		core.drawSpark(drawable, x, y, 20, 20);
	}

	public void update(float timeElapsed) {
		vx = vx + timeElapsed * ax;
		vy = vy + timeElapsed * ay;
		
		x = x + timeElapsed * vx;
		y = y + timeElapsed * vy;
		
	}
	
}
