package view;



public class Camera {

	private float boardWith;
	private float boardHeight;
	private float scale;
	private int borderSize = 5;

	
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