package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

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
		
		JButton btnNovoJogo = new JButton("Novo Jogo");
		btnNovoJogo.setBounds(343, 170, 233, 87);
		btnNovoJogo.setFont(new Font("Mistral", Font.PLAIN, 35));
		btnNovoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGame.setTela(new GameOptions());
			}
		});
		setLayout(null);
				
		JLabel lene = new JLabel(new ImageIcon(Home.class.getResource("/icones/arte.png")));
		lene.setBounds(343, 28, 250, 130);
		add(lene);
		add(btnNovoJogo);
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGame.setTela(new Sobre());
			}
		});
		btnSobre.setBounds(343, 368, 233, 87);
		btnSobre.setFont(new Font("Mistral", Font.PLAIN, 35));
		add(btnSobre);
		
		JButton btnPontuao = new JButton("Pontua\u00E7\u00E3o");
		btnPontuao.setBounds(343, 269, 233, 87);
		btnPontuao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGame.setTela(new Pontuacao());
			}
		});
		btnPontuao.setFont(new Font("Mistral", Font.PLAIN, 35));
		add(btnPontuao);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(343, 467, 233, 87);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGame.setTela(new Login());
			}
		});
		btnSair.setFont(new Font("Mistral", Font.PLAIN, 35));
		add(btnSair);
		
		JLabel lblBemVindo = new JLabel("Bem vindo " + MainGame.player.getName());
		lblBemVindo.setBounds(25, 17, 347, 30);
		lblBemVindo.setForeground(Color.WHITE);
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblBemVindo);
		
		JLabel fundo = new JLabel(new ImageIcon(MainGame.class.getResource("/icones/home.jpg")));
		fundo.setBounds(-1, 0, 930, 630);
		add(fundo);
		

	}
}
