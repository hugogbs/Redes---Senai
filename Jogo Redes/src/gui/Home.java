package gui;

import java.io.Serializable;

import javax.swing.JPanel;

import core.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Home extends JPanel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Home(User user) {
		setLayout(null);
		
		JButton btnNovoJogo = new JButton("Novo Jogo");
		btnNovoJogo.setFont(new Font("Mistral", Font.PLAIN, 35));
		btnNovoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNovoJogo.setBounds(328, 115, 233, 87);
		add(btnNovoJogo);
		
		JButton btnInstrues = new JButton("Instru\u00E7\u00F5es");
		btnInstrues.setFont(new Font("Mistral", Font.PLAIN, 35));
		btnInstrues.setBounds(328, 213, 233, 87);
		add(btnInstrues);
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.setFont(new Font("Mistral", Font.PLAIN, 35));
		btnSobre.setBounds(328, 410, 233, 87);
		add(btnSobre);
		
		JButton btnPontuao = new JButton("Pontua\u00E7\u00E3o");
		btnPontuao.setFont(new Font("Mistral", Font.PLAIN, 35));
		btnPontuao.setBounds(328, 311, 233, 87);
		add(btnPontuao);

	}
}
