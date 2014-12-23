package model;

public class ChessBoard {
	
	public int width = 8;
	public int height = 8;
	
	public Square squares[][];
	
	
	public ChessBoard(){
		
		squares = new Square[width][];
		for(int x = 0; x < width; x++)
		{
			squares[x] = new Square[height];
			for(int y = 0; y < width; y++){
				
				// Lazy logical for black or white.
				boolean squareType = (x % 2 == 0) == (y % 2 == 0);
				
				if(squareType){
					squares[x][y] = new WhiteSquare();
				}
				
				if(!squareType){
					squares[x][y] = new BlackSquare();
				}
			}
		}
		
	}
}
