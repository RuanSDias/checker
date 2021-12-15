package model;

public class Pedra extends Peca {
	
	
	public Pedra (EnumCor cor, int linha, int coluna) {
		super (cor, linha, coluna, "C:/"+cor+".png");
	}

	public Pedra(EnumCor cor, int linha, int coluna, String imagem) {
		super(cor, linha, coluna, imagem);
	}

	@Override
	public boolean validaMovimento(int linhaDestino, int colunaDestino) {
		return true;
	}

}
