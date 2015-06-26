package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import core.ARQuestion;
import core.CEQuestion;

public class Pontuacao extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon low = new ImageIcon(
			MainGame.class.getResource("/icones/low.png"));
	private ImageIcon med = new ImageIcon(
			MainGame.class.getResource("/icones/med.png"));
	private ImageIcon hi = new ImageIcon(
			MainGame.class.getResource("/icones/hi.png"));
	private JLabel total, arq, cab, geral;
	private int contTotal, contArq, contCab, contGeral;

	/**
	 * Create the panel.
	 */
	public Pontuacao() {
		setLayout(null);

		JLabel lblPontuaoGeral = new JLabel("Pontua\u00E7\u00E3o Total");
		lblPontuaoGeral.setHorizontalAlignment(SwingConstants.CENTER);
		lblPontuaoGeral.setForeground(Color.WHITE);
		lblPontuaoGeral.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPontuaoGeral.setBounds(382, 40, 162, 31);
		add(lblPontuaoGeral);

		JLabel lblArquiteturaDeRedes = new JLabel("Arquitetura de Redes");
		lblArquiteturaDeRedes.setHorizontalAlignment(SwingConstants.CENTER);
		lblArquiteturaDeRedes.setForeground(Color.WHITE);
		lblArquiteturaDeRedes.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblArquiteturaDeRedes.setBounds(68, 312, 237, 31);
		add(lblArquiteturaDeRedes);

		JLabel lblGeral = new JLabel("Geral");
		lblGeral.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeral.setForeground(Color.WHITE);
		lblGeral.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGeral.setBounds(344, 312, 237, 31);
		add(lblGeral);

		JLabel lblCabeamentoEstruturado = new JLabel("Cabeamento Estruturado");
		lblCabeamentoEstruturado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCabeamentoEstruturado.setForeground(Color.WHITE);
		lblCabeamentoEstruturado.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCabeamentoEstruturado.setBounds(652, 312, 237, 31);
		add(lblCabeamentoEstruturado);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGame.setTela(new Home());
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.setBounds(411, 563, 111, 31);
		add(btnVoltar);

		for (int i = 0; i < MainGame.player.getResolvidos().size(); i++) {
			if (MainGame.player.getAcertos().get(i))
				contTotal++;
			if (MainGame.player.getResolvidos().get(i) instanceof CEQuestion
					&& MainGame.player.getAcertos().get(i))
				contCab++;
			else if (MainGame.player.getResolvidos().get(i) instanceof ARQuestion
					&& MainGame.player.getAcertos().get(i))
				contArq++;
			else if (MainGame.player.getAcertos().get(i))
				contGeral++;
		}

		if (contTotal < MainGame.todasQuestoes.size() / 3)
			total = new JLabel(low);
		else if (contTotal >= MainGame.todasQuestoes.size() / 3
				&& contTotal < 2 * MainGame.todasQuestoes.size() / 3)
			total = new JLabel(med);
		else if (contTotal >= 2 * MainGame.todasQuestoes.size() / 3)
			total = new JLabel(hi);

		if (contArq < MainGame.arquiteturaQuestions.size() / 3)
			arq = new JLabel(low);
		else if (contArq >= MainGame.arquiteturaQuestions.size() / 3
				&& contArq < 2 * MainGame.arquiteturaQuestions.size() / 3)
			arq = new JLabel(med);
		else if (contArq >= 2 * MainGame.arquiteturaQuestions.size() / 3)
			arq = new JLabel(hi);

		if (contGeral < MainGame.geralQuestions.size() / 3)
			geral = new JLabel(low);
		else if (contGeral >= MainGame.geralQuestions.size() / 3
				&& contGeral < 2 * MainGame.geralQuestions.size() / 3)
			geral = new JLabel(med);
		else if (contGeral >= 2 * MainGame.geralQuestions.size() / 3)
			geral = new JLabel(hi);

		if (contCab < MainGame.cabeamentoQuestions.size() / 3)
			cab = new JLabel(low);
		else if (contCab >= MainGame.cabeamentoQuestions.size() / 3
				&& contCab < 2 * MainGame.cabeamentoQuestions.size() / 3)
			cab = new JLabel(med);
		else if (contCab >= 2 * MainGame.cabeamentoQuestions.size() / 3)
			cab = new JLabel(hi);

		total.setOpaque(false);
		total.setBounds(390, 80, 150, 150);
		arq.setOpaque(false);
		arq.setBounds(114, 354, 150, 150);
		geral.setOpaque(false);
		geral.setBounds(390, 354, 150, 150);
		cab.setOpaque(false);
		cab.setBounds(708, 354, 150, 150);
		add(total);
		add(arq);
		add(geral);
		add(cab);

		JLabel fundo = new JLabel(new ImageIcon(
				MainGame.class.getResource("/icones/points.jpg")));
		fundo.setBounds(0, 0, 930, 630);
		add(fundo);

	}
}
