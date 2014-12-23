package view;

public class Camera {
	
	private static int borderSize = 64;
	private int levelWidth;
	private int levelHeight;
	private int scale;
	
	
	
	public Camera(int levelWidth, int levelHeight){
		this.levelWidth = levelWidth;
		this.levelHeight = levelHeight;
	}
	
	
	void setDimensions(int width, int height){
		
		int scaleX = (width-borderSize*2) / levelWidth;
		int scaleY = (height-borderSize*2) / levelHeight;
		
		scale = scaleX;
		if (scaleY < scaleX) {
			scale = scaleY;
		}
	}
	
	
	public float getScale(){
		return scale;
	}
	
	// Takes logical coordinates and transform them into visual coordinates.
	public float toViewCoord(float  i){
		return i * scale + borderSize;

	}
	
	// Takes logical Y-coordinates and transform them into visual Y-coordinates (rotated).
	public float toViewCoordRotated(float  i){
		return (7 - i) * scale + borderSize;
	}
}
