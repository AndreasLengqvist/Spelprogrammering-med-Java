package view;



public class Camera {

	private float boardWith;
	private float boardHeight;
	private float scale;
	private int borderSize = 25;

	
	public Camera(float boardWidth, float boardHeight) {
		this.boardWith = boardWidth;
		this.boardHeight = boardHeight;
	}

	
	public void setDimensions(int width, int height) {
		float scaleX = (width-borderSize*2.0f) / boardWith;
		float scaleY = (height-borderSize*2.0f) / boardHeight;
		
		scale = scaleX;
		if (scaleY < scaleX) {
			scale = scaleY;
		}		
	}
	
	
	public float toViewCoord(float i) {
		return i * scale + borderSize ;
	}
	
	
	public float toViewCoordRotated(float i) {
		return (7 - i) * scale + borderSize;
	}
	
	
	public float getScale() {
		return scale;
	}
}