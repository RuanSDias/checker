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
	
	//Construtor com informações da posição da peça
	public JCelula (JPeca jPeca) {
		this.jPeca = jPeca;  //Traz a peça em sua devida posição
		this.linha = jPeca.getPeca().getLinha();
		this.coluna = jPeca.getPeca().getColuna();
		this.add(jPeca);  //Adiciona a peça após ser chamada
		if((jPeca .getPeca() != null) && jPeca.getPeca().isSelecionada()) {
			this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));    //Cria borda caso a peça seja selecionada
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
