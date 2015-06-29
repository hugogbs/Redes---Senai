package core;


import java.io.Serializable;

import org.apache.commons.mail.SimpleEmail;;

/**
 * Manipula o envio de emails para os hospedes
 * @author Hugo Gabriel Bezerra da Silva
 */

public class Email implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Email() {}

	@SuppressWarnings("deprecation")
	public void enviaEmail(String texto, String assunto)
			throws Exception {
		if (texto == null || texto.equals(""))
			throw new Exception();
		if (assunto == null || assunto.equals(""))
			throw new Exception();

		SimpleEmail emailSimples = new SimpleEmail();
		emailSimples.setHostName("smtp.gmail.com");
		emailSimples.addTo("hsilvagabriel@gmail.com", "");
		emailSimples.addTo("henrriique@hotmail.com", "");
		emailSimples.setFrom("rivieracampina@gmail.com", "Projeto LeNe");
		emailSimples.setSubject(assunto);
		emailSimples.setMsg(texto);
		emailSimples.setAuthentication("rivieracampina@gmail.com",
				"edvalcabeca");
		emailSimples.setSmtpPort(465);
		emailSimples.setSSL(true);
		emailSimples.setTLS(true);
		emailSimples.send();

	}
}