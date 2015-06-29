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
					"As distorções sistemáticas são um tipo de perturbação nos canais "
							+ "de comunicação de uma rede e ocorrem sempre que é enviada uma "
							+ "informação ou dado através do canal.\nSabendo disto, qual destas "
							+ "perturbações dos canais de comunicação NÃO é uma distorção sistemática?",
					new String[] { "RETARDO", "HARMÔNICA", "ATENUAÇÃO",
							"POLARIZAÇÃO", "DIAFONIA" }, 4));
		} catch (QuestionException e) {
			e.printStackTrace();
		}

		try {
			addCabeamentoQuestion(new CEQuestion(
					"Vários fatores podem prejudicar a qualidade do sinal de uma transmissão, esses "
							+ "fatores chamados de perturbações (ou distorções) dos canais de comunicação e "
							+ "estão divididos em: distorções sistemáticas e distorções aleatórias.\nAssinale "
							+ "a alternativa que contém apenas distorções aleatórias",
					new String[] { "AGITAÇÃO DE FASE – ECO - RUÍDO",
							"RUÍDO - HARMÔNICA - RETARDO",
							"ECO - CARACTERÍSTICA - RUÍDO",
							"PHASE HIT - ATENUAÇÃO - ECO",
							"DIAFONIA – POLARIZAÇÃO - RETARDO" }, 0));
		} catch (QuestionException e) {
			e.printStackTrace();
		}

		try {
			addCabeamentoQuestion(new CEQuestion(
					"Abaixo estão alguns tipos de perturbações sistemáticas que ocorrem ao sinal durante sua transmissão e também suas definições. "
							+ "\n\nAssinale a alternativa que os relacione corretamente."
							+ "\n\nTermos:\n1- RETARDO         2- ATENUAÇÃO        3- HARMÔNICA"
							+ "\n\nDefinições:"
							+ "\nA – Atrasos na frequência de um sinal, chegando a causar deformação no sinal transmitido."
							+ "\nB – Deformações da perda de potência do sinal, causadas por cabos, filtros, etc."
							+ "\nC – Chamada também de deformação linear, esse tipo de deformação é causada quando o sinal passa por etapas de amplificação.",
					new String[] { "1-B 2-A 3-C", "1-A 2-C 3-B", "1-A 2-B 3-C",
							"1-C 2-B 3-A", "1-C 2-A 3-B" }, 2));
		} catch (QuestionException e) {
			e.printStackTrace();
		}
		try {
			addCabeamentoQuestion(new CEQuestion(
					"Abaixo estão alguns tipos de perturbações aleatórias que podem ocorrer ao sinal durante sua transmissão e também suas definições. "
							+ "\n\nAssinale a alternativa que os relacione corretamente."
							+ "\n\nTermos:\n1- ECO         2- RUÍDO        3- DIAFONIA"
							+ "\n\nDefinições:"
							+ "\nA – São distúrbios elétricos que ocorrem, ocasionalmente, em uma transmissão. Podem ser classificados em: térmicos e impulsivos."
							+ "\nB – Também chamado de crosstalk; Ocorre quando um par de fios causa interferência em outro par."
							+ "\nC – Nos sinais elétricos esse fenômeno é a reflexão do sinal ou de parte dele ao longo do meio.",
					new String[] { "1-B 2-A 3-C", "1-A 2-C 3-B", "1-A 2-B 3-C",
							"1-C 2-B 3-A", "1-C 2-A 3-B" }, 4));
		} catch (QuestionException e) {
			e.printStackTrace();
		}

		try {
			addCabeamentoQuestion(new CEQuestion(
					"Para elaborar um sistema de cabeamentos estruturado eficaz e imune a interferências é fundamental "
							+ "conhecer como ele funciona, que parâmetros elétricos estão envolvidos na transmissão de uma informação. "
							+ "\nJulgue os itens a seguir sobre os parâmetros elétricos que modelam os canais de transmissão"
							+ "\n\nI - Um corpo é resistente eletricamente quando apresenta dificuldade na condução de corrente elétrica"
							+ "\n\nII - A indutância atua como um controlador da corrente elétrica e é dependente da frequência. Sua unidade de media é o Farad"
							+ "\n\nIII - A capacitância mútua é uma característica que os condutores elétricos possuem de absorver energia e armazená-las por um período de tempo"
							+ "\n\nIV - O ganho de potência de um sinal ao longo de um segmento de cabo é chamado de atenuação e é medido em decibéis."
							+ "\n\nV – Condutância é medida em Siemens e é o oposto de resistência, ou seja, é a capacidade de conduzir corrente elétrica",
					new String[] {
							"Apenas as afirmações I, II e IV são verdadeiras",
							"Apenas as afirmações I, III e V são verdadeiras",
							"Apenas as afirmações II, IV e V são verdadeiras",
							"Apenas as afirmações IV e V são verdadeiras",
							"Todas as afirmações são verdadeiras" }, 1));
		} catch (QuestionException e) {
			e.printStackTrace();
		}

	}

	private void instanciaArquiteturaQsts() {
		try {
			addArquiteturaQuestions(new ARQuestion(
					"Os elementos da rede são requisitos necessários para que ocorra "
							+ "a transmissão de informações em uma rede de computadores. "
							+ "\nAssinale a alternativa que lista corretamente esses elementos.",
					new String[] {
							"WI-FI, DISPOSITIVOS, REDE LAN, SER HUMANO",
							"MENSAGEM, DISPOSITIVOS, REDE CLIENTE/SERVIDOR, TCP/IP",
							"TCP/IP, MEIO FÍSICO, SERVIDOR, MENSAGEM",
							"REGRAS, DISPOSITIVOS, MEIO FÍSICO, MENSAGEM",
							"REGRAS, DISPOSITIVOS, SER HUMANO, MENSAGEM" }, 3));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"Os protocolos de comunicação de uma rede são necessários para "
							+ "organizar a comunicação propriamente dita. São  exemplos de "
							+ "protocolo: TCP, IP, IPX, UPD. "
							+ "\nAssinale a alternativa que NÃO corresponde às funções ou definições do protocolo",
					new String[] {
							"A informação que precisa ser transmitida entre origem e destino",
							"Como e quando mensagens de erro e de sistema são passadas entre dispositivos",
							"O método pelo qual os dispositivos de rede compartilham informações sobre rotas com outras redes",
							"O formato ou estrutura da mensagem",
							"A configuração e término das seções de transferência de dados" },
					0));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"Os dispositivos de uma rede são os equipamentos que se conectam nela para transmitir informações. Podem ser classificados em:"
							+ "\n\nFinais: originam e geram informações, fazem a interface com o usuário e a rede;"
							+ "\n\nIntermediários: realizam a comunicação entre dispositivos finais;"
							+ "\n\nAssinale a alternativa em que os dispositivos são classificados corretamente.",
					new String[] {
							"Dispositivos finais: Servidor e Roteador"
									+ "\nDispositivos intermediários: PC e Switch",
							"Dispositivos finais: Servidor e PC "
									+ "\nDispositivos intermediários: Notebook e Switch",
							"Dispositivos finais: Notebook e Servidor "
									+ "\nDispositivos intermediários: Hub e Switch",
							"Dispositivos finais: Roteador e Hub"
									+ "Dispositivos intermediários: Switch e PC",
							"Dispositivos finais: Hub e Notebook"
									+ "\nDispositivos intermediários: PC e Switch" },
					2));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"Sobre o tipo de comunicação em uma rede de computadores, "
							+ "assinale a alternativa que define corretamente a comunicação BROADCAST",
					new String[] {
							"Um único dispositivo envia uma mensagem para um destino único",
							"Transmite a informação para todos os dispositivos dentro de uma determinada rede ou sub-rede",
							"A informação é passada à um determinado grupo de destino dentro da rede",
							"É a união das comunicações Unicast e Multicast",
							"Só é possível configurá-la usando cabos de fibra ótica" },
					1));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"Também chamada de rede local, os computadores que fazem parte desta rede "
							+ "estão fisicamente localizados em um mesmo espaço físico, tal como uma sala, um andar de um prédio e etc."
							+ "\n\nA definição acima se refere a uma rede:",
					new String[] { "MAN", "WAN", "SAN", "WWLAN", "LAN" }, 4));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"Nas redes cliente/servidor as funções de ambos são bem definidas, "
							+ "o servidor tem a função de fornecer serviços ou recursos para os clientes "
							+ "da rede, enquanto que o cliente tem a função de utilizar os serviços e recursos oferecidos. "
							+ "\n\nAssinale a alternativa que descreve uma desvantagem desse tipo de rede",
					new String[] {
							"É menos segura que uma rede ponto a ponto",
							"Não é possível fazer o backup dos dados em um local central",
							"Exige pessoal e software especializados para a operação e administração da rede",
							"Cada usuário precisa ser treinado para realizar tarefas administrativas",
							"Não se adapta os crescimento da rede pois se torna mais difícil de ser gerenciada" },
					2));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"O modelo de referência OSI é um tipo de abordagem da arquitetura de camadas e é dividido em sete camadas distintas: Física, Enlace, Rede, Transporte, Sessão, Apresentação e Aplicação. "
							+ "\n\nAssinale a alternativa que define corretamente a camada de aplicação",
					new String[] {
							"Fornece a interface de comunicação entre o usuário e a rede",
							"É responsável pelo endereçamento de rede",
							"Realiza a transmissão binária através do fio",
							"Controla o acesso ao meio de rede",
							"Fornece a estrutura e formatação dos dados" }, 0));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"Qual a função do protocolo HTTP?",
					new String[] {
							"Transferir arquivos de um computador para outro, copiando e movendo arquivos de servidores para clientes e vice-versa",
							"Transferir e-mails entre servidores de e-mail",
							"Fornecer dinamicamente as informações de comunicação necessárias para dispositivos finais poderem se comunicar",
							"Transferir páginas da web, hipertextos",
							"Trocar informações de gerenciamento entre dispositivos de uma rede" },
					3));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"Este protocolo tem a função de traduzir nomes de domínio em endereços de IPs e vice-versa"
							+ "\n\nA definição dada refere-se à um protocolo de comunicação",
					new String[] { "DHCP", "HTTP", "DNS", "FTP", "HTTPS" }, 2));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addArquiteturaQuestions(new ARQuestion(
					"Fornece dinamicamente as informações de comunicação necessárias para dispositivos "
							+ "finais poderem se comunicar tais como IP, máscara, gateway e DNS"
							+ "\n\nA definição dada refere-se à um protocolo de comunicação",
					new String[] { "DHCP", "SMTP", "DNS", "HTTPS", "SNMP" }, 0));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void instanciaGeralQsts() {
		
		
		try {
			addGeneralQuestion(new Question(
					"Quais são os tipos de redes de computadores, assinale a alternativa correta", new String[] {
							"LAN, MAN, NAN", "MAN, PAN, FAN",
							"PAN, DAN, WAN", "LAN, MAN, WAN",
							"LAN, TAM, WAN" }, 3));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			addGeneralQuestion(new Question(
					"Para a aplicação Web, o agente usuário é:", new String[] {
							"O monitor do usuário", "O teclado do usuário",
							"O mouse do usuário", "A internet",
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
					"O protocolo SMTP é usado para:",
					new String[] {
							"Transferir mensagens de um servidor de correio para outro",
							"Definir o formato dos cabeçalhos de mensagem",
							"Transferir mensagens de um servidor de correio para um agente usuário",
							"Baixar um enail do servidor de um email local",
							"Todas as respostas acima" }, 2));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			addGeneralQuestion(new Question(
					"Um dos maiores padrões 3G de acesso sem-fio é:",
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
							"Fazem cache de registros de recursos, mas descartam-nos após um período de tempo da ordem de alguns dias", 
							"Nunca fazem cache de registros de recursos", 
							"Obtêm registros de recursos dos caches Web",
							"Nenhuma das alternativas anteriores" }, 1));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			addGeneralQuestion(new Question(
					"Quando um segmento TCP chega a um hospedeiro, a porta ao qual o segmento será dirigido depende:",
					new String[] {
							"do endereço IP da fonte do datagrama que encapsulou o segmento", 
							"do número da porta da fonte", 
							"do número da porta do destino", 
							"do conteúdo do segmento",
							"Todas as alternativas acima"}, 3));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			addGeneralQuestion(new Question(
					"Um quadro de sinalização enviado por um AP (ponto de acesso) inclui:",
					new String[] {
							"o SSID do AP", 
							"o endereço MAC e o SSIP do AP", 
							"o endereço MAC do AP", 
							"o ip do AP",
							"Nenhuma das alternativas"}, 1));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			addGeneralQuestion(new Question(
					"Que espaço de disco ocupa uma canção MP-3 de 3 minutos?",
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
					"Um roteador de serviços diferenciados, distingue entre fluxos de pacote usando",
					new String[] {
							"endereço IP de fonte do pacote", 
							"endereço IP de fonte e marcações do pacote", 
							"marcações do pacote", 
							"conteúdo do pacote",
							"Nenhuma das alternativas"}, 2 ));
		} catch (QuestionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
