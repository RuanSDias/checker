package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Board;
import model.EnumColor;

public class JChecker extends JFrame {
	
	private static JLabel lbTurn;
	
	private Board board;
	
	private JButton btReiniciarJogo;
	private JButton btPassarVez;
	
	public JChecker() {
		setTitle ("Checker's Game");
		this.setLayout(new BorderLayout());
		this.board = new Board();
		this.add(new JBoard(board), BorderLayout.CENTER);
		
		JPanel pnTop = new JPanel();                        //Painel do topo
		lbTurn = new JLabel ("It's White's turn");
		pnTop.add(lbTurn);
		this.add(pnTop, BorderLayout.NORTH);
		
		JPanel pnSide = new JPanel();					//Painel lateral (Retirar talvez)
		pnSide.setLayout(new GridLayout(10,1));
		btReiniciarJogo = new JButton("Reiniciar jogo");
		btPassarVez = new JButton ("Passar vez");
		pnSide.add(btReiniciarJogo);
		pnSide.add(btPassarVez);
		this.add(pnSide, BorderLayout.WEST);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Encerra a aplicação quando fecha a janela
		
		this.pack();  //Atualiza a tela
		this.setVisible(true);
	}
	
	public static void setTurn(EnumColor turnColor) {
		lbTurn.setText("It's "+turnColor+"'s turn");
	}
	
	public static void main (String args[]) {
		new JChecker();
	}

}
