package gui;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Sobre extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Sobre() {

		setLayout(null);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(389, 556, 114, 33);
		add(btnNewButton);
		
		JTextArea txtrLenaLearning = new JTextArea();
		txtrLenaLearning.setEditable(false);
		txtrLenaLearning.setMargin(new Insets(10, 10, 10, 10));
		txtrLenaLearning.setWrapStyleWord(true);
		txtrLenaLearning.setLineWrap(true);
		txtrLenaLearning.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtrLenaLearning.setTabSize(4);
		txtrLenaLearning.setText("\tLENA - Learning Network (Rede de aprendizagem em tradu\u00E7\u00E3o livre) \u00E9 uma aplica\u00E7\u00E3o desenvolvida para fundamentar o Trabalho de Conclus\u00E3o de Curso em T\u00E9cnico em Manuten\u00E7\u00E3o e Suporte em Inform\u00E1tica no SENAI Campina Grande-PB.\r\n\t\r\n\tO jogo tem como p\u00FAblico alvo, estudantes interessados em exercitar e ampliar seus conhecimentos em Redes de Computadores.\r\n\r\n\tObrigado por jogar e divirta-se!\r\n\r\nDesenvolvedores:\r\n\tHugo Gabriel Bezerra da Silva\r\n\tJorge Henrique Gomes da Silva e Melo\r\n\r\nOrientadora:\r\n\tCamila Sarmento");
		txtrLenaLearning.setBounds(56, 62, 836, 444);
		add(txtrLenaLearning);

		JLabel fundo = new JLabel(new ImageIcon(
				MainGame.class.getResource("/icones/home.jpg")));
		fundo.setBounds(0, 0, 930, 630);
		add(fundo);

	}
}
