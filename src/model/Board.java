package model;

import view.JChecker;

public class Board {
	
	private Piece[][] pieces;
	private Piece selectedPiece = null;
	private EnumColor turn = EnumColor.WHITE;
	
	//M�todo para criar o tabuleiro
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
	
	//M�todo para falar em que posi��o do tabuleiro a pe�a est�
	public Piece getPiece(int line, int column) {
		return this.pieces[line][column];
	}
	
	public void setPiece(Piece piece) {
		this.pieces[piece.getLine()][piece.getColumn()] = piece;
		piece.setBoard(this);
	}
	
	//M�todo para popular o tabuleiro com pe�as
	public void pieceAdd(Piece piece) {
		this.pieces[piece.getLine()][piece.getColumn()] = piece;
		piece.setBoard(this);
	}
	
	//M�todo para selecionar determinada pe�a
	public void pieceSelect(Piece piece) {
		if (piece.isSelected()) {         //DESMARCA caso a pe�a j� esteja selecionada
			piece.setSelected(false);
			this.selectedPiece = null;
		} else {
			piece.setSelected(true);     //MARCA caso a pe�a ainda n�o esteja selecionada
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
		if (this.selectedPiece == null) {                           //In�cio de click na pedra selecionada
			if (piece != null && piece.getColor().equals(this.turn)) {
				this.pieceSelect(piece);
			}
		} else {
			if (this.selectedPiece == piece) {
				this.pieceSelect(piece);
			} else {
				if (piece == null  /*!piece.getColor().equals(this.selectedPiece.getColor())*/) {
					this.movePiece(this.selectedPiece, line, column); //verificar se est� movendo
				}
			}
		}
	}

}
