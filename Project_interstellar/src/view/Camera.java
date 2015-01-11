package view;


/*
 *  Handles the dimensions and other scaleable things.
 */
public class Camera {

	private float boardWith;
	private float boardHeight;
	private float scale;

	
	public Camera(float boardWidth, float boardHeight) {
		this.boardWith = boardWidth;
		this.boardHeight = boardHeight;
	}
	
	public void setDimensions(int width, int height) {
		float scaleX = width / boardWith;
		float scaleY = height / boardHeight;
		
		scale = scaleX;
		if (scaleY < scaleX) {
			scale = scaleY;
		}		
	}
	
	public float toViewCoord(float i) {
		return i * scale;
	}
	
	public float getScale() {
		return scale;
	}
	
	public float toModel(float viewPos) {
		return viewPos / scale;
	}
}