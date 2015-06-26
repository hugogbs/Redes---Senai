package gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pontuacao extends JPanel {

	/**
	 * Create the panel.
	 */
	public Pontuacao() {
		
		JLabel fundo = new JLabel(new ImageIcon(MainGame.class.getResource("/icones/points.jpg")));
		fundo.setBounds(0, 0, 930, 630);
		add(fundo);

	}

}
