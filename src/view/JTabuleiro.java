package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import model.Peca;
import model.Tabuleiro;

public class JTabuleiro extends JPanel {
	
	private Tabuleiro tabuleiro;

	public JTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.desenhaTabuleiro();
	}
	
	
	//Método que desenha o tabuleiro 
	public void desenhaTabuleiro() {
		this.removeAll();
		this.setLayout(new GridLayout(8,8));
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				JCelula jCelula;
				Peca peca = this.tabuleiro.getPeca(i, j);
				if (peca == null) {
					jCelula = new JCelula (i,j);
				} else {
					jCelula = new JCelula(new JPeca(peca));  //Cria a celula populada pela peça após se mover
				}
				
				if ((i+j) % 2 == 0) {
					jCelula.setBackground(Color.GRAY);
				} else {
					jCelula.setBackground(Color.BLACK);
				}
				
				this.add(jCelula);
			}
		}
		
		this.revalidate();
	}

}
