package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Piece;

public class JPiece extends JLabel {
	
	private Piece piece;

	public JPiece(Piece piece) {
		this.piece = piece;
		this.setIcon(new ImageIcon(piece.getImage()));
		
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	

}
