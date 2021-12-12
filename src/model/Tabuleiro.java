package model;

public class Tabuleiro {
	
	private Peca[][] posicoes;
	private Peca pecaSelecionada = null;
	private EnumCor vez = EnumCor.BRANCO;
	
	//Método para criar o tabuleiro
	public Tabuleiro() {
		this.posicoes = new Peca [8][8]; 
		
		Pedra pedraBranca1 = new Pedra(EnumCor.BRANCO, 0,0);
		this.adicionaPeca(pedraBranca1);
		
		Pedra pedraPreta1 = new Pedra(EnumCor.PRETO, 7,0);
		this.adicionaPeca(pedraPreta1);
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
