package model;

public class Stone extends Piece {
	
	
	public Stone (EnumColor color, int line, int column) {
		super (color, line, column, "src//imgs/"+color+".png");
	}

	/*public Stone(EnumColor color, int line, int column, String image) {
		super(color, line, column, image);
	}*/

	@Override
	public boolean movementValidation(int destinationLine, int destinationColumn) {
		return true;
	}

}
