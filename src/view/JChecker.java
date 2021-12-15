package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.EnumCor;
import model.Tabuleiro;

public class JChecker extends JFrame {
	
	private static JLabel lbVez;
	
	private Tabuleiro tabuleiro;
	
	private JButton btReiniciarJogo;
	private JButton btPassarVez;
	
	public JChecker() {
		setTitle ("Jogo de damas");
		this.setLayout(new BorderLayout());
		this.tabuleiro = new Tabuleiro();
		this.add(new JTabuleiro(tabuleiro), BorderLayout.CENTER);
		
		JPanel pnTopo = new JPanel();                        //Painel do topo
		lbVez = new JLabel ("Vez da pedra: BRANCA");
		pnTopo.add(lbVez);
		this.add(pnTopo, BorderLayout.NORTH);
		
		JPanel pnLateral = new JPanel();
		pnLateral.setLayout(new GridLayout(10,1));
		btReiniciarJogo = new JButton("Reiniciar jogo");
		btPassarVez = new JButton ("Passar vez");
		pnLateral.add(btReiniciarJogo);
		pnLateral.add(btPassarVez);
		this.add(pnLateral, BorderLayout.WEST);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Encerra a aplicação quando fecha a janela
		
		this.pack();  //Atualiza a tela
		this.setVisible(true);
	}
	
	public static void setVez(EnumCor corVez) {
		lbVez.setText("Vez da pedra: "+corVez);
	}
	
	public static void main (String args[]) {
		new JChecker();
	}

}
