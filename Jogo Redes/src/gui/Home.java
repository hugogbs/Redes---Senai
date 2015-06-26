package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JPanel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Home() {
		setLayout(null);
		
		JButton btnNovoJogo = new JButton("Novo Jogo");
		btnNovoJogo.setFont(new Font("Mistral", Font.PLAIN, 35));
		btnNovoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random r = new Random();
				MainGame.setTela(new GameOptions());
			}
		});
				
		JLabel lene = new JLabel(new ImageIcon(Home.class.getResource("/icones/arte.png")));
		lene.setBounds(343, 28, 250, 130);
		add(lene);
		
		btnNovoJogo.setBounds(343, 335, 233, 87);
		add(btnNovoJogo);
		
		JButton btnInstrues = new JButton("Instru\u00E7\u00F5es");
		btnInstrues.setFont(new Font("Mistral", Font.PLAIN, 35));
		btnInstrues.setBounds(85, 192, 233, 87);
		add(btnInstrues);
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.setFont(new Font("Mistral", Font.PLAIN, 35));
		btnSobre.setBounds(601, 482, 233, 87);
		add(btnSobre);
		
		JButton btnPontuao = new JButton("Pontua\u00E7\u00E3o");
		btnPontuao.setFont(new Font("Mistral", Font.PLAIN, 35));
		btnPontuao.setBounds(601, 192, 233, 87);
		add(btnPontuao);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGame.setTela(new Login());
			}
		});
		btnSair.setFont(new Font("Mistral", Font.PLAIN, 35));
		btnSair.setBounds(85, 482, 233, 87);
		add(btnSair);
		
		JLabel fundo = new JLabel(new ImageIcon(MainGame.class.getResource("/icones/home.jpg")));
		fundo.setBounds(0, 0, 930, 630);
		add(fundo);
		

	}
}
