package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import core.Question;

public class QuestionPanel extends JPanel implements Serializable {
	JRadioButton[] botoes = new JRadioButton[5];
	private List<String> respostas;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public QuestionPanel(int Number, Question quest) {
		respostas = quest.getAnswers();

		setLayout(null);

		JLabel lblQuesto = new JLabel("Quest\u00E3o " + Number + ":");
		lblQuesto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuesto.setBounds(25, 22, 184, 25);
		add(lblQuesto);

		JLabel lblPontos = new JLabel("Pontos: " + MainGame.pontos);
		lblPontos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPontos.setBounds(678, 22, 184, 25);
		add(lblPontos);

		JButton btnDesistir = new JButton("Desistir");
		btnDesistir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDesistir.setBounds(678, 540, 109, 35);
		add(btnDesistir);

		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSair.setBounds(138, 540, 109, 35);
		add(btnSair);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 58, 854, 100);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textArea.setLineWrap(true);
		textArea.setColumns(10);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setText(quest.getText());

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(101, 179, 775, 55);
		add(scrollPane2);

		JTextArea textPane = new JTextArea();
		textPane.setWrapStyleWord(true);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane.setLineWrap(true);
		textPane.setEditable(false);
		textPane.setText(respostas.get(0));
		scrollPane2.setViewportView(textPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(101, 252, 775, 55);
		add(scrollPane_1);

		JTextArea textPane_1 = new JTextArea();
		textPane_1.setWrapStyleWord(true);
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane_1.setLineWrap(true);
		textPane_1.setEditable(false);
		textPane_1.setText(respostas.get(1));
		scrollPane_1.setViewportView(textPane_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(101, 327, 775, 55);
		add(scrollPane_2);

		JTextArea textPane_2 = new JTextArea();
		textPane_2.setWrapStyleWord(true);
		textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane_2.setLineWrap(true);
		textPane_2.setEditable(false);
		textPane_2.setText(respostas.get(2));
		scrollPane_2.setViewportView(textPane_2);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(101, 399, 775, 55);
		add(scrollPane_3);

		JTextArea textPane_3 = new JTextArea();
		textPane_3.setWrapStyleWord(true);
		textPane_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane_3.setLineWrap(true);
		textPane_3.setEditable(false);
		textPane_3.setText(respostas.get(3));
		scrollPane_3.setViewportView(textPane_3);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(101, 474, 775, 55);
		add(scrollPane_4);

		JTextArea textPane_4 = new JTextArea();
		textPane_4.setWrapStyleWord(true);
		textPane_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane_4.setLineWrap(true);
		textPane_4.setEditable(false);
		textPane_4.setText(respostas.get(4));
		scrollPane_4.setViewportView(textPane_4);

		JRadioButton rdbtnA = new JRadioButton("A)");
		buttonGroup.add(rdbtnA);
		rdbtnA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnA.setBounds(35, 198, 109, 23);
		add(rdbtnA);

		JRadioButton rdbtnB = new JRadioButton("B)");
		buttonGroup.add(rdbtnB);
		rdbtnB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnB.setBounds(35, 270, 109, 23);
		add(rdbtnB);

		JRadioButton rdbtnC = new JRadioButton("C)");
		buttonGroup.add(rdbtnC);
		rdbtnC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnC.setBounds(35, 342, 109, 23);
		add(rdbtnC);

		JRadioButton rdbtnD = new JRadioButton("D)");
		buttonGroup.add(rdbtnD);
		rdbtnD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnD.setBounds(35, 417, 109, 23);
		add(rdbtnD);

		JRadioButton rdbtnE = new JRadioButton("E)");
		buttonGroup.add(rdbtnE);
		rdbtnE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnE.setBounds(35, 492, 109, 23);
		add(rdbtnE);

		botoes[0] = rdbtnA;
		botoes[1] = rdbtnB;
		botoes[2] = rdbtnC;
		botoes[3] = rdbtnD;
		botoes[4] = rdbtnE;

		JButton btnResponder = new JButton("Responder");
		btnResponder.setBounds(394, 540, 121, 35);
		btnResponder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (buttonGroup.getSelection() == null) {
					JOptionPane.showMessageDialog(null,
							"Selecione uma resposta primeiro");
					return;
				}

				boolean acertou = false;

				for (int i = 0; i < botoes.length; i++) {
					if (botoes[i].isSelected()
							&& i == quest.getIdCorrentAnswer()) {
						JOptionPane.showMessageDialog(null, "Certa resposta!",
								"Parabéns", JOptionPane.INFORMATION_MESSAGE);
						botoes[i].setSelected(false);

						MainGame.pontos += 100;
						Random r = new Random();
						MainGame.setTela(new QuestionPanel(Number + 1,
								MainGame.questoes.remove(r
										.nextInt(MainGame.questoes.size()))));
						acertou = true;
					}
				}

				if (!acertou) {
					buttonGroup.setSelected(null, false);
					JOptionPane.showMessageDialog(null, "Resposta errada!",
							"Tente Novamente", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnResponder.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(btnResponder);

	}
}
