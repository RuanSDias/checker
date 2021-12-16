package model;

import view.JChecker;

public class Board {
	
	private Piece[][] pieces;
	private Piece selectedPiece = null;
	private EnumColor turn = EnumColor.WHITE;
	
	//Método para criar o tabuleiro
	public Board() {
		this.pieces = new Piece [8][8]; 

		for (int i=0; i<8; i+=2) {
			Stone blackStone = new Stone(EnumColor.BLACK, 7,i);
			this.pieceAdd(blackStone);
		}
		for (int i=1; i<8; i+=2) {
			Stone blackStone = new Stone(EnumColor.BLACK, 6,i);
			this.pieceAdd(blackStone);
		}
		for (int i=0; i<8; i+=2) {
			Stone blackStone = new Stone(EnumColor.BLACK, 5,i);
			this.pieceAdd(blackStone);
		}
		
		for (int i=1; i<8; i+=2) {
			Stone whiteStone = new Stone(EnumColor.WHITE, 0,i);
			this.pieceAdd(whiteStone);
		}
		for (int i=0; i<8; i+=2) {
			Stone whiteStone = new Stone(EnumColor.WHITE, 1,i);
			this.pieceAdd(whiteStone);
		}
		for (int i=1; i<8; i+=2) {
			Stone whiteStone = new Stone(EnumColor.WHITE, 2,i);
			this.pieceAdd(whiteStone);
		}
		
	}
	
	//Método para falar em que posição do tabuleiro a peça está
	public Piece getPiece(int line, int column) {
		return this.pieces[line][column];
	}
	
	public void setPiece(Piece piece) {
		this.pieces[piece.getLine()][piece.getColumn()] = piece;
		piece.setBoard(this);
	}
	
	//Método para popular o tabuleiro com peças
	public void pieceAdd(Piece piece) {
		this.pieces[piece.getLine()][piece.getColumn()] = piece;
		piece.setBoard(this);
	}
	
	//Método para selecionar determinada peça
	public void pieceSelect(Piece piece) {
		if (piece.isSelected()) {         //DESMARCA caso a peça já esteja selecionada
			piece.setSelected(false);
			this.selectedPiece = null;
		} else {
			piece.setSelected(true);     //MARCA caso a peça ainda não esteja selecionada
			this.selectedPiece = piece;
		}
	}
	
	public void movePiece(Piece piece, int newLine, int newColumn) {
		if (piece.movementValidation(newLine, newColumn, piece)) {
			this.pieces[piece.getLine()][piece.getColumn()] = null;
			piece.setLine(newLine);
			piece.setColumn(newColumn);
			this.setPiece(piece);
			this.pieceSelect(piece);
			this.reverseTurn();
		}
	}
	
	/*public void take(Piece piece, int newLine, int newColumn) {
		if (piece.movementValidation(newLine, newColumn, piece)) {
			this.pieces[piece.getLine()][piece.getColumn()] = null;
			piece.setLine(newLine+1);
			piece.setColumn(newColumn+1);
			this.setPiece(piece);
			this.pieceSelect(piece);
			this.reverseTurn();
		}
	}*/
	
	public void reverseTurn() {
		if (this.turn.equals(EnumColor.WHITE)) {
			this.turn = EnumColor.BLACK;
		} else {
			this.turn = EnumColor.WHITE;
		}
		JChecker.setTurn(this.turn);
	}

	public void performPlay(int line, int column) {
		Piece piece = this.getPiece(line, column);
		if (this.selectedPiece == null) {                           //Início de click na pedra selecionada
			if (piece != null && piece.getColor().equals(this.turn)) {
				this.pieceSelect(piece);
			}
		} else {
			if (this.selectedPiece == piece) {
				this.pieceSelect(piece);
			} else {
				if (piece == null) {
					this.movePiece(this.selectedPiece, line, column); //verificar se está movendo
				} /*else {
					this.comer(this.selectedPiece, line, column);
				}*/
			}
		}
	}

}
