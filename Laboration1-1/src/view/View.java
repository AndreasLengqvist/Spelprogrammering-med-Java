package view;

import javax.media.opengl.GLAutoDrawable;

import model.ChessBoard;
import model.Model;
import model.Player;



public class View {
	
	private Model model;
	private Camera camera;
	private Core core;
	
	private static boolean player2 = false;

	
	public View(Model model, int width, int height) {
		this.model = model;
		this.core = new Core();
		this.camera = new Camera(model.chessboard.width, model.chessboard.height);	
		
		camera.setDimensions(width, height);    
	}
	

	public void render(GLAutoDrawable drawable) {
		core.loadResources();
		core.clearScreen(drawable);
		
		drawChessBoard(drawable, model.chessboard);		
		drawPlayer(drawable, model.player);
	}
	
	
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		core.reshape(drawable, x, y, w, h);
		camera.setDimensions(w, h);    
	}
	
	
	private void drawChessBoard(GLAutoDrawable drawable, ChessBoard chessboard) {
		for  (int x = 0; x < chessboard.width; x++) {
			for (int y = 0; y < chessboard.height; y++)  {
				

					float vx = camera.toViewCoord(x);
					float vy = camera.toViewCoord(y);

					
					float w = camera.getScale();
					float h = camera.getScale();
					
					
					if(chessboard.squares[x][y] instanceof model.BlackSquare){
						core.drawSquare(drawable, vx, vy, w, h, 0, 0, 0);
					}
					if(chessboard.squares[x][y] instanceof model.WhiteSquare){
						core.drawSquare(drawable, vx, vy, w, h, 1, 1, 1);
					}
				}
			}
		}

	
	private void drawPlayer(GLAutoDrawable drawable, Player player) {
		
		float vy;
		float vx;

		
		if(player2){
			vx = camera.toViewCoordRotated(player.posX);
			vy = camera.toViewCoordRotated(player.posX);
		}
		else{
			vx = camera.toViewCoord(player.posX);
			vy = camera.toViewCoord(player.posX);
		}

        
		float size = player.diameter * camera.getScale();
		
		core.drawPlayer(drawable, vx, vy, size, size);
	}

}
