package view;

import javax.swing.JLabel;

import model.Peca;

public class JPeca extends JLabel {
	
	private Peca peca;

	public JPeca(Peca peca) {
		this.peca = peca;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	
	

}
