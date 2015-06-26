package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import core.Question;

public class GameOptions extends JPanel {
	private JCheckBox chckbxGeral, chckbxCabeamentoEstruturado,
			chckbxArquiteturaDeRedes, chckbxTodos;
	private JCheckBox[] lista = new JCheckBox[3];
	private SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 1, 1);
	private JSpinner spinner;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblSelecioneOTema;
	private JLabel lblSelecioneONmero;
	private JLabel lblOValorDeve;

	/**
	 * Create the panel.
	 */
	public GameOptions() {
		setLayout(null);

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setFont(new Font("Mistral", Font.PLAIN, 35));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGame.numQuests = model.getNumber().intValue();
				Random r = new Random();
				geraQuestoes();
				MainGame.setTela(new QuestionPanel(0, MainGame.atual.remove(r
						.nextInt(MainGame.atual.size()))));
			}
		});

		btnIniciar.setBounds(649, 482, 233, 87);
		add(btnIniciar);

		JButton btnVolltar = new JButton("Voltar");
		btnVolltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGame.setTela(new Home());
			}
		});
		btnVolltar.setFont(new Font("Mistral", Font.PLAIN, 35));
		btnVolltar.setBounds(49, 482, 233, 87);
		add(btnVolltar);

		chckbxGeral = new JCheckBox("Geral");

		chckbxGeral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!chckbxGeral.isSelected())
					chckbxTodos.setSelected(false);
				model.setMaximum(calculaLimites());
				//spinner.setModel(model);
				model.setValue(1);
				spinner.setValue(1);
				lblOValorDeve.setText("Escolha " + calculaLimites()
						+ " questões no máximo!");
				lblOValorDeve.setVisible(true);


			}
		});
		chckbxGeral.setForeground(Color.WHITE);
		chckbxGeral.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxGeral.setOpaque(false);
		chckbxGeral.setBounds(85, 272, 147, 23);
		add(chckbxGeral);

		chckbxCabeamentoEstruturado = new JCheckBox("Cabeamento Estruturado");

		chckbxCabeamentoEstruturado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!chckbxCabeamentoEstruturado.isSelected())
					chckbxTodos.setSelected(false);
				model.setMaximum(calculaLimites());
				model.setValue(1);
				spinner.setValue(1);
				//spinner.setModel(model);
				lblOValorDeve.setText("Escolha " + calculaLimites()
						+ " questões no máximo!");
				lblOValorDeve.setVisible(true);

			}
		});
		chckbxCabeamentoEstruturado.setForeground(Color.WHITE);
		chckbxCabeamentoEstruturado.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxCabeamentoEstruturado.setOpaque(false);
		chckbxCabeamentoEstruturado.setBounds(85, 309, 209, 23);
		add(chckbxCabeamentoEstruturado);

		chckbxArquiteturaDeRedes = new JCheckBox("Arquitetura de Redes");

		chckbxArquiteturaDeRedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!chckbxArquiteturaDeRedes.isSelected())
					chckbxTodos.setSelected(false);
				model.setValue(1);
				spinner.setValue(1);
				model.setMaximum(calculaLimites());
				//spinner.setModel(model);
				lblOValorDeve.setText("Escolha " + calculaLimites()
						+ " questões no máximo!");
				lblOValorDeve.setVisible(true);

			}
		});
		chckbxArquiteturaDeRedes.setForeground(Color.WHITE);
		chckbxArquiteturaDeRedes.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxArquiteturaDeRedes.setOpaque(false);
		chckbxArquiteturaDeRedes.setBounds(85, 345, 197, 23);
		add(chckbxArquiteturaDeRedes);

		chckbxTodos = new JCheckBox("Todos");

		chckbxTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chckbxArquiteturaDeRedes.setSelected(chckbxTodos.isSelected());
				chckbxCabeamentoEstruturado.setSelected(chckbxTodos
						.isSelected());
				chckbxGeral.setSelected(chckbxTodos.isSelected());
				model.setValue(1);
				spinner.setValue(1);
				model.setMaximum(calculaLimites());
				//spinner.setModel(model);
				lblOValorDeve.setText("Escolha " + calculaLimites()
						+ " questões no máximo!");
				lblOValorDeve.setVisible(true);
				
			}
		});
		chckbxTodos.setForeground(Color.WHITE);
		chckbxTodos.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxTodos.setOpaque(false);
		chckbxTodos.setBounds(85, 238, 147, 23);
		add(chckbxTodos);

		lblSelecioneOTema = new JLabel("Selecione o tema:");
		lblSelecioneOTema.setForeground(Color.WHITE);
		lblSelecioneOTema.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelecioneOTema.setBounds(10, 195, 183, 29);
		add(lblSelecioneOTema);

		lista[0] = chckbxGeral;
		lista[1] = chckbxCabeamentoEstruturado;
		lista[2] = chckbxArquiteturaDeRedes;

		lblSelecioneONmero = new JLabel("N\u00FAmero de quest\u00F5es:");
		lblSelecioneONmero.setForeground(Color.WHITE);
		lblSelecioneONmero.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelecioneONmero.setBounds(361, 195, 209, 29);
		add(lblSelecioneONmero);

		spinner = new JSpinner();
		spinner.setToolTipText("Escolha um valor entre\r\n");
		spinner.setForeground(Color.WHITE);
		spinner.setFont(new Font("Tahoma", Font.BOLD, 15));
		spinner.setOpaque(false);
		spinner.setBounds(570, 193, 56, 37);
		spinner.setModel(model);

		add(spinner);

		lblOValorDeve = new JLabel("Escolha 0 questões no máximo!");
		lblOValorDeve.setForeground(Color.WHITE);
		lblOValorDeve.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOValorDeve.setBounds(430, 248, 245, 29);
		add(lblOValorDeve);
		lblOValorDeve.setVisible(false);

		JLabel fundo = new JLabel(new ImageIcon(
				MainGame.class.getResource("/icones/gameOptions.jpg")));
		fundo.setBounds(0, 0, 930, 630);
		add(fundo);

	}

	private int calculaLimites() {
		int value = 0;
		if (chckbxTodos.isSelected())
			return MainGame.todasQuestoes.size();
		if (chckbxArquiteturaDeRedes.isSelected())
			value += MainGame.arquiteturaQuestions.size();
		if (chckbxCabeamentoEstruturado.isSelected())
			value += MainGame.cabeamentoQuestions.size();
		if (chckbxGeral.isSelected())
			value += MainGame.geralQuestions.size();
		return value;
	}

	private void geraQuestoes() {
		MainGame.atual = new ArrayList<Question>();

		if (chckbxTodos.isSelected()) {
			for (int i = 0; i < MainGame.todasQuestoes.size(); i++) {
				MainGame.atual.add(MainGame.todasQuestoes.get(i));
			}
			return;
			
		}
		if (chckbxArquiteturaDeRedes.isSelected()) {
			for (int i = 0; i < MainGame.arquiteturaQuestions.size(); i++) {
				MainGame.atual.add(MainGame.arquiteturaQuestions.get(i));
			}
		}
		if (chckbxCabeamentoEstruturado.isSelected())
			for (int i = 0; i < MainGame.cabeamentoQuestions.size(); i++) {
				MainGame.atual.add(MainGame.cabeamentoQuestions.get(i));
			}
		if (chckbxGeral.isSelected())
			for (int i = 0; i < MainGame.geralQuestions.size(); i++) {
				MainGame.atual.add(MainGame.geralQuestions.get(i));
			}
	}
}
