package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class JCell extends JPanel {
	
	private JPiece jPiece;
	private int line, column;

	public JCell(int line, int column) {
		this.line = line;
		this.column = column;
	}
	
	//Construtor com informa��es da posi��o da pe�a
	public JCell (JPiece jPiece) {
		this.jPiece = jPiece;  //Traz a pe�a em sua devida posi��o
		this.line = jPiece.getPiece().getLine();
		this.column = jPiece.getPiece().getColumn();
		this.add(jPiece);  //Adiciona a pe�a ap�s ser chamada
		if((jPiece .getPiece() != null) && jPiece.getPiece().isSelected()) {
			this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));    //Cria borda caso a pe�a seja selecionada
		}
	}

	public JPiece getjPiece() {
		return jPiece;
	}

	public void setjPiece(JPiece jPiece) {
		this.jPiece = jPiece;
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
	
	
	
}
