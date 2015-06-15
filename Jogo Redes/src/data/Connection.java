package data;

/**
 * Realiza a conexão com a internet, permitindo baixar
 * e upar o usuários pontuaões e etc.
 *  
 * @author Hugo Gabriel
 * Código adaptado de
 * http://moacirrf.com.br/blog/?p=278
 */
public class Connection {

//	public static void main(String[] args) {
//		String protocolo = "http";
//		String endereco = "moacirrf.com.br";
//		String arquivo = "/arquivos/JSFImmediate.zip";
//		try {
//			// cria URL
//			URL url1 = new URL(protocolo, endereco, arquivo);
//			// abre uma conexao na url criada àcima
//			URLConnection con = url1.openConnection();
//			// tenta conectar.
//			con.connect();
//			// arquivo de saida
//			FileOutputStream fileOut = new FileOutputStream(
//					"c:/teste/JSFImmediate.zip");
//			int c = 0;
//			do {
//				// le o byte
//				c = con.getInputStream().read();
//				// escreve o byte no arquivo saida
//				fileOut.write(c);
//			} while (c != -1);
//			// fecha o arquivo de saida
//			fileOut.close();
//			System.out.println("Arquivo baixado com sucesso");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
