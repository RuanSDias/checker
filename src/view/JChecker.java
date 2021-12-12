package view;

import javax.swing.JFrame;

import model.Tabuleiro;

public class JChecker extends JFrame {
	
	public JChecker() {
		setTitle ("Jogo de damas");
		this.add(new JTabuleiro(new Tabuleiro()));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Encerra a aplicação quando fecha a janela
		
		this.pack();  //Atualiza a tela
		this.setVisible(true);
	}
	
	public static void main (String args[]) {
		new JChecker();
	}

}
