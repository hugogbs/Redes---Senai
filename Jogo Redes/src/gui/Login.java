package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import core.User;

public class Login extends JPanel implements Serializable {
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
		setBackground(Color.WHITE);
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

				boolean autentication = false;
				List<User> players = MainGame.game.getUsers();
				for (int i = 0; i < players.size(); i++) {
					if (players.get(i).getUserName().equals(name)
							&& players.get(i).getPassword().equals(pass)) {
						MainGame.player = players.get(i);
						autentication = true;
						break;
					}
				}
				
				if (autentication) {
					MainGame.setTela(new Home());
				} else {
					passwordField.setText("");
					textField.setText("");
					JOptionPane
							.showMessageDialog(
									null,
									"Usuário e/ou senha invalidos!\nVerifique os campos preenchidos!"
											+ "\nOu entre com contato com o adminstrador para obter acesso.");
				}

			}

		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar.setBounds(80, 265, 100, 25);
		add(btnEntrar);
		setBounds(100, 100, 270, 350);
		
		JLabel fundo = new JLabel(new ImageIcon(MainGame.class.getResource("/icones/images.png")));
		fundo.setBackground(SystemColor.inactiveCaptionBorder);
		fundo.setBounds(0, 0, 250, 130);
		add(fundo);


	}
}
