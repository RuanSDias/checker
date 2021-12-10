package view;

import javax.swing.JPanel;

public class JCelula extends JPanel {
	
	private JPeca jPeca;
	private int linha, coluna;

	public JCelula(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
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
