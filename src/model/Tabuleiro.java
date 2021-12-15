package model;

import view.JChecker;

public class Tabuleiro {
	
	private Peca[][] pecas;
	private Peca pecaSelecionada = null;
	private EnumCor vez = EnumCor.BRANCO;
	
	//M�todo para criar o tabuleiro
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
	
	//M�todo para falar em que posi��o do tabuleiro a pe�a est�
	public Peca getPeca(int linha, int coluna) {
		return this.pecas[linha][coluna];
	}
	
	public void setPeca(Peca peca) {
		this.pecas[peca.getLinha()][peca.getColuna()] = peca;
		peca.setTabuleiro(this);
	}
	
	//M�todo para popular o tabuleiro com pe�as
	public void adicionaPeca(Peca peca) {
		this.pecas[peca.getLinha()][peca.getColuna()] = peca;
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
		if (this.pecaSelecionada == null) {                           //In�cio de click na pedra selecionada
			if (peca != null && peca.getCor().equals(this.vez)) {
				this.selecionaPeca(peca);
			}
		} else {
			if (this.pecaSelecionada == peca) {
				this.selecionaPeca(peca);
			} else {
				if (peca == null || !peca.getCor().equals(this.pecaSelecionada.getCor())) {
					this.movePeca(this.pecaSelecionada, linha, coluna); //verificar se est� movendo
				}
			}
		}
	}

}
