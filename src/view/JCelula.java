package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class JCelula extends JPanel {
	
	private JPeca jPeca;
	private int linha, coluna;

	public JCelula(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	//Construtor com informa��es da posi��o da pe�a
	public JCelula (JPeca jPeca) {
		this.jPeca = jPeca;  //Traz a pe�a em sua devida posi��o
		this.linha = jPeca.getPeca().getLinha();
		this.coluna = jPeca.getPeca().getColuna();
		this.add(jPeca);  //Adiciona a pe�a ap�s ser chamada
		if((jPeca .getPeca() != null) && jPeca.getPeca().isSelecionada()) {
			this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));    //Cria borda caso a pe�a seja selecionada
		}
	}

	public JPeca getjPeca() {
		return jPeca;
	}

	public void setjPeca(JPeca jPeca) {
		this.jPeca = jPeca;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	
	
	
}
