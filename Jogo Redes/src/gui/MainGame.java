package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import core.Game;
import core.Question;
import core.User;
import data.Arquivo;
import exception.QuestionException;
import exception.UserException;

public class MainGame extends JFrame implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainGame janela;
	public static Game game;
	public static List<Question> questoes = new ArrayList<Question>();
	public static User player;
	public static int pontos = 0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
				} catch (Exception e) {
					e.printStackTrace();
				}

				criaGame();			
				// for (int i = 0; i < game.getQuestions().size(); i++) {
				// System.out.println(game.getQuestions().get(i).getText());
				// }
				// System.out.println();

				// String test =
				// "[POSCOMP 2011] Em relação à transmissão com fibras óticas, considere as afirmativas a seguir."
				// +
				// "\n\nI. A velocidade de propagação em uma fibra ótica é muito superior à velocidade de propagação em um cabo coaxial."
				// +
				// "\n\nII. Uma fibra monomodo, por permitir à luz se propagar apenas em um modo, permite obter uma taxa em bps bem superior à de uma fibra multimodo."
				// +
				// "\n\nIII. Pode-se ter comunicação full-duplex (transmissão simultânea nos dois sentidos) utilizando-se apenas uma fibra única e não um par de fibras."
				// +
				// "\n\nIV. A atenuação em fibra ótica ocorre devido principalmente à absorção (produção de calor) e radiação e independe do comprimento de onda utilizado na transmissão da luz."
				// + "\n\nAssinale a alternativa correta.";
				//
				// List<String> r = new ArrayList<>();
				// r.add("Somente as afirmativas I e IV são corretas.");
				// r.add("Somente as afirmativas II e III são corretas.");
				// r.add("Somente as afirmativas III e IV são corretas.");
				// r.add("Somente as afirmativas I, II e III são corretas.");
				// r.add("Somente as afirmativas I, II e IV são corretas.");
				//
				// Question q;
				// try {
				// q = new Question(test, r, 1);
				// game.addQuestion(q);
				// System.out.println(game.getQuestions().size());
				// } catch (QuestionException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }
				//
				//
				setTela(new Login());
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGame() {

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					Arquivo.salvaGame(game);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		setBounds(100, 100, 900, 630);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	private static void iniciaSistema() {
		janela = new MainGame();
		janela.setVisible(true);

	}

	public static void setTela(JPanel novaTela) {
		if (janela == null)
			iniciaSistema();

		if (novaTela == null)
			System.err.println("Tela inválida");
		if (novaTela instanceof Login)
			janela.setBounds(novaTela.getBounds());
		else
			janela.setBounds(0, 0, 930, 630);

		janela.contentPane.removeAll();
		janela.contentPane.add(novaTela);
		janela.repaint();
		janela.revalidate();

	}

	private static void criaGame() {
		if (Arquivo.extisteGame()) {
			game = Arquivo.carregaGame();
		} else {
			game = new Game();
			try {
				Arquivo.salvaGame(game);
			} catch (Exception e) {
				System.out.println("Game nao criado");
			}
		}
		if (game.getQuestions() != null) {
			for (int i = 0; i < game.getQuestions().size(); i++)
				questoes.add(game.getQuestions().get(i));
		}

	}
}
