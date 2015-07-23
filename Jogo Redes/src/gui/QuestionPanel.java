package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import core.Email;
import core.Question;

public class QuestionPanel extends JPanel implements Serializable {
	JRadioButton[] botoes = new JRadioButton[5];
	private String[] respostas;

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
		lblQuesto.setBounds(25, 11, 184, 25);
		add(lblQuesto);

		JLabel lblPontos = new JLabel("Pontos: " + MainGame.pontos);
		lblPontos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPontos.setBounds(678, 11, 184, 25);
		// add(lblPontos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 46, 854, 122);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setBorder(new LineBorder(Color.WHITE, 5, true));
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
		textPane.setBorder(new LineBorder(Color.WHITE, 5, true));
		textPane.setWrapStyleWord(true);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane.setLineWrap(true);
		textPane.setEditable(false);
		textPane.setText(respostas[0]);
		scrollPane2.setViewportView(textPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(101, 252, 775, 55);
		add(scrollPane_1);

		JTextArea textPane_1 = new JTextArea();
		textPane_1.setBorder(new LineBorder(Color.WHITE, 5, true));
		textPane_1.setWrapStyleWord(true);
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane_1.setLineWrap(true);
		textPane_1.setEditable(false);
		textPane_1.setText(respostas[1]);
		scrollPane_1.setViewportView(textPane_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(101, 327, 775, 55);
		add(scrollPane_2);

		JTextArea textPane_2 = new JTextArea();
		textPane_2.setBorder(new LineBorder(Color.WHITE, 5, true));
		textPane_2.setWrapStyleWord(true);
		textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane_2.setLineWrap(true);
		textPane_2.setEditable(false);
		textPane_2.setText(respostas[2]);
		scrollPane_2.setViewportView(textPane_2);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(101, 399, 775, 55);
		add(scrollPane_3);

		JTextArea textPane_3 = new JTextArea();
		textPane_3.setBorder(new LineBorder(Color.WHITE, 5, true));
		textPane_3.setWrapStyleWord(true);
		textPane_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane_3.setLineWrap(true);
		textPane_3.setEditable(false);
		textPane_3.setText(respostas[3]);
		scrollPane_3.setViewportView(textPane_3);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(101, 474, 775, 55);
		add(scrollPane_4);

		JTextArea textPane_4 = new JTextArea();
		textPane_4.setBorder(new LineBorder(Color.WHITE, 5, true));
		textPane_4.setWrapStyleWord(true);
		textPane_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane_4.setLineWrap(true);
		textPane_4.setEditable(false);
		textPane_4.setText(respostas[4]);
		scrollPane_4.setViewportView(textPane_4);

		JRadioButton rdbtnA = new JRadioButton(" A)");
		rdbtnA.setOpaque(false);
		buttonGroup.add(rdbtnA);
		rdbtnA.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnA.setBounds(50, 198, 109, 23);
		add(rdbtnA);

		JRadioButton rdbtnB = new JRadioButton(" B)");
		rdbtnB.setOpaque(false);
		buttonGroup.add(rdbtnB);
		rdbtnB.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnB.setBounds(50, 270, 109, 23);
		add(rdbtnB);

		JRadioButton rdbtnC = new JRadioButton(" C)");
		rdbtnC.setOpaque(false);
		buttonGroup.add(rdbtnC);
		rdbtnC.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnC.setBounds(50, 342, 109, 23);
		add(rdbtnC);

		JRadioButton rdbtnD = new JRadioButton(" D)");
		rdbtnD.setOpaque(false);
		buttonGroup.add(rdbtnD);
		rdbtnD.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnD.setBounds(50, 417, 109, 23);
		add(rdbtnD);

		JRadioButton rdbtnE = new JRadioButton(" E)");
		rdbtnE.setOpaque(false);
		buttonGroup.add(rdbtnE);
		rdbtnE.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnE.setBounds(50, 492, 109, 23);
		add(rdbtnE);

		botoes[0] = rdbtnA;
		botoes[1] = rdbtnB;
		botoes[2] = rdbtnC;
		botoes[3] = rdbtnD;
		botoes[4] = rdbtnE;

		JButton button = new JButton("Desistir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGame.player.addResolvidos(quest, false);
				MainGame.erros += 1;
//				Email em = new Email();
//				try {
//					em.enviaEmail(MainGame.player.getName(), MainGame.resumo);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				try {
//					em.enviaEmail(MainGame.resumo, "LeNe Respostas do "
//							+ MainGame.player.getName());
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				JOptionPane.showMessageDialog(null, "Você acertou "
						+ MainGame.acertos + " e errou " + MainGame.erros
						+ " das " + MainGame.numQuests
						+ " questões selecionadas!");

				MainGame.setTela(new Home());
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(141, 540, 109, 35);
		add(button);

		JButton btnPular = new JButton("Pular");
		btnPular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MainGame.player.addResolvidos(quest, false);
				MainGame.erros += 1;
				String s = "\n" + quest.getText() + "\nPULOU";
				MainGame.resumo += s;

				Random r = new Random();
				if (Number + 1 <= MainGame.numQuests
						&& MainGame.atual.size() > 0) {
					MainGame.setTela(new QuestionPanel(Number + 1,
							MainGame.atual.remove(r.nextInt(MainGame.atual
									.size()))));
				} else {
					JOptionPane.showMessageDialog(null, "Você acertou "
							+ MainGame.acertos + " e errou " + MainGame.erros
							+ " das " + MainGame.numQuests
							+ " questões selecionadas!");
//					Email e = new Email();
//					try {
//						e.enviaEmail(MainGame.resumo, "LeNe Respostas do "
//								+ MainGame.player.getName());
//					} catch (Exception e1) {
//						e1.printStackTrace();
//					}
					MainGame.setTela(new Home());
				}
			}
		});
		btnPular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPular.setBounds(678, 540, 109, 35);
		add(btnPular);

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
						acertou = true;
						MainGame.acertos += 1;
					}
				}

				if (!acertou) {
					buttonGroup.setSelected(null, false);
					MainGame.erros += 1;
					JOptionPane.showMessageDialog(null, "Resposta errada!",
							"Tente Novamente", JOptionPane.ERROR_MESSAGE);
				}

				String s = "\n" + quest.getText() + String.valueOf(acertou);
				MainGame.resumo += s;

				MainGame.player.addResolvidos(quest, acertou);

				Random r = new Random();
				if (Number + 1 <= MainGame.numQuests
						&& MainGame.atual.size() > 0) {
					MainGame.setTela(new QuestionPanel(Number + 1,
							MainGame.atual.remove(r.nextInt(MainGame.atual
									.size()))));
				} else {
					JOptionPane.showMessageDialog(null, "Você acertou "
							+ MainGame.acertos + " e errou " + MainGame.erros
							+ " das " + MainGame.numQuests
							+ " questões selecionadas!", "Resultado",
							JOptionPane.INFORMATION_MESSAGE);
//					Email e = new Email();
//					try {
//						e.enviaEmail(MainGame.resumo, "LeNe Respostas do "
//								+ MainGame.player.getName());
//					} catch (Exception e1) {
//						e1.printStackTrace();
//					}
					MainGame.setTela(new Home());
				}
			}
		});
		btnResponder.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(btnResponder);

		JLabel fundo = new JLabel(new ImageIcon(
				MainGame.class.getResource("/icones/fundo.jpg")));
		fundo.setBounds(0, 0, 930, 630);
		add(fundo);

	}
}
