package model;

public class Checker extends Piece {
	
	public Checker (EnumColor color, int line, int column) {
		super (color, line, column, "src//imgs/"+color+"CHECKER.png");
	}


	public Checker(EnumColor color, int line, int column, String image) {
		super(color, line, column, image);
	}

	@Override
	public boolean movementValidation(int destinationLine, int destinationColumn, Piece piece) {
		return true;
	}


	@Override
	public boolean takeValidation(int destinationLine, int destinationColumn, Piece piece) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
