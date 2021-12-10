package model;

public class Tabuleiro {
	
	private Peca[][] posicoes;
	private Peca pecaSelecionada = null;
	private EnumCor vez = EnumCor.BRANCO;
	
	//Método para criar o tabuleiro
	public Tabuleiro(int linhas, int colunas) {
		this.posicoes = new Peca [linhas][colunas]; 
	}
	
	//Método para falar em que posição do tabuleiro a peça está
	public Peca getPeca(int linha, int coluna) {
		return this.posicoes[linha][coluna];
	}
	
	//Método para popular o tabuleiro com peças
	public void adicionaPeca(Peca peca) {
		this.posicoes[peca.getLinha()][peca.getColuna()] = peca;
		peca.setTabuleiro(this);
	}
	
	//Método para selecionar determinada peça
	public void selecionaPeca(Peca peca) {
		if (peca.isSelecionada()) {         //DESMARCA caso a peça já esteja selecionada
			peca.setSelecionada(false);
			this.pecaSelecionada = null;
		} else {
			peca.setSelecionada(true);     //MARCA caso a peça ainda não esteja selecionada
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
