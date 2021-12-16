package model;

public class Stone extends Piece {
	
	
	public Stone (EnumColor color, int line, int column) {
		super (color, line, column, "src//imgs/"+color+".png");
	}

	/*public Stone(EnumColor color, int line, int column, String image) {
		super(color, line, column, image);
	}*/

	@Override
	public boolean movementValidation(int destinationLine, int destinationColumn, Piece piece) {
		
		/*if(destinationLine == piece.getLine()+1 && destinationColumn == piece.getColumn()+1) {
			return true;
		}*/
		
		if(piece.getLine() == destinationLine) {
			return false;
		}
		if(piece.getColumn() == destinationColumn) {
			return false;
		}
		if(piece.getColor() == EnumColor.WHITE){
			if(destinationLine < piece.getLine() || destinationLine > piece.getLine()+1) {
				return false;
			} else {
				return true;
			}
		}
		if(piece.getColor() == EnumColor.BLACK){
			if(destinationLine > piece.getLine() || destinationLine < piece.getLine()-1) {
				return false;
			} else {
				return true;
			}
		}
		
		return true;
	}

}
