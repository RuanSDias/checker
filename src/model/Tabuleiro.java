package model;

public class Tabuleiro {
	
	private Peca[][] posicoes;
	private Peca pecaSelecionada = null;
	private EnumCor vez = EnumCor.BRANCO;
	
	//M�todo para criar o tabuleiro
	public Tabuleiro() {
		this.posicoes = new Peca [8][8]; 
		
		Pedra pedraBranca1 = new Pedra(EnumCor.BRANCO, 0,0);
		this.adicionaPeca(pedraBranca1);
		
		Pedra pedraPreta1 = new Pedra(EnumCor.PRETO, 7,0);
		this.adicionaPeca(pedraPreta1);
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
