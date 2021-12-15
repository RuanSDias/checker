package model;

import view.JChecker;

public class Tabuleiro {
	
	private Peca[][] pecas;
	private Peca pecaSelecionada = null;
	private EnumCor vez = EnumCor.BRANCO;
	
	//Método para criar o tabuleiro
	public Tabuleiro() {
		this.pecas = new Peca [8][8]; 
	

		
		for (int i=0; i<8; i+=2) {
			Pedra pedraPreta = new Pedra(EnumCor.PRETO, 7,i);
			this.adicionaPeca(pedraPreta);
		}
		for (int i=1; i<8; i+=2) {
			Pedra pedraPreta = new Pedra(EnumCor.PRETO, 6,i);
			this.adicionaPeca(pedraPreta);
		}
		for (int i=0; i<8; i+=2) {
			Pedra pedraPreta = new Pedra(EnumCor.PRETO, 5,i);
			this.adicionaPeca(pedraPreta);
		}
		
		for (int i=1; i<8; i+=2) {
			Pedra pedraBranca = new Pedra(EnumCor.BRANCO, 0,i);
			this.adicionaPeca(pedraBranca);
		}
		for (int i=0; i<8; i+=2) {
			Pedra pedraBranca = new Pedra(EnumCor.BRANCO, 1,i);
			this.adicionaPeca(pedraBranca);
		}
		for (int i=1; i<8; i+=2) {
			Pedra pedraBranca = new Pedra(EnumCor.BRANCO, 2,i);
			this.adicionaPeca(pedraBranca);
		}
		
	}
	
	//Método para falar em que posição do tabuleiro a peça está
	public Peca getPeca(int linha, int coluna) {
		return this.pecas[linha][coluna];
	}
	
	public void setPeca(Peca peca) {
		this.pecas[peca.getLinha()][peca.getColuna()] = peca;
		peca.setTabuleiro(this);
	}
	
	//Método para popular o tabuleiro com peças
	public void adicionaPeca(Peca peca) {
		this.pecas[peca.getLinha()][peca.getColuna()] = peca;
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
		if (peca.validaMovimento(novaLinha, novaColuna)) {
			this.pecas[peca.getLinha()][peca.getColuna()] = null;
			peca.setLinha(novaLinha);
			peca.setColuna(novaColuna);
			this.setPeca(peca);
			this.selecionaPeca(peca);
			this.inverteVez();
		}
	}
	
	public void inverteVez() {
		if (this.vez.equals(EnumCor.BRANCO)) {
			this.vez = EnumCor.PRETO;
		} else {
			this.vez = EnumCor.BRANCO;
		}
		JChecker.setVez(this.vez);
	}

	public void realizaJogada(int linha, int coluna) {
		Peca peca = this.getPeca(linha, coluna);
		if (this.pecaSelecionada == null) {                           //Início de click na pedra selecionada
			if (peca != null && peca.getCor().equals(this.vez)) {
				this.selecionaPeca(peca);
			}
		} else {
			if (this.pecaSelecionada == peca) {
				this.selecionaPeca(peca);
			} else {
				if (peca == null || !peca.getCor().equals(this.pecaSelecionada.getCor())) {
					this.movePeca(this.pecaSelecionada, linha, coluna); //verificar se está movendo
				}
			}
		}
	}

}
