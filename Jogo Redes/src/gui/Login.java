package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import core.Question;
import core.User;

public class Login extends JPanel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnEntrar;

	/**
	 * Create the panel.
	 */
	public Login() {
		setLayout(null);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					passwordField.grabFocus();
				}
			}
		});
		textField.setBounds(92, 139, 135, 30);
		add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnEntrar.doClick();
				}
			}
		});
		passwordField.setBounds(92, 201, 135, 30);
		add(passwordField);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsurio.setBounds(25, 140, 57, 25);
		add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(25, 202, 46, 25);
		add(lblSenha);

		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();
				String pass = String.valueOf(passwordField.getPassword());
				List<Question> qsts = null;
				
				int i = 0;
				try {
					while (true)
						if (verificaLogin(MainGame.game.getUsers().get(i++), name, pass))
							break;
					qsts = MainGame.game.getQuestions();
					MainGame.setTela(new QuestionPanel(1, qsts.remove(0), 0));
				} catch (Exception e) {
					passwordField.setText("");
					textField.setText("");
					JOptionPane.showMessageDialog(null,
							"Usuário e/ou senha invalidos!\nVerifique os campos preenchidos!"
							+ "\nOu entre com contato com o adminstrador para obter acesso.");
				}
				
			}
			private boolean verificaLogin(User user, String name, String pass) {
				if (user.getName().equals(name)
						&& user.getPassword().equals(pass))
					return true;
				return false;
			}

		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar.setBounds(80, 265, 100, 25);
		add(btnEntrar);
		setBounds(100, 100, 270, 350);

	}

}
