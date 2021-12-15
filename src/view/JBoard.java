package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import model.Board;
import model.Piece;

public class JBoard extends JPanel implements MouseListener {
	
	private Board board;

	public JBoard(Board board) {
		this.board = board;
		this.boardMaker();
	}
	
	
	//Método que desenha o tabuleiro 
	public void boardMaker() {
		this.removeAll();
		this.setLayout(new GridLayout(8,8));
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				JCell jCell;
				Piece piece = this.board.getPiece(i, j);
				if (piece == null) {
					jCell = new JCell (i,j);
				} else {
					jCell = new JCell(new JPiece(piece));  //Cria a celula populada pela peça após se mover
				}
				
				if ((i+j) % 2 == 0) {
					jCell.setBackground(Color.GRAY);
				} else {
					jCell.setBackground(Color.BLUE);
				}
				
				this.add(jCell);
				jCell.addMouseListener(this);
			}
		}
		
		this.revalidate();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		JCell jCell = (JCell) e.getSource();
		this.board.performPlay(jCell.getLine(), jCell.getColumn());
		this.boardMaker();
	}


	@Override
	public void mousePressed(MouseEvent e) {
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
