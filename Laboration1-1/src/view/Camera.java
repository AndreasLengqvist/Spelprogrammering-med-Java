package view;



public class Camera {

	private int boardWith;
	private int boardHeight;
	private int scale;
	private int borderSize = 64;

	
	public Camera(int boardWidth, int boardHeight) {
		this.boardWith = boardWidth;
		this.boardHeight = boardHeight;
	}

	
	public void setDimensions(int width, int height) {
		int scaleX = (width-borderSize*2) / boardWith;
		int scaleY = (height-borderSize*2) / boardHeight;
		
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
