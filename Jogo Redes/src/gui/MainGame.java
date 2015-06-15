package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;

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

public class MainGame extends JFrame implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainGame janela;
	public static Game game;
	private JPanel contentPane;
	private static JButton btnHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				String texto = "Qual destas pertubações dos canais de comunicação é considerada uma distorção aleatória?";
				String[] alternativas = new String[] { "RETARDO", "HARMÔNICA",
						"ATENUAÇÃO", "DIAFONIA", "POLARIZAÇÃO" };				
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
				} catch (Exception e) {
					e.printStackTrace();
				}
				criaGame();
				
				Question q = null;
				User u = null;
				try {
					q = new Question(texto, alternativas, 3);
					u = new User("hugo.silva", "hugogbs");
					game.addUser(u);
					game.addQuestion(q);
				} catch (QuestionException | UserException e1) {
					e1.printStackTrace();
				}
				
				System.out.println(game.getUsers().get(0).getName());
				System.out.println(game.getUsers().get(0).getPassword());
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
	}

}
