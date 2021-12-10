package model;

public class Tabuleiro {
	
	private Peca[][] posicoes;
	private Peca pecaSelecionada = null;
	private EnumCor vez = EnumCor.BRANCO;
	
	//M�todo para criar o tabuleiro
	public Tabuleiro(int linhas, int colunas) {
		this.posicoes = new Peca [linhas][colunas]; 
	}
	
	//M�todo para falar em que posi��o do tabuleiro a pe�a est�
	public Peca getPeca(int linha, int coluna) {
		return this.posicoes[linha][coluna];
	}
	
	//M�todo para popular o tabuleiro com pe�as
	public void adicionaPeca(Peca peca) {
		this.posicoes[peca.getLinha()][peca.getColuna()] = peca;
		peca.setTabuleiro(this);
	}
	
	//M�todo para selecionar determinada pe�a
	public void selecionaPeca(Peca peca) {
		if (peca.isSelecionada()) {         //DESMARCA caso a pe�a j� esteja selecionada
			peca.setSelecionada(false);
			this.pecaSelecionada = null;
		} else {
			peca.setSelecionada(true);     //MARCA caso a pe�a ainda n�o esteja selecionada
			this.pecaSelecionada = peca;
		}
	}
	
	public void movePeca(Peca peca, int novaLinha, int novaColuna) {
		
	}
	
	public void inverteVez() {
		if (this.vez.equals(EnumCor.BRANCO)) {
			this.vez = EnumCor.PRETO;
		} else {
			this.vez = EnumCor.BRANCO;
		}
	}

}
