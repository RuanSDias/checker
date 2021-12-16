package model;

public abstract class Piece {
	
	private EnumColor color;
	private int line, column;
	private String image;
	private boolean eliminated = false;
	private boolean selected = false;
	private Board board;
	
	public Piece (EnumColor color, int line, int column, String image) {
		this.color = color;
		this.column = column;
		this.line = line;
		this.image = image;
	}
	
	public abstract boolean movementValidation(int destinationLine, int destinationColumn, Piece piece);
	public abstract boolean takeValidation(int destinationLine, int destinationColumn, Piece piece);

	public EnumColor getColor() {
		return color;
	}

	public void setColor(EnumColor color) {
		this.color = color;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isEliminated() {
		return eliminated;
	}

	public void setEliminated(boolean eliminated) {
		this.eliminated = eliminated;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}	

}
