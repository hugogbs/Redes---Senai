package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import core.Game;

public class Arquivo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String DIR = "Arquivo//Jogo";
	static {
		try {
			new File(DIR).mkdir();
			new File(DIR).mkdir();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void salvaGame(Game game) throws Exception {
		File file = new File(DIR, "Data");
		if (file.exists()) {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(file));
			out.writeObject(game);
			out.close();
		} else {
			file.createNewFile();
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(file));
			out.writeObject(game);
			out.close();
		}
	}

	public static Game carregaGame() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					new File(DIR, "Data")));
			Object obj = in.readObject();
			in.close();
			return (Game) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean extisteGame() {
		File file = new File(DIR, "Data");
		return file.exists();
	}
}