package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import exception.QuestionException;
import exception.UserException;

public class Game implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> users;
	private List<Question> geralQuestions;
	private List<ARQuestion> arquiteturaQuestions;
	private List<CEQuestion> cabeamentoQuestions;
	private List<Question> allQuestions;

	public Game() {
		users = new ArrayList<User>();
		geralQuestions = new ArrayList<>();
		arquiteturaQuestions = new ArrayList<>();
		cabeamentoQuestions = new ArrayList<>();
		allQuestions = new ArrayList<>();

		instanciaQuestoes();
		instanciaUsuarios();
	}

	public List<User> getUsers() {
		return users;
	}

	public List<Question> getAllQuestions() {
		return allQuestions;
	}

	public List<Question> getGeralQuestions() {
		return geralQuestions;
	}

	public void addGeneralQuestion(Question q) {
		for (int i = 0; i < geralQuestions.size(); i++) {
			if (q.equals(geralQuestions.get(i)))
				return;
		}
		geralQuestions.add(q);
		allQuestions.add(q);
	}

	public void removeUser(String userName) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName().equals(userName)) {
				users.remove(i);
				return;
			}
		}
	}

	public void addUser(User u) {
		for (int i = 0; i < users.size(); i++) {
			if (u.equals(users.get(i)))
				return;
		}
		users.add(u);
	}

	public List<ARQuestion> getArquiteturaQuestions() {
		return arquiteturaQuestions;
	}

	public void addArquiteturaQuestions(ARQuestion q) {
		for (int i = 0; i < arquiteturaQuestions.size(); i++) {
			if (q.equals(arquiteturaQuestions.get(i)))
				return;
		}
		arquiteturaQuestions.add(q);
		allQuestions.add(q);
	}

	public List<CEQuestion> getCabeamentoQuestions() {
		return cabeamentoQuestions;
	}

	public void addCabeamentoQuestion(CEQuestion q) {
		for (int i = 0; i < cabeamentoQuestions.size(); i++) {
			if (q.equals(cabeamentoQuestions.get(i)))
				return;

		}
		cabeamentoQuestions.add(q);
		allQuestions.add(q);
	}

	private void instanciaQuestoes() {
		
		instanciaCabeamentoQsts();
		instanciaArquiteturaQsts();
		instanciaGeralQsts();

	}

	private void instanciaUsuarios() {
		try {
			addUser(new User("Adminstrador", "admin", "admin"));
			addUser(new User("Gabriel", "hugobs", "hugobs"));
			addUser(new User("Jorge", "jorge", "jorge"));
		} catch (UserException e) { }
		
		for (int i = 1; i < 101; i++) {
			try {
				addUser(new User("Aluno" + i, "aluno" + i, "aluno" + i));
			} catch (UserException e) { }	
		}
	}

	private void instanciaCabeamentoQsts() {
		try {
			addCabeamentoQuestion(new CEQuestion(
					"As distor��es sistem�ticas s�o um tipo de perturba��o nos canais "
							+ "de comunica��o de uma rede e ocorrem sempre que � enviada uma "
							+ "informa��o ou dado atrav�s do canal.\nSabendo disto, qual destas "
							+ "perturba��es dos canais de comunica��o N�O � uma distor��o sistem�tica?",
					new String[] { "RETARDO", "HARM�NICA", "ATENUA��O",
							"POLARIZA��O", "DIAFONIA" }, 4));
		} catch (QuestionException e) {
			e.printStackTrace();
		}

		try {
			addCabeamentoQuestion(new CEQuestion(
					"V�rios fatores podem prejudicar a qualidade do sinal de uma transmiss�o, esses "
							+ "fatores chamados de perturba��es (ou distor��es) dos canais de comunica��o e "
							+ "est�o divididos em: distor��es sistem�ticas e distor��es aleat�rias.\nAssinale "
							+ "a alternativa que cont�m apenas distor��es aleat�rias",
					new String[] { "AGITA��O DE FASE � ECO - RU�DO",
							"RU�DO - HARM�NICA - RETARDO",
							"ECO - CARACTER�STICA - RU�DO",
							"PHASE HIT - ATENUA��O - ECO",
							"DIAFONIA � POLARIZA��O - RETARDO" }, 0));
		} catch (QuestionException e) {
			e.printStackTrace();
		}

		try {
			addCabeamentoQuestion(new CEQuestion(
					"Abaixo est�o alguns tipos de perturba��es sistem�ticas que ocorrem ao sinal durante sua transmiss�o e tamb�m suas defini��es. "
							+ "\n\nAssinale a alternativa que os relacione corretamente."
							+ "\n\nTermos:\n1- RETARDO         2- ATENUA��O        3- HARM�NICA"
							+ "\n\nDefini��es:"
							+ "\nA � Atrasos na frequ�ncia de um sinal, chegando a causar deforma��o no sinal transmitido."
							+ "\nB � Deforma��es da perda de pot�ncia do sinal, causadas por cabos, filtros, etc."
							+ "\nC � Chamada tamb�m de deforma��o linear, esse tipo de deforma��o � causada quando o sinal passa por etapas de amplifica��o.",
					new String[] { "1-B 2-A 3-C", "1-A 2-C 3-B", "1-A 2-B 3-C",
							"1-C 2-B 3-A", "1-C 2-A 3-B" }, 2));
		} catch (QuestionException e) {
			e.printStackTrace();
		}
		try {
			addCabeamentoQuestion(new CEQuestion(
					"Abaixo est�o alguns tipos de perturba��es aleat�rias que podem ocorrer ao sinal durante sua transmiss�o e tamb�m suas defini��es. "
							+ "\n\nAssinale a alternativa que os relacione corretamente."
							+ "\n\nTermos:\n1- ECO         2- RU�DO        3- DIAFONIA"
							+ "\n\nDefini��es:"
							+ "\nA � S�o dist�rbios el�tricos que ocorrem, ocasionalmente, em uma transmiss�o. Podem ser classificados em: t�rmicos e impulsivos."
							+ "\nB � Tamb�m chamado de crosstalk; Ocorre quando um par de fios causa interfer�ncia em outro par."
							+ "\nC � Nos sinais el�tricos esse fen�meno � a reflex�o do sinal ou de parte dele ao longo do meio.",
					new String[] { "1-B 2-A 3-C", "1-A 2-C 3-B", "1-A 2-B 3-C",
							"1-C 2-B 3-A", "1-C 2-A 3-B" }, 4));
		} catch (QuestionException e) {
			e.printStackTrace();
		}

		try {
			addCabeamentoQuestion(new CEQuestion(
					"Para elaborar um sistema de cabeamentos estruturado eficaz e imune a interfer�ncias � fundamental "
							+ "conhecer como ele funciona, que par�metros el�tricos est�o envolvidos na transmiss�o de uma informa��o. "
							+ "\nJulgue os itens a seguir sobre os par�metros el�tricos que modelam os canais de transmiss�o"
							+ "\n\nI - Um corpo � resistente eletricamente quando apresenta dificuldade na condu��o de corrente el�trica"
							+ "\n\nII - A indut�ncia atua como um controlador da corrente el�trica e � dependente da frequ�ncia. Sua unidade de media � o Farad"
							+ "\n\nIII - A capacit�ncia m�tua � uma caracter�stica que os condutores el�tricos possuem de absorver energia e armazen�-las por um per�odo de tempo"
							+ "\n\nIV - O ganho de pot�ncia de um sinal ao longo de um segmento de cabo � chamado de atenua��o e � medido em decib�is."
							+ "\n\nV � Condut�ncia � medida em Siemens e � o oposto de resist�ncia, ou seja, � a capacidade de conduzir corrente el�trica",
					new String[] {
							"Apenas as afirma��es I, II e IV s�o verdadeiras",
							"Apenas as afirma��es I, III e V s�o verdadeiras",
							"Apenas as afirma��es II, IV e V s�o verdadeiras",
							"Apenas as afirma��es IV e V s�o verdadeiras",
							"Todas as afirma��es s�o verdadeiras" }, 1));
		} catch (QuestionException e) {
			e.printStackTrace();
		}

	}

	private void instanciaArquiteturaQsts() {
		try {
			addArquiteturaQuestions(new ARQuestion(
					"Os elementos da rede s�o requisitos necess�rios para que ocorra "
							+ "a transmiss�o de informa��es em uma rede de computadores. "
							+ "\nAssinale a alternativa que lista corretamente esses elementos.",
					new String[] {
							"WI-FI, DISPOSITIVOS, REDE LAN, SER HUMANO",
							"MENSAGEM, DISPOSITIVOS, REDE CLIENTE/SERVIDOR, TCP/IP",
							"TCP/IP, MEIO F�SICO, SERVIDOR, MENSAGEM",
							"REGRAS, DISPOSITIVOS, MEIO F�SICO, MENSAGEM",
							"REGRAS, DISPOSITIVOS, SER HUMANO, MENSAGEM" }, 3));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"Os protocolos de comunica��o de uma rede s�o necess�rios para "
							+ "organizar a comunica��o propriamente dita. S�o  exemplos de "
							+ "protocolo: TCP, IP, IPX, UPD. "
							+ "\nAssinale a alternativa que N�O corresponde �s fun��es ou defini��es do protocolo",
					new String[] {
							"A informa��o que precisa ser transmitida entre origem e destino",
							"Como e quando mensagens de erro e de sistema s�o passadas entre dispositivos",
							"O m�todo pelo qual os dispositivos de rede compartilham informa��es sobre rotas com outras redes",
							"O formato ou estrutura da mensagem",
							"A configura��o e t�rmino das se��es de transfer�ncia de dados" },
					0));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"Os dispositivos de uma rede s�o os equipamentos que se conectam nela para transmitir informa��es. Podem ser classificados em:"
							+ "\n\nFinais: originam e geram informa��es, fazem a interface com o usu�rio e a rede;"
							+ "\n\nIntermedi�rios: realizam a comunica��o entre dispositivos finais;"
							+ "\n\nAssinale a alternativa em que os dispositivos s�o classificados corretamente.",
					new String[] {
							"Dispositivos finais: Servidor e Roteador"
									+ "\nDispositivos intermedi�rios: PC e Switch",
							"Dispositivos finais: Servidor e PC "
									+ "\nDispositivos intermedi�rios: Notebook e Switch",
							"Dispositivos finais: Notebook e Servidor "
									+ "\nDispositivos intermedi�rios: Hub e Switch",
							"Dispositivos finais: Roteador e Hub"
									+ "Dispositivos intermedi�rios: Switch e PC",
							"Dispositivos finais: Hub e Notebook"
									+ "\nDispositivos intermedi�rios: PC e Switch" },
					2));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"Sobre o tipo de comunica��o em uma rede de computadores, "
							+ "assinale a alternativa que define corretamente a comunica��o BROADCAST",
					new String[] {
							"Um �nico dispositivo envia uma mensagem para um destino �nico",
							"Transmite a informa��o para todos os dispositivos dentro de uma determinada rede ou sub-rede",
							"A informa��o � passada � um determinado grupo de destino dentro da rede",
							"� a uni�o das comunica��es Unicast e Multicast",
							"S� � poss�vel configur�-la usando cabos de fibra �tica" },
					1));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"Tamb�m chamada de rede local, os computadores que fazem parte desta rede "
							+ "est�o fisicamente localizados em um mesmo espa�o f�sico, tal como uma sala, um andar de um pr�dio e etc."
							+ "\n\nA defini��o acima se refere a uma rede:",
					new String[] { "MAN", "WAN", "SAN", "WWLAN", "LAN" }, 4));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"Nas redes cliente/servidor as fun��es de ambos s�o bem definidas, "
							+ "o servidor tem a fun��o de fornecer servi�os ou recursos para os clientes "
							+ "da rede, enquanto que o cliente tem a fun��o de utilizar os servi�os e recursos oferecidos. "
							+ "\n\nAssinale a alternativa que descreve uma desvantagem desse tipo de rede",
					new String[] {
							"� menos segura que uma rede ponto a ponto",
							"N�o � poss�vel fazer o backup dos dados em um local central",
							"Exige pessoal e software especializados para a opera��o e administra��o da rede",
							"Cada usu�rio precisa ser treinado para realizar tarefas administrativas",
							"N�o se adapta os crescimento da rede pois se torna mais dif�cil de ser gerenciada" },
					2));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"O modelo de refer�ncia OSI � um tipo de abordagem da arquitetura de camadas e � dividido em sete camadas distintas: F�sica, Enlace, Rede, Transporte, Sess�o, Apresenta��o e Aplica��o. "
							+ "\n\nAssinale a alternativa que define corretamente a camada de aplica��o",
					new String[] {
							"Fornece a interface de comunica��o entre o usu�rio e a rede",
							"� respons�vel pelo endere�amento de rede",
							"Realiza a transmiss�o bin�ria atrav�s do fio",
							"Controla o acesso ao meio de rede",
							"Fornece a estrutura e formata��o dos dados" }, 0));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"Qual a fun��o do protocolo HTTP?",
					new String[] {
							"Transferir arquivos de um computador para outro, copiando e movendo arquivos de servidores para clientes e vice-versa",
							"Transferir e-mails entre servidores de e-mail",
							"Fornecer dinamicamente as informa��es de comunica��o necess�rias para dispositivos finais poderem se comunicar",
							"Transferir p�ginas da web, hipertextos",
							"Trocar informa��es de gerenciamento entre dispositivos de uma rede" },
					3));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"Este protocolo tem a fun��o de traduzir nomes de dom�nio em endere�os de IPs e vice-versa"
							+ "\n\nA defini��o dada refere-se � um protocolo de comunica��o",
					new String[] { "DHCP", "HTTP", "DNS", "FTP", "HTTPS" }, 2));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"Fornece dinamicamente as informa��es de comunica��o necess�rias para dispositivos "
							+ "finais poderem se comunicar tais como IP, m�scara, gateway e DNS"
							+ "\n\nA defini��o dada refere-se � um protocolo de comunica��o",
					new String[] { "DHCP", "SMTP", "DNS", "HTTPS", "SNMP" }, 0));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void instanciaGeralQsts() {
		
		
		try {
			addGeneralQuestion(new Question(
					"Quais s�o os tipos de redes de computadores, assinale a alternativa correta", new String[] {
							"LAN, MAN, NAN", "MAN, PAN, FAN",
							"PAN, DAN, WAN", "LAN, MAN, WAN",
							"LAN, TAM, WAN" }, 3));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			addGeneralQuestion(new Question(
					"Para a aplica��o Web, o agente usu�rio �:", new String[] {
							"O monitor do usu�rio", "O teclado do usu�rio",
							"O mouse do usu�rio", "A internet",
							"Nenhuma das respostas acima" }, 3));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addGeneralQuestion(new Question(
					"A telefonia por Internet roda tipicamente sobre o protocolo:",
					new String[] { "UDP", "HTTP", "TCP", "IP",
							"Nenhuma das respostas acima" }, 0));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addGeneralQuestion(new Question(
					"O protocolo SMTP � usado para:",
					new String[] {
							"Transferir mensagens de um servidor de correio para outro",
							"Definir o formato dos cabe�alhos de mensagem",
							"Transferir mensagens de um servidor de correio para um agente usu�rio",
							"Baixar um enail do servidor de um email local",
							"Todas as respostas acima" }, 2));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			addGeneralQuestion(new Question(
					"Um dos maiores padr�es 3G de acesso sem-fio �:",
					new String[] {
							"EDGE",	"GPRS", "IS-136", "FTP",
							"Nenhuma das alternativas anteriores" }, 4));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			addGeneralQuestion(new Question(
					"Servidores de nome DNS locais:",
					new String[] {
							"Fazem cache de registros de recursos e nunca os descartam", 
							"Fazem cache de registros de recursos, mas descartam-nos ap�s um per�odo de tempo da ordem de alguns dias", 
							"Nunca fazem cache de registros de recursos", 
							"Obt�m registros de recursos dos caches Web",
							"Nenhuma das alternativas anteriores" }, 1));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			addGeneralQuestion(new Question(
					"Quando um segmento TCP chega a um hospedeiro, a porta ao qual o segmento ser� dirigido depende:",
					new String[] {
							"do endere�o IP da fonte do datagrama que encapsulou o segmento", 
							"do n�mero da porta da fonte", 
							"do n�mero da porta do destino", 
							"do conte�do do segmento",
							"Todas as alternativas acima"}, 3));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			addGeneralQuestion(new Question(
					"Um quadro de sinaliza��o enviado por um AP (ponto de acesso) inclui:",
					new String[] {
							"o SSID do AP", 
							"o endere�o MAC e o SSIP do AP", 
							"o endere�o MAC do AP", 
							"o ip do AP",
							"Nenhuma das alternativas"}, 1));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			addGeneralQuestion(new Question(
					"Que espa�o de disco ocupa uma can��o MP-3 de 3 minutos?",
					new String[] {
							"menos de 100 kbytes", 
							"entre 1 Mbyte e 10 Mbytes", 
							"entre 100 kbytes e 1 Mbyte", 
							"mais de 10 Mbytes",
							"Nenhuma das alternativas"}, 1));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			addGeneralQuestion(new Question(
					"Um roteador de servi�os diferenciados, distingue entre fluxos de pacote usando",
					new String[] {
							"endere�o IP de fonte do pacote", 
							"endere�o IP de fonte e marca��es do pacote", 
							"marca��es do pacote", 
							"conte�do do pacote",
							"Nenhuma das alternativas"}, 2 ));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
