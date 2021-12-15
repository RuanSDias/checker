package model;

public class Checker extends Piece {

	public Checker(EnumColor color, int line, int column, String image) {
		super(color, line, column, image);
	}

	@Override
	public boolean movementValidation(int destinationLine, int destinationColumn) {
		return true;
	}
	
	

}
