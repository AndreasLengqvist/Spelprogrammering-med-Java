package view;

import javax.media.opengl.GLAutoDrawable;



public class ExplosionSystem {
	
	private Explosion explosion;	
	
	
	public ExplosionSystem(float x, float y){
		explosion = new Explosion(x, y);
	}
	
	public void render(GLAutoDrawable drawable, Core core, float timeElapsed, Camera camera) {
		update(timeElapsed);
		draw(drawable, core, camera);
	}

	private void draw(GLAutoDrawable drawable, Core core, Camera camera) {
		explosion.draw(drawable, core, camera);
	}

	private void update(float timeElapsed) {
		if(explosion.isAlive()){
			explosion.update(timeElapsed);
		}
	}
}