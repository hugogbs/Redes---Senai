package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import core.ARQuestion;
import core.CEQuestion;
import core.Game;
import core.Question;
import core.User;
import data.Arquivo;

public class MainGame extends JFrame implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainGame janela;
	public static Game game;
	public static String resumo = "";
	public static List<Question> todasQuestoes = new ArrayList<Question>();
	public static List<Question> geralQuestions = new ArrayList<Question>();
	public static List<CEQuestion> cabeamentoQuestions = new ArrayList<>();
	public static List<ARQuestion> arquiteturaQuestions = new ArrayList<ARQuestion>();
	public static List<Question> atual = new ArrayList<Question>();
	public static User player;
	public static int numQuests, acertos, erros;
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
		setBounds(100, 100, 930, 630);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		URL url = this.getClass().getResource("/icones/icon3.png");
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeTitulo);
		this.setTitle("LENE");
		this.setResizable(false);
	}

	private static void iniciaSistema() {
		janela = new MainGame();
		janela.setVisible(true);

	}

	public static void setTela(JPanel novaTela) {
		if (janela == null)
			iniciaSistema();

		if (novaTela == null)
			System.err.println("Tela inv�lida");
		if (novaTela instanceof Login)
			janela.setBounds(novaTela.getBounds());
		else
			janela.setBounds(50, 50, 930, 630);

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

		for (int i = 0; i < game.getAllQuestions().size(); i++) {
			todasQuestoes.add(game.getAllQuestions().get(i));
			if (game.getAllQuestions().get(i) instanceof CEQuestion)
				cabeamentoQuestions.add((CEQuestion) game.getAllQuestions()
						.get(i));
			else if (game.getAllQuestions().get(i) instanceof ARQuestion)
				arquiteturaQuestions.add((ARQuestion) game.getAllQuestions()
						.get(i));
			else
				geralQuestions.add(game.getAllQuestions().get(i));
		}

	}
}
