package view;

import javax.media.opengl.GLAutoDrawable;



public class Explosion {
	
	private float life;
	private float maxLife;
	private float framePercent;
	private int frame;
	
	private float x;
	private float y;
	private float size;

	
	public Explosion(float x, float y){
		
		// Set starting position.
		this.x = x;
		this.y = y;
		
		// Set max life.
		this.maxLife = 0.3f;

		// Set the life.
		this.life = 0.0f;
		
		// Set size.
		this.size = 10.0f;
	}
	
	public void update(float timeElapsed){
		life = life + timeElapsed;
				
		framePercent = life / maxLife;
		frame = (int)(framePercent * 24);
	}

	public void draw(GLAutoDrawable drawable, Core core, Camera camera) {
		float viewX = camera.toViewCoord(x-6);
		float viewY = camera.toViewCoord(y-5);
		float viewSize = camera.toViewCoord(size);
		core.drawExplosion(drawable, viewX, viewY, viewSize, viewSize, frame);		
	}

	public boolean isAlive() {
		return life < (maxLife+0.3f);
	}
}